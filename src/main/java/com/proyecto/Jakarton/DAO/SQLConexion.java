package com.proyecto.Jakarton.DAO;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Lucian, Javier, Pol, Oriol, Chadouli
 */
public class SQLConexion {
	
	// CAMPOS
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "Sopa";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "root";
		
    public Connection conexion;
    public PreparedStatement sentencia;
    public Statement stm;
    public ResultSet resultado;

	public Boolean ConectarBasedeDatos(){
		String databaseName = "";
		Boolean dbCheck = false;
	 try {
		 
	 Class.forName( driver );
	 conexion = DriverManager.getConnection(url,userName,password);
	 
	 resultado = conexion.getMetaData().getCatalogs();
	 while (resultado.next() && !dbCheck) {
		  // Get the database name, which is at position 1
		  databaseName = resultado.getString(1).toLowerCase();
		  dbCheck = databaseName.equals(dbName.toLowerCase());
	 }
		if(!dbCheck) {
			// Creo la Base de Datos
			sentencia = conexion.prepareStatement("CREATE DATABASE "+dbName+";");
		    sentencia.executeUpdate();
		    sentencia = conexion.prepareStatement("USE "+dbName+";");
		    sentencia.executeUpdate();
		    
		    // Creo la Tabla Usuario
		    String sql = "CREATE TABLE USUARIO (\n" + 
		    				"idUsuario INT(6) UNSIGNED PRIMARY KEY AUTO_INCREMENT,\n" + 
		    				"nombre VARCHAR(30) NOT NULL,\n" + 
		    				"apellidos VARCHAR(30) NOT NULL,\n" + 
		    				"email VARCHAR(30) NOT NULL,\n" +
				    		"password VARCHAR(30) NOT NULL\n" + 
				    		");";
		    sentencia = conexion.prepareStatement(sql);
		    sentencia.executeUpdate();
		    
		    // Creo la Tabla Palabra
		    sql = "CREATE TABLE PALABRA (\n" + 
    				"idPalabra INT(6) UNSIGNED PRIMARY KEY AUTO_INCREMENT,\n" + 
    				"palabra VARCHAR(30) NOT NULL,\n" + 
    				"longitud INT(6) NOT NULL,\n" + 
    				"coordX INT(6) NOT NULL,\n" + 
    				"coordY INT(6) NOT NULL,\n" + 
    				"direccion INT(6) NOT NULL\n" + 
		    		");";
		    sentencia = conexion.prepareStatement(sql);
		    sentencia.executeUpdate();
		    
		    // Creo la Tabla JUEGO
		    sql = "CREATE TABLE JUEGO (\n" + 
					"nombre VARCHAR(30) PRIMARY KEY,\n" +
					"lastIndexUser INT(6) NOT NULL,\n" + 
					"lastIndexWord INT(6) NOT NULL\n" + 
		    		");";
		    sentencia = conexion.prepareStatement(sql);
		    sentencia.executeUpdate();
		    sql = "INSERT INTO JUEGO VALUES(?, 0, 0)";
		    sentencia = conexion.prepareStatement(sql);
		    sentencia.setString(1, "SopaLetras");
		    sentencia.executeUpdate();
		    		    
		    // Creo Trigger para Actualizar ID User
		    sql = "CREATE TRIGGER trigger_update_IDUser AFTER INSERT ON USUARIO\n" + 
		    		" FOR EACH ROW " + 
		    		"  UPDATE JUEGO\n" + 
		    		"  SET lastIndexUser = lastIndexUser+1 WHERE 1";
		   	
		    stm = conexion.createStatement();
		    stm.execute(sql);
		    
		    
		    // Creo Trigger para Actualizar ID Palabra
		    sql = "CREATE TRIGGER trigger_update_ID AFTER INSERT ON PALABRA\n" + 
		    		" FOR EACH ROW \n" + 
		    		"  UPDATE JUEGO\n" + 
		    		"  SET JUEGO.lastIndexWord = JUEGO.lastIndexWord+1 WHERE 1";
		    stm = conexion.createStatement();
		    stm.execute(sql);
		    
		}
		else {
			sentencia = conexion.prepareStatement("USE "+dbName+";");
		    sentencia.executeUpdate();
		}
	 } catch (ClassNotFoundException | SQLException ex) {
	 JOptionPane.showMessageDialog(null,ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
	 }
	 return dbCheck;
	}
		
	 public void DesconectarBasedeDatos() {
	 try {
	 if (conexion != null ) {
	 if(sentencia != null) {
	 sentencia.close();
	 }
	 conexion.close();
	 }
	 }
	 catch (SQLException ex) {

	System.out.println("Error!!!!!!!");
		 ex.printStackTrace();

	 JOptionPane.showMessageDialog(null,ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
	 System.exit(1);
	 }
	 }
	 public Connection getConnection(){
	 return conexion;
	 }
}