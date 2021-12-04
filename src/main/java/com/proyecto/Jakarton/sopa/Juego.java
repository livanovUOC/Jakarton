package com.proyecto.Jakarton.sopa;

import com.proyecto.Jakarton.DAO.ListadoPalabras;
import com.proyecto.Jakarton.DAO.ListadoUsuarios;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;



/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/
@XmlRootElement(name = "juego")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
//@XmlType(propOrder={"idUsuario", "nombre", "apellidos", "email", "password"})

public class Juego {
    private String nombre;
    private ListadoUsuarios usuarios;
    private ListadoPalabras palabras;
    private Tablero tablero;

	public static int lastIndexUser = 0;
	public static int lastIndexWord = 0;
	public static Sesion sesion = null;
	
	// CONSTRUCTORES
    
	/**
	 * Constructor básico
	 */
	public Juego() {
        this.tablero = new Tablero(8, 8);
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
		this.tablero = new Tablero(8, 8);
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
     * Este metodo nos permite agregar una lista de palabras al Juego
     *
     * @param p Palabra.
     */
    public void add(ListadoPalabras p) {

        this.palabras = p;

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

    /**
     * Método que devuelve el código Jquery para que funcione el tablero
     *
     * @return devuelve listado de palabras del Juego
     */
    public String getCode() {
        ArrayList<Palabra> listaPalabras = (ArrayList<Palabra>) this.getPalabras().getListadoPalabras();

        String codigo = "";
        int columnas = tablero.getColumnas();
        int indice = 0;
        String word = "";
        for (int i=0;i<listaPalabras.size();i++) {
            indice = listaPalabras.get(i).getCoodX() * columnas + listaPalabras.get(i).getCoodY();
            word = listaPalabras.get(i).getPalabra().toLowerCase();
            for(int index = 0; index< listaPalabras.get(i).getLongitud(); index++) {
                codigo += "$(\".caja:eq(" + indice + ")\").addClass(\"" + word + "\");" + "\n";
                if(listaPalabras.get(i).getDireccion() == 0) {
                    indice++;
                }
                else{
                    indice += columnas;
                }

            }
            codigo += "$(\"div." + word + "\").hover(function(){" + "\n";
            codigo += "$(\"div." + word + "\").addClass(\"resaltar\");" + "\n";
            codigo += "}" + "\n";
            codigo += ");" + "\n";
            codigo += "\n\n";

            codigo += "$(\"div." + word + "\").mouseleave(function(){" + "\n";
            codigo += "$(\"div." + word + "\").removeClass(\"resaltar\");" + "\n";
            codigo += "}" + "\n";
            codigo += ");" + "\n";
            codigo += "\n\n";

            codigo += "$(\"div." + word + "\").click(function(){" + "\n";
            codigo += "$(\"div." + word + "\").css(\"color\", \"green\");" + "\n";
            codigo += "$(\"span." + word + "\").css(\"text-decoration\", \"line-through\");" + "\n";
            codigo += "}" + "\n";
            codigo += ");" + "\n";
            codigo += "\n" + "\n";
        }

        return codigo;
    }

    public String holaMundo(){
        return "hola Mundo";
    }

    /**
     * Método público para imprimir el tablero
     */
    public String printTablero() {
        String codigo = "";
        tablero.palabras = (ArrayList<Palabra>) palabras.getListadoPalabras();
        char[][] tab = tablero.printTablero();
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();


        for (int f=0;f<filas;f++) {
            for (int c=0;c<columnas;c++) {
                codigo += "<div class=\"caja\"><strong>" + tab[f][c] + "</strong></div>\n";
            }
            codigo += "\n";
            codigo += "\n";
        }
        return codigo;
    }
}
