/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tysc.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author Yahir
 */
public class AudioRecorder implements Runnable {
 
    // Nombre del archivo
    File wavFile = new File("Grabacion.wav");
 
    // formato de audio
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // Línea de entrada de audio
    TargetDataLine line;
 
    /**
     * Define el formato de audio
     */
    AudioFormat getAudioFormat() {
        float sampleRate = 44100;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
    
    @Override
    public void run() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            // Revisa que la linea de entrada sea soportada
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Entrada de audio no soportada");
                System.exit(0);
            }

            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // empieza grabación
            AudioInputStream ais = new AudioInputStream(line);
            System.out.println("Grabación empezada");
            AudioSystem.write(ais, fileType, wavFile); 

        } catch (LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Grabación terminada");
            line.stop();
            line.close();
        }
    }
    
}
