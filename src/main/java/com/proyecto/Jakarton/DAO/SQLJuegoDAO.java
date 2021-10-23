package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Juego;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class SQLJuegoDAO implements InterfazDAO<Juego>{
	
	private Juego juego;
   
   public SQLJuegoDAO(){
	   juego= new Juego();
       try {
       	getTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
   }
   
   // CONSTRUCTORES
   
  	/**
  	 * Constructor que crea una instancia de patrón DAO.
  	 * Al inicializarse obtiene los datos provenientes de la persistencia
  	 */
   @Override
   public void crearElemento(Juego elemento) throws SQLException 
   {
	   
	   // No Aplica
   }
   
   /**
	 * Metodo accesor de lectura que se encarga de obtener los datos desde la persistencia
	 * 
	 * @return devuelve una lista de los datos recuperados. O en caso de no existir datos, devuelve una lista vacía
	 */
   @Override
   public List<Juego> getTodos() throws SQLException {
	   
   	SQLConexion con = new SQLConexion();
	
	
		if(con.ConectarBasedeDatos()) {
			try{
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();  
	    		ResultSet rs=stmt.executeQuery("SELECT * FROM JUEGO");  
	    		while(rs.next()) {
	    			// Obtengo los datos de Juego
	    			juego.setNombre(rs.getString("nombre"));
	    			Juego.lastIndexUser = rs.getInt("lastIndexUser");
	    			Juego.lastIndexWord = rs.getInt("lastIndexWord");
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

       return null;
   }
   
   /**
	 * Imprime los datos del Juego
	 */
   @Override
   public void printTodos() throws SQLException {
       
       if (juego != null) 
       {
           System.out.println("El Juego registrado es " + juego.getNombre());
		    
	    } else {
	    	System.out.println("No existen datos de Juego.");
	    }
   }
   
   /**
	 * Guarda los datos del Juego en la persistencia
	 */
   @Override
   public void saveTodos() throws SQLException {
       // No aplica
   }

	@Override
	public void eliminaElemento(Juego elemento) throws Exception {
		// No Aplica
		
	}
	
	public Juego getJuego() {
		return this.juego;
	}
}