package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Juego;
import com.proyecto.Jakarton.sopa.Palabra;
import com.proyecto.Jakarton.sopa.Usuario;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/
public abstract class FactoriaDAO {
    
    // Lista de tipos DAO soportado por la factoria.
	public static final int XML = 1;
	public static final int SQL = 2;
	public static final int LDAP = 3;

	// Hay un metodo para cada DAO que puede ser creado.
	// Las factorias tendran que implementar estos metodos.
	public abstract InterfazDAO<Usuario> getUsuarioDAO();
	public abstract InterfazDAO<Palabra> getPalabraDAO();
	public abstract InterfazDAO<Juego> getJuegoDAO();

	
	/**
	 * Método de clase con el cual seleccionamos el tipo de encapsulación que queremos usar
	 * 
	 * @param whichFactory sirve para escoger el tipo de factoría
	 *
	 */
	public static FactoriaDAO getDAOFactory(int whichFactory) {
		
		switch (whichFactory) {
			case 1: 
				return new XMLDAOFactory();
	        case 2: 
                return new SQLDAOFactory();
	        case 3: 
                return new LDAPDAOFactory();
	        default: 
	        	return null;
	    }
		
	}
    
}
