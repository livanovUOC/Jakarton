package com.proyecto.Jakarton.sopa;

import javax.xml.bind.annotation.*;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/
@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder={"idUsuario", "nombre", "apellidos", "email", "password"})

public class Usuario {
	// Atributos
    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    
    // CONSTRUCTORES
    
  	/**
  	 * Constructor básico
  	 */
     public Usuario()
     {
         super();
     }

     /**
  	 * Constructor que inicializa con información determinada
  	 * 
  	 * @param nombre
  	 * @param apellidos
  	 * @param email
      * @param pass
      *
  	 */
     public Usuario(String nombre, String apellidos, String email, String pass) {
    	 Juego.lastIndexUser++;
    	 this.idUsuario = Juego.lastIndexUser;
    	 this.nombre = nombre;
    	 this.apellidos = apellidos;
    	 this.email = email;
    	 this.password = pass;
     }
     

     /**
  	 * Método de acceso de lectura
  	 * 
  	 * @return Devuelve el ID del Usuario
  	 */
     @XmlElement(name="idUsuario")
     public int getIdUsuario() {
         return idUsuario;
     }
     
     /**
   	 * Método de acceso de lectura
   	 * 
   	 * @return Devuelve el nombre del Usuario
   	 */
     @XmlElement(name="nombre")
     public String getNombre() {
         return nombre;
     }
      
     /**
     * Método de acceso de lectura
     * 
     * @return Devuelve los apellidos del Usuario
     */
     @XmlElement(name="apellidos")
     public String getApellidos() {
         return apellidos;
     }
      
     /**
     * Método de acceso de lectura
     * 
     * @return Devuelve el email del Usuario
     */
     @XmlElement(name="email")
     public String getEmail() {
         return email;
     }
         
     /**
     * Método de acceso de lectura
     * 
     * @return Devuelve el password del Usuario
     */
     @XmlElement(name="password")
     public String getPassword() {
         return password;
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
      * Método de acceso de escritura
      * 
      * @param apellidos
      */
      public void setApellidos(String apellidos) {
          this.apellidos = apellidos;
      }
       
      /**
      * Método de acceso de escritura
      * 
      * @param email
      */
      public void setEmail(String email) {
          this.email = email;
      }
          
      /**
      * Método de acceso de escritura
      * 
      * @param password
      */
      public void setPassword(String password) {
          this.password = password;
      }
          
      /**
   	  * Convierte los datos de una instancia de clase a String
   	  * 
   	  * @return Devuelve los datos del usuario transformados a String
   	  */
      @Override
      public String toString() {
          return "idUsuario: " + idUsuario + "\n nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", password=" + password;
      }    
}
