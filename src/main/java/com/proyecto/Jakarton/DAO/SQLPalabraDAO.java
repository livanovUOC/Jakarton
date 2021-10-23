package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Palabra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class SQLPalabraDAO implements InterfazDAO<Palabra>{
    
    private ListadoPalabras listadoPalabras;
    
    // CONSTRUCTORES
    
  	/**
  	 * Constructor que crea una instancia de patrón DAO.
  	 * Al inicializarse obtiene los datos provenientes de la persistencia
  	 */
    public SQLPalabraDAO()
    {
    	try {
        	// Rescata Datos de la persistencia
        	getTodos();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}        
    }
    
    /**
 	 * Constructor que crea una instancia de patrón DAO con una lista de palabras predeterminada.
 	 * 
 	 * @param listadoPalabras lista de palabras predeterminada
 	 */
    public SQLPalabraDAO(ListadoPalabras listadoPalabras)
    {
        super();
        this.listadoPalabras = listadoPalabras;
    }    
    
    /**
	 * Metodo accesor de lectura que nos da el listado de palabras.
	 * 
	 * @return Nos devuelve el listado de palabras. 
	 */
    public ListadoPalabras getPalabras() {
    	return listadoPalabras;
    }
    
    /**
	 * Metodo accesor de lectura que se encarga de obtener los datos desde la persistencia
	 * 
	 * @return devuelve una lista de los datos recuperados. O en caso de no existir datos, devuelve una lista vacía
	 */
    @Override
    public List<Palabra> getTodos() throws SQLException {
    	SQLConexion con = new SQLConexion();
    	
    	listadoPalabras = new ListadoPalabras();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
    			Palabra word = null;
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();  
	    		ResultSet rs=stmt.executeQuery("SELECT * FROM PALABRA");  
	    		while(rs.next()) {
	    			// Recorro todas las palabras guardadas en persistencia
	    			word = new Palabra(rs.getString("palabra"), rs.getInt("longitud"), rs.getInt("coordX"), rs.getInt("coordY"), rs.getInt("direccion"));
	    			listadoPalabras.addPalabra(word);
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

        return listadoPalabras.getListadoPalabras();
    }
    
    /**
	 * Metodo accesor de escritura que añade un palabra a la lista
	 * 
	 * @param elemento Palabra a añadir 
	 */
    @Override
    public void crearElemento(Palabra word) throws SQLException {
    	
    	// Añado al listado
        listadoPalabras.addPalabra(word);
        // Guardo en la persistencia
        SQLConexion con = new SQLConexion();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
	    		// Si ya existe Base de Datos
	    		PreparedStatement stmt = con.getConnection().prepareStatement("INSERT INTO PALABRA VALUES(?,?,?,?,?,?)");
	    		stmt.setInt(1, word.getIdPalabra());
	    		stmt.setString(2, word.getPalabra());
	    		stmt.setInt(3, word.getLongitud());
	    		stmt.setInt(4, word.getCoodX());
	    		stmt.setInt(5, word.getCoodY());
	    		stmt.setInt(6, word.getDireccion());
	    		
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
        
       
        System.out.println("Se ha creado la palabra con índice número: "+word.getIdPalabra());
    }
    
    /**
	 * Imprime la lista de palabras
	 */
    @Override
    public void printTodos() throws SQLException {
        
        if (listadoPalabras.getListadoPalabras().size() > 0) 
        {
            System.out.println("El Juego cuenta con " + listadoPalabras.getListadoPalabras().size() + " palabras:");
	    
            for (Palabra w : listadoPalabras.getListadoPalabras()) {
	    		System.out.println(w.toString());
            }
		    
	    } else {
	    	System.out.println("La lista de palabras está vacía.");
	    }
    }
    
    /**
	 * Guarda todos los palabras en la persistencia
	 */
    @Override
    public void saveTodos() throws SQLException {
    	// No Aplica
        
    }
    
    @Override
	public void eliminaElemento(Palabra word) throws Exception {
        // Elimino de la persistencia
        SQLConexion con = new SQLConexion();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
	    		// Si ya existe Base de Datos
	    		PreparedStatement stmt = con.getConnection().prepareStatement("DELETE FROM PALABRA WHERE idPalabra = ?");
	    		stmt.setInt(1, word.getIdPalabra());
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
