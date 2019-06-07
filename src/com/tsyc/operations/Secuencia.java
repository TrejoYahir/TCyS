
package com.tsyc.operations;

public class Secuencia {
	public double[] valores;
	private int origen;
	private boolean periodica;
	private int longitud;

        public Secuencia (double[] valores){
            this.valores = valores;
            origen = 0;
            periodica = false;
            longitud = valores.length;
        }
        
	public Secuencia (String cadSecuencia,boolean periodica){
		int posicion = 0;
		int i;
		String cadAux = "";
		for (i = 0; i < cadSecuencia.length(); i++){
			if (cadSecuencia.charAt(i) == ',')
				posicion++;
			if (cadSecuencia.charAt(i) == '#'){
				origen = posicion;
				cadAux = cadSecuencia.substring(0,i) +cadSecuencia.substring(i+1,cadSecuencia.length());
			}
		}
		longitud = posicion + 1;
		valores = new double[longitud];
                                
		String[] cadenasValores = cadAux.split(",");
		for (i = 0; i < cadenasValores.length; i++){
			valores[i] = Float.parseFloat(cadenasValores[i]);
		}
		this.periodica = periodica;
	}

        @Override
	public String toString(){
                String secuencia = ""; 
		int i;
                secuencia += "Secuencia: {";
		for (i = 0; i < valores.length - 1; i++){
			secuencia += valores[i] + ",";
		}
                secuencia += valores[i] + "}\nOrigen: " + valores[origen] + "\nLongitud: " + longitud + "\n";
                if (periodica)
                    secuencia += "Secuencia periodica\n";
		return secuencia;
	}
        
        public Secuencia convolucionar(Secuencia secuencia){
            Secuencia convolucion;
            if (this.periodica == true){
                if (secuencia.periodica == true){
                    if (this.longitud < secuencia.longitud)
                        convolucion = this.convolucionCircular(secuencia);
                    else
                        convolucion = secuencia.convolucionCircular(this);
                    return convolucion;
                    //implementacion de la convolucion circular
                }
                else {
                    convolucion = this.convolucionPeriodica(secuencia);
                    return convolucion;
                    //implementacion de la convolucion periodica sobre this
                }
            }
            else{
                if (secuencia.periodica == true){
                    convolucion = secuencia.convolucionPeriodica(this);
                    return convolucion;
                    //implementacion de la convolucion periodica sobre secuencia
                }
                else {
                    convolucion = this.convolucionFinita(secuencia);
                    return convolucion;
                }
            }
        }

        private Secuencia convolucionFinita(Secuencia secuencia){
            int longitudConvolucion = secuencia.longitud + this.longitud - 1;
            double convolucionValores[] = new double[longitudConvolucion];
            int i,j;
            int origenConvolucion = this.origen + secuencia.origen;
            double convolucionValor;
            String cadenaValores = "";
            for (i = 0; i < longitudConvolucion; i++){
                convolucionValor = 0;
                for (j = 0; j < this.longitud; j++){
                    if ( i - j < 0 | i - j >= secuencia.longitud)
                        continue;
                    convolucionValor += this.valores[j] * secuencia.valores[i-j];
                }
                convolucionValores[i] = convolucionValor;
            }
            for (i = 0; i < longitudConvolucion - 1; i++){
                if (i == origenConvolucion)
                    cadenaValores += "#";
                cadenaValores += convolucionValores[i] + ",";
            }
            cadenaValores += convolucionValores[i];
            return new Secuencia(cadenaValores,false);
        }
        
        /*private Secuencia convolucionFinita(Secuencia secuencia){
            int longitudConvolucion = secuencia.longitud + this.longitud - 1;
            int i,j;
            double sumaColumna;
            int origenConvolucion = this.origen + secuencia.origen;
            System.out.println("La cosa es :" + this.longitud + " La otra cosa es: " + longitudConvolucion);
            double[][] productoFilaFila = new double[this.longitud][longitudConvolucion];
            String cadenaConvolucion = "";
            for (i = 0; i < this.longitud; i++){
                         for (j = 0; j < i; j++){
                             productoFilaFila[i][j] = 0;
                         }
                         for (; j < secuencia.longitud + i; j++){
                             productoFilaFila[i][j] = this.valores[i] * secuencia.valores[j - i];
                         }
                         for (; j < longitudConvolucion; j++){
                             productoFilaFila[i][j] = 0;
                         }
                     }
                     
                    // for (i = 0; i < this.longitud; i++){
                    //     for (j = 0; j < longitudConvolucion; j++){
                    //         System.out.print(productoFilaFila[i][j] + " ");
                    //     }
                    //     System.out.println();
                    // }
                     
                     for (j = 0; j < longitudConvolucion - 1; j++){
                         sumaColumna = 0;
                         for (i = 0; i < this.longitud; i++){
                             sumaColumna += productoFilaFila[i][j];
                         }
                         if (j == origenConvolucion)
                             cadenaConvolucion += "#";
                         cadenaConvolucion += sumaColumna + ",";
                     }
                     sumaColumna = 0;
                     for (i = 0; i < this.longitud; i++){
                         sumaColumna += productoFilaFila[i][j];
                     }
                     if (j == origenConvolucion)
                         cadenaConvolucion += "#";
                     cadenaConvolucion += sumaColumna;
                     return new Secuencia(cadenaConvolucion,false);
        }*/
        
        private Secuencia convolucionPeriodica(Secuencia secuencia){
            int longitudConvolucion = secuencia.longitud + this.longitud - 1;
            int i,j;
            double sumaColumna;
            double[] sumaColumnas = new double[longitudConvolucion];
            double[][] productoFilaFila = new double[this.longitud][longitudConvolucion];
            String cadenaConvolucion = "";
            int posicionCero = (this.origen + secuencia.origen) % this.longitud;
            for (i = 0; i < this.longitud; i++){
                         for (j = 0; j < i; j++){
                             productoFilaFila[i][j] = 0;
                         }
                         for (; j < secuencia.longitud + i; j++){
                             productoFilaFila[i][j] = this.valores[i] * secuencia.valores[j - i];
                         }
                         for (; j < longitudConvolucion; j++){
                             productoFilaFila[i][j] = 0;
                         }
                     }
                     
                     //for (i = 0; i < this.longitud; i++){
                     //    for (j = 0; j < longitudConvolucion; j++){
                     //        System.out.print(productoFilaFila[i][j] + " ");
                     //    }
                     //    System.out.println();
                     //}
                     
                     for (j = 0; j < longitudConvolucion; j++){
                         sumaColumna = 0;
                         for (i = 0; i < this.longitud; i++){
                             sumaColumna += productoFilaFila[i][j];
                         }
                         sumaColumnas[j] = sumaColumna;
                     }
                     
                     /*
                     for (i = 0; i < sumaColumnas.length; i++)
                        System.out.print(sumaColumnas[i] + " ");
                     System.out.println();
*/                     

                     for (i = 0; i < this.longitud - 1; i++){
                         sumaColumna = 0;
                         for (j = i; j < sumaColumnas.length; j += this.longitud){
                             sumaColumna += sumaColumnas[j];
                             //System.out.print(sumaColumna + ",");
                         }
                         //System.out.println();
                         if (i == posicionCero)
                             cadenaConvolucion += "#";
                         cadenaConvolucion += sumaColumna + ",";
                     }
                     sumaColumna = 0;
                         for (j = i; j < sumaColumnas.length; j += this.longitud){
                             sumaColumna += sumaColumnas[j];
                         }
                         if (i == posicionCero)
                             cadenaConvolucion += "#";
                         cadenaConvolucion += sumaColumna;
                     //25.5,44,27.5
                     System.out.println(cadenaConvolucion + ". Posicion Cero: " + posicionCero + ". Concha: " + (this.longitud + secuencia.longitud));
                     return new Secuencia(cadenaConvolucion,true);
        }
        
        private Secuencia convolucionCircular(Secuencia secuencia){
            int longitudConvolucion = secuencia.longitud + this.longitud - 1;
            int i,j;
            double sumaColumna;
            double[] sumaColumnas = new double[longitudConvolucion];
            double[][] productoFilaFila = new double[this.longitud][longitudConvolucion];
            String cadenaConvolucion = "";
            int posicionCero = (this.origen + secuencia.origen) % secuencia.longitud; 
            for (i = 0; i < this.longitud; i++){
                         for (j = 0; j < i; j++){
                             productoFilaFila[i][j] = 0;
                         }
                         for (; j < secuencia.longitud + i; j++){
                             productoFilaFila[i][j] = this.valores[i] * secuencia.valores[j - i];
                         }
                         for (; j < longitudConvolucion; j++){
                             productoFilaFila[i][j] = 0;
                         }
                     }
                     
                     /*for (i = 0; i < this.longitud; i++){
                         for (j = 0; j < longitudConvolucion; j++){
                             System.out.print(productoFilaFila[i][j] + " ");
                         }
                         System.out.println();
                     }*/
                     
                     for (j = 0; j < longitudConvolucion; j++){
                         sumaColumna = 0;
                         for (i = 0; i < this.longitud; i++){
                             sumaColumna += productoFilaFila[i][j];
                         }
                         sumaColumnas[j] = sumaColumna;
                     }
                     
                     
                    /* for (i = 0; i < sumaColumnas.length; i++)
                        System.out.print(sumaColumnas[i] + " ");
                     System.out.println();
                     */

                     for (i = 0; i < secuencia.longitud - 1; i++){
                         sumaColumna = 0;
                         for (j = i; j < sumaColumnas.length; j += secuencia.longitud){
                             sumaColumna += sumaColumnas[j];
                             //System.out.print(sumaColumna + ",");
                         }
                         //System.out.println();
                         if (i == posicionCero)
                             cadenaConvolucion += "#";
                         cadenaConvolucion += sumaColumna + ",";
                     }
                     sumaColumna = 0;
                         for (j = i; j < sumaColumnas.length; j += secuencia.longitud){
                             sumaColumna += sumaColumnas[j];
                         }
                         if (i == posicionCero)
                             cadenaConvolucion += "#";
                         cadenaConvolucion += sumaColumna;
                     //25.5,44,27.5
                     //System.out.println("si sale: "  + cadenaConvolucion);
                     return new Secuencia(cadenaConvolucion,true);
                     
                     
        }

    public double[] getValores() {
        return valores;
    }
        
        
        
 }