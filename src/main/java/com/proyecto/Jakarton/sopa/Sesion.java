package com.proyecto.Jakarton.sopa;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class Sesion {
	// Atributos
    private Boolean estado;
    private Usuario user;
    
    // CONSTRUCTORES
    
   	/**
   	 * Constructor básico
   	 */
    public Sesion()
    {
        super();
        this.estado = false;
        user = null;
    }
    
    /**
     * Método para hacer login
     * 
     */
    public Usuario login(String user, String pass) {
   	 	// Pendiente de acabar
    	return null;
    }
    
    /**
     * Método para hacer logout
     * 
     */
    public Boolean logout() {
   	 	// Pendiente de acabar
    	user = null;
    	estado = false;
    	return true;
    }
    
}
