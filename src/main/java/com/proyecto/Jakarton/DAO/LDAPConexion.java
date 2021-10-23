package com.proyecto.Jakarton.DAO;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

/**
 *
 * @author Lucian, Javier, Pol, Oriol, Chadouli
 */
public class LDAPConexion {

	// CAMPOS
	private Hashtable<String, String> env = new Hashtable<>();

	// Variable control autentificacion
	boolean autentificado = false;
	// Contexto de conexión
	private DirContext ctx = null;

	private static final String url = "ldap://192.168.1.3:389";
	private static final String auth = "simple";
	private static final String driver = "com.sun.jndi.ldap.LdapCtxFactory";
	private static String userName;
	private static String password;

    public Connection conexion;
    public PreparedStatement sentencia;
    public Statement stm;
    public ResultSet resultado;

    public LDAPConexion(String user, String pass){
		userName = user;
		password = pass;

		ConectarBasedeDatos();

		if(!autentificado){
			userName = "";
			password = "";
		}

	}

	public Boolean ConectarBasedeDatos(){
			// Declaramos parametros para la conexión LDAP
		env.put(Context.INITIAL_CONTEXT_FACTORY, driver);
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.SECURITY_AUTHENTICATION, auth);
		env.put(Context.SECURITY_PRINCIPAL, "CN=" + userName + ",OU=GameDB,DC=corp,DC=enderop,DC=com");
		env.put(Context.SECURITY_CREDENTIALS, password);

		try {
			// Creamos el contexto inicial
			ctx = new InitialDirContext(env);

			// Establecemos variable y cerramos el contexto
			autentificado = true;
			//ctx.close();	en función de desconexión

		} catch (NamingException e) {
			autentificado = false;
		} finally {
			if (autentificado){
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}
		}

	 return autentificado;
	}

	 public void DesconectarBasedeDatos() {
		 try {
			 // Establecemos variable y cerramos el contexto
			 autentificado = false;
			 ctx.close();

		 } catch (NamingException e) {
			 autentificado = false;
		 } finally {
			 if (autentificado) {
				 System.out.println("Desconexión OK");
			 } else {
				 System.out.println("Failure Desconexión");
			 }
		 }
	 }

	 public Boolean ifConexion(){
		return autentificado;
	 }
}
