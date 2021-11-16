package com.proyecto.Jakarton.sopa;

import com.proyecto.Jakarton.DAO.ListadoPalabras;
import com.proyecto.Jakarton.DAO.ListadoUsuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class Tablero {
	// Atributos
    private int filas;
    private int columnas;
    private char[][] tablero;
    public ArrayList<Palabra> palabras;
    
 // CONSTRUCTORES
    
   	/**
   	 * Constructor básico
   	*/
    public Tablero()
    {
        super();
        this.palabras = new ArrayList<Palabra>();
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
        this.palabras = new ArrayList<Palabra>();
     	
     	// Inicializo el tablero
     	initTablero();
    }
    
    /**
     * Método privado para inicializar el tablero
    */
    private void initTablero() {
        for (int f=0;f<filas;f++) {
            for (int c=0;c<columnas;c++) {
                tablero[f][c] = ' ';
            }
        }
    }

    /**
     * Método público para imprimir el tablero
     */
    public char[][] printTablero() {
        initTablero();

        ArrayList<Palabra> listaPalabras = palabras;
        Palabra word = null;

        for (int i=0;i<listaPalabras.size();i++) {
            word = listaPalabras.get(i);
            escribirPalabra(word);
        }

        Random random = null;
        char randomizedCharacter = ' ';

        for (int f=0;f<filas;f++) {
            for (int c=0;c<columnas;c++) {
                if(Character.compare(tablero[f][c], ' ') == 0){
                    random = new Random();

                    tablero[f][c] = (char) (random.nextInt(26) + 'A');
                }
            }
        }

        return this.tablero;
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
    	  int x = palabra.getCoodX();
          int y = palabra.getCoodY();
          int sentido = palabra.getDireccion();

    	  for(int i=0;i<palabra.getLongitud();i++){
    	      if(sentido == 0){
    	          tablero[x][y] = palabra.getPalabra().toUpperCase().charAt(i);
    	          y += 1;
              }
    	      else{
                  tablero[x][y] = palabra.getPalabra().toUpperCase().charAt(i);
                  x += 1;
              }
          }
    	  
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

    /**
     * Método de acceso de lectura
     *
     * @return devuelve número de filas
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Método de acceso de lectura
     *
     * @return devuelve número de columnas
     */
    public int getColumnas() {
        return columnas;
    }
     
}
