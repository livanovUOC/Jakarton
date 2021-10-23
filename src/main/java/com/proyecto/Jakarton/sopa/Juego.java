package com.proyecto.Jakarton.sopa;

import com.proyecto.Jakarton.DAO.ListadoPalabras;
import com.proyecto.Jakarton.DAO.ListadoUsuarios;

import javax.xml.bind.annotation.*;


/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/
@XmlRootElement(name = "juego")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder={"idUsuario", "nombre", "apellidos", "email", "password"})

public class Juego {
	
	public static int lastIndexUser = 0;
	public static int lastIndexWord = 0;
	public static Sesion sesion = null;
	
	private String nombre;
	private ListadoUsuarios usuarios;
	private ListadoPalabras palabras;
	
	// CONSTRUCTORES
    
	/**
	 * Constructor básico
	 */
	public Juego() {
		
	}
		
	/**
	 * Constructor con datos de Juego
	 * 
	 * @param nombre
	 * @param u Lista de Usuarios del Juego
	 * @param p Lista de Palabras del Juego
	 * 
	 */
	public Juego(String nombre, ListadoUsuarios u, ListadoPalabras p) {
		this.nombre = nombre;
		this.usuarios = u;
		this.palabras = p;
	}
	
	/**
     * Este metodo nos permite agregar un usuario al Juego
     * 
     * @param u Usuario.
     */
    public void add(Usuario u) {

        usuarios.addUsuario(u);

    }
    
    /**
     * Este metodo nos permite agregar una palabra al Juego
     * 
     * @param p Palabra.
     */
    public void add(Palabra p) {

        palabras.addPalabra(p);
        
    }
    
    /**
 	 * Método de acceso de escritura
 	 * 
 	 * @param nombre
 	 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método de acceso de lectura
     * 
     * @return devuelve el nombre del Juego
     */
    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método de acceso de lectura
     * 
     * @return devuelve el último número de índice de Usuario
     */
    @XmlElement(name="lastIndexUser")
    public int getLastIndexUser() {
        return Juego.lastIndexUser;
    }
    
    /**
     * Método de acceso de lectura
     * 
     * @return devuelve el último número de índice de Palabra
     */
    @XmlElement(name="lastIndexWord")
    public int getLastIndexWord() {
        return Juego.lastIndexWord;
    }
    
    /**
     * Método de acceso de lectura
     * 
     * @return devuelve listado de usuarios del Juego
     */
    public ListadoUsuarios getUsuarios() {
        return usuarios;
    }
    
    /**
     * Método de acceso de lectura
     * 
     * @return devuelve listado de palabras del Juego
     */
    public ListadoPalabras getPalabras() {
        return palabras;
    }
}
