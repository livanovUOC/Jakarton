/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Usuario;

import java.sql.SQLException;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class LDAPUsuarioDAO implements InterfazDAO<Usuario>{
    
    private ListadoUsuarios listadoUsuarios;
    
    // CONSTRUCTORES
    
  	/**
  	 * Constructor que crea una instancia de patrón DAO.
  	 * Al inicializarse obtiene los datos provenientes de la persistencia
  	 */
    public LDAPUsuarioDAO()
    {
    	try {
        	// Rescata Datos de la persistencia
        	getTodos();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}        
    }
    
    /**
 	 * Constructor que crea una instancia de patrón DAO con una lista de usuarios predeterminada.
 	 * 
 	 * @param listadoUsuarios lista de usuarios predeterminada
 	 */
    public LDAPUsuarioDAO(ListadoUsuarios listadoUsuarios)
    {
        super();
        this.listadoUsuarios = null;//listadoUsuarios;
    }    
    
    /**
	 * Metodo accesor de lectura que nos da el listado de usuarios.
	 * 
	 * @return Nos devuelve el listado de usuarios. 
	 */
    public ListadoUsuarios getUsuarios() {
    	return listadoUsuarios;
    }
    
    /**
	 * Metodo accesor de lectura que se encarga de obtener los datos desde la persistencia
	 * 
	 * @return devuelve una lista de los datos recuperados. O en caso de no existir datos, devuelve una lista vacía
	 */
    @Override
    public List<Usuario> getTodos() throws SQLException {

        return null;
    }
    
    /**
	 * Metodo accesor de escritura que añade un usuario a la lista
	 * 
	 * @param user Usuario a añadir
	 */
    @Override
    public void crearElemento(Usuario user) throws SQLException {

    }
    
    /**
	 * Imprime la lista de usuarios
	 */
    @Override
    public void printTodos() throws SQLException {

    }
    
    /**
	 * Guarda todos los usuarios en la persistencia
	 */
    @Override
    public void saveTodos() throws SQLException {
    	// No Aplica
        
    }
    
    @Override
	public void eliminaElemento(Usuario user) throws Exception {

	}
}