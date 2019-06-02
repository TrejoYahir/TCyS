/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyc.utils;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Yahir
 */

public class AudioManager {
    
    public static double[] read(String filename) {
        byte[] data = readByte(filename);
        int n = data.length;
        double[] d = new double[n/2];
        for (int i = 0; i < n/2; i++) {
            d[i] = ((short) (((data[2*i+1] & 0xFF) << 8) + (data[2*i] & 0xFF))) / ((double) Short.MAX_VALUE);
        }
        return d;
    }
    public static byte[] readByte(String filename) {
        byte[] data = null;
        AudioInputStream ais = null;
        try {

            // Intentar leer desde archivo
            File file = new File(filename);
            if (file.exists()) {
                ais = AudioSystem.getAudioInputStream(file);
                int bytesToRead = ais.available();
                data = new byte[bytesToRead];
                int bytesRead = ais.read(data);
                if (bytesToRead != bytesRead)
                    throw new IllegalStateException("Leídos solamente " + bytesRead + " de " + bytesToRead + " bytes"); 
                }

            // Intentar leer desde URL
            else {
                URL url = AudioManager.class.getResource(filename);
                ais = AudioSystem.getAudioInputStream(url);
                int bytesToRead = ais.available();
                data = new byte[bytesToRead];
                int bytesRead = ais.read(data);
                if (bytesToRead != bytesRead)
                    throw new IllegalStateException("Leidos solamente " + bytesRead + " de " + bytesToRead + " bytes"); 
            }
        }
        catch (IOException e) {
            throw new IllegalArgumentException("No se pudo leer '" + filename + "'", e);
        }

        catch (UnsupportedAudioFileException e) {
            throw new IllegalArgumentException("Formato de audio no soportado: '" + filename + "'", e);
        }

        return data;
    }
    
    public static void save(String filename, double[] samples) {
        if (samples == null) {
            throw new IllegalArgumentException("samples[] is null");
        }

        // asume que hay 44,100 muestras por segundo
        // Usa audio de 16-bit, mono, firmado PCM, little Endian
        AudioFormat format = new AudioFormat(44100, 16, 1, true, false);
        byte[] data = new byte[2 * samples.length];
        for (int i = 0; i < samples.length; i++) {
            int temp = (short) (samples[i] * Short.MAX_VALUE);
            data[2*i + 0] = (byte) temp;
            data[2*i + 1] = (byte) (temp >> 8);
        }

        // guardar el archivo
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            AudioInputStream ais = new AudioInputStream(bais, format, samples.length);
            if (filename.endsWith(".wav") || filename.endsWith(".WAV")) {
                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File(filename));
            }
            else if (filename.endsWith(".au") || filename.endsWith(".AU")) {
                AudioSystem.write(ais, AudioFileFormat.Type.AU, new File(filename));
            }
            else {
                throw new IllegalArgumentException("Formato de audio no soportado: '" + filename + "'");
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("No se pudo guardar '" + filename + "'", ioe);
        }
    }
    
    public static void play(String filename) {
        URL url = null;
        try {
            File file = new File(filename);
            if (file.canRead()) url = file.toURI().toURL();
        }
        catch (MalformedURLException e) {
            throw new IllegalArgumentException("No se pudo reproducir '" + filename + "'", e);
        }
        if (url == null) {
            throw new IllegalArgumentException("No se pudo reproducir '" + filename + "'");
        }

        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
    }
}
