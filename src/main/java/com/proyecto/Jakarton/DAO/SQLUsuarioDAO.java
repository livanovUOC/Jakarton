/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class SQLUsuarioDAO implements InterfazDAO<Usuario>{
    
    private ListadoUsuarios listadoUsuarios;
    
    // CONSTRUCTORES
    
  	/**
  	 * Constructor que crea una instancia de patrón DAO.
  	 * Al inicializarse obtiene los datos provenientes de la persistencia
  	 */
    public SQLUsuarioDAO()
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
    public SQLUsuarioDAO(ListadoUsuarios listadoUsuarios)
    {
        super();
        this.listadoUsuarios = listadoUsuarios;
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
    	SQLConexion con = new SQLConexion();
    	
    	listadoUsuarios = new ListadoUsuarios();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
    			Usuario user = null;
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();  
	    		ResultSet rs=stmt.executeQuery("SELECT * FROM USUARIO");  
	    		while(rs.next()) {
	    			// Recorro todas los USUARIOS guardados en persistencia
	    			user = new Usuario(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("password"));
	    			listadoUsuarios.addUsuario(user);
	    		}
    		}
    		catch(Exception e)
    		{ 
    			System.out.println(e);
    		}  
    	}
    	else {
    		return null;
    	}
    	
    	con.DesconectarBasedeDatos();

        return listadoUsuarios.getListadoUsuarios();
    }
    
    /**
	 * Metodo accesor de escritura que añade un usuario a la lista
	 * 
	 * @param elemento Usuario a añadir 
	 */
    @Override
    public void crearElemento(Usuario user) throws SQLException {
    	
    	// Añado al listado
        listadoUsuarios.addUsuario(user);
        // Guardo en la persistencia
        SQLConexion con = new SQLConexion();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
	    		// Si ya existe Base de Datos
	    		PreparedStatement stmt = con.getConnection().prepareStatement("INSERT INTO USUARIO VALUES(?,?,?,?,?)");
	    		stmt.setInt(1, user.getIdUsuario());
	    		stmt.setString(2, user.getNombre());
	    		stmt.setString(3, user.getApellidos());
	    		stmt.setString(4, user.getEmail());
	    		stmt.setString(5, user.getPassword());
	    		
	    		stmt.executeUpdate();
    		}
    		catch(Exception e)
    		{ 
    			System.out.println(e);
    		}  
    	}
    	else {
    		System.out.println("Problema de conexión a la Base de Datos");
    	}
    	
    	con.DesconectarBasedeDatos();
        
       
        System.out.println("Se ha creado el usuario con índice número: "+user.getIdUsuario());
    }
    
    /**
	 * Imprime la lista de usuarios
	 */
    @Override
    public void printTodos() throws SQLException {
        
        if (listadoUsuarios.getListadoUsuarios().size() > 0) 
        {
            System.out.println("El Juego cuenta con " + listadoUsuarios.getListadoUsuarios().size() + " usuarios:");
	    
            for (Usuario u : listadoUsuarios.getListadoUsuarios()) {
	    		System.out.println(u.toString());
            }
		    
	    } else {
	    	System.out.println("La lista de usuarios está vacía.");
	    }
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
        // Elimino de la persistencia
        SQLConexion con = new SQLConexion();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
	    		// Si ya existe Base de Datos
	    		PreparedStatement stmt = con.getConnection().prepareStatement("DELETE FROM USUARIO WHERE idUsuario = ?");
	    		stmt.setInt(1, user.getIdUsuario());
	    		stmt.executeUpdate();
    		}
    		catch(Exception e)
    		{ 
    			System.out.println(e);
    		}  
    	}
    	else {
    		System.out.println("Problema de conexión a la Base de Datos");
    	}
    	
    	con.DesconectarBasedeDatos();
		
	}
}
