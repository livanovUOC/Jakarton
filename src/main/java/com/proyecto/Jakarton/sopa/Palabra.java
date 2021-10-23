package com.proyecto.Jakarton.sopa;

import javax.xml.bind.annotation.*;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/
@XmlRootElement(name = "palabra")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder={"idPalabra", "palabra", "longitud", "coordX", "coordY", "direccion"})
public class Palabra {
	// Atributos
    private int idPalabra;
    private String palabra;
    private int longitud;
    private int coordX;
    private int coordY;
    private int direccion;
    
 // CONSTRUCTORES
    
   	/**
   	 * Constructor básico
   	*/
    public Palabra()
    {
        super();
    }

    /**
   	* Constructor que inicializa con información determinada
   	* 
   	* @param idPalabra
   	* @param palabra
   	* @param longitud
   	* @param coordX
   	* @param coordY
   	* @param direccion
   	* 
   	*/
    public Palabra(String palabra, int longitud, int coordX, int coordY, int direccion) {
    	Juego.lastIndexWord++;
   	 	this.idPalabra = Juego.lastIndexWord;
     	this.palabra = palabra;
     	this.longitud = longitud;
     	this.coordX = coordX;
     	this.coordY = coordY;
     	this.direccion = direccion;
    }
    
    /**
  	* Método de acceso de lectura
  	* 
  	* @return Devuelve el ID de la palabra
  	*/
    @XmlElement(name="idPalabra")
    public int getIdPalabra() {
        return idPalabra;
    }
    
    /**
   	* Método de acceso de lectura
   	* 
   	* @return Devuelve la palabra en sí
   	*/
    @XmlElement(name="palabra")
    public String getPalabra() {
        return palabra;
    }
    
    /**
  	* Método de acceso de lectura
  	* 
  	* @return Devuelve la longitud de la palabra
  	*/
    @XmlElement(name="longitud")
    public int getLongitud() {
        return longitud;
    }
    
    /**
  	* Método de acceso de lectura
  	* 
  	* @return Devuelve la coordX
  	*/
    @XmlElement(name="coordX")
    public int getCoodX() {
        return coordX;
    }
    
    /**
  	* Método de acceso de lectura
  	* 
  	* @return Devuelve la coordY
  	*/
    @XmlElement(name="coordY")
    public int getCoodY() {
        return coordY;
    }
    
    /**
  	* Método de acceso de lectura
  	* 
  	* @return Devuelve la dirección de la palabra
  	*/
    @XmlElement(name="direccion")
    public int getDireccion() {
        return direccion;
    }
    
    /**
  	  * Convierte los datos de una instancia de clase a String
  	  * 
  	  * @return Devuelve los datos del usuario transformados a String
  	  */
     @Override
     public String toString() {
         return "palabra: " + palabra + "\n coordX=" + coordX + ", coordY=" + coordY;
     }   
}
