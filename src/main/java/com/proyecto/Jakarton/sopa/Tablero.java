package com.proyecto.Jakarton.sopa;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class Tablero {
	// Atributos
    private int filas;
    private int columnas;
    private char[][] tablero;
    ArrayList<Palabra> palabras;
    
 // CONSTRUCTORES
    
   	/**
   	 * Constructor básico
   	*/
    public Tablero()
    {
        super();
    }

    /**
   	 Constructor que inicializa con información determinada
   	 * 
   	 * @param filas
   	 * @param columnas
   	*/
    public Tablero(int filas, int columnas) {
     	this.filas = filas;
     	this.columnas = columnas;
     	this.tablero = new char[filas][columnas];
     	
     	// Inicializo el tablero
     	initTablero();
    }
    
    /**
     * Método privado para inicializar el tablero
    */
    private void initTablero() {
       for (char[] cs : tablero) {
       		for (char c : cs) {
       			c = ' ';	// Se define ' ' como char por defecto
       		}
       }
    }
    
    /**
     * Método privado para comprobar si una palabra se puede escribir en la Matriz
     * 
     * @return resultado del checkeo
    */
    private Boolean checkWord(Palabra palabra) {
    	// Pendiente
    	return true;
    }
     
     /**
      * Método de acceso de lectura
      * 
      * @return Devuelve la Matriz del Tablero
      */
      public char[][] getTablero() {
    	  return this.tablero;
      }
     
      /**
       * Método de acceso de lectura
       * 
       * @return Devuelve coordenadas de hueco para palabra o Null en caso de no existir
       */
       public int[][] buscaHueco(Palabra palabra) {
    	   return null;
       }
       
    /**
   	 * Metodo accesor de lectura que nos da el listado de palabras.
   	 * 
   	 * @return Nos devuelve el listado de palabras. 
   	 */
    public List<Palabra> getPalabras() {
        return palabras;
    }
      
     /**
      * Método de acceso de escritura
      * 
      * @param palabra Palabra a escribir en Matriz
      */
      public Boolean escribirPalabra(Palabra palabra) {
    	// Pendiente de acabar
    	  
    	  Boolean result = checkWord(palabra);
    	  
          return result;	
      }
     
     /**
      * Método para inicializar tablero
      * 
      */
     public void borraTablero(Palabra palabra) {
    	 // Pendiente de acabar
     	 initTablero();
     	 palabras = null;
     }
     
}
