package com.proyecto.Jakarton.sopa;

import com.proyecto.Jakarton.DAO.*;

import java.util.ArrayList;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/
public class Sopa {
	
	/*
	// XML
    private static FactoriaDAO xmlDAOFactory = FactoriaDAO.getDAOFactory(FactoriaDAO.XML);
    public static XMLUsuarioDAO usuarioDAO = (XMLUsuarioDAO) xmlDAOFactory.getUsuarioDAO();
    public static XMLPalabraDAO palabraDAO = (XMLPalabraDAO) xmlDAOFactory.getPalabraDAO();
    public static XMLJuegoDao juegoDAO = (XMLJuegoDao)xmlDAOFactory.getJuegoDAO();
    */
	
	// SQL
    private static FactoriaDAO sqlDAOFactory = FactoriaDAO.getDAOFactory(FactoriaDAO.SQL);
    private static SQLUsuarioDAO usuarioDAO = (SQLUsuarioDAO) sqlDAOFactory.getUsuarioDAO();
    private static SQLPalabraDAO palabraDAO = (SQLPalabraDAO) sqlDAOFactory.getPalabraDAO();
    private static SQLJuegoDAO juegoDAO = (SQLJuegoDAO)sqlDAOFactory.getJuegoDAO();
    
    public static void altaUsuario() throws Exception
    {
    	String nombre = Common.pedirString("Nombre: ");
        String apellidos = Common.pedirString("Apellidos: ");
        String email= Common.pedirString("Email: ");
        String password= Common.pedirString("Password: ");
        
        Usuario nuevoUsuario = new Usuario(nombre, apellidos, email, password);
        usuarioDAO.crearElemento(nuevoUsuario);    
    }
    
    public static void altaPalabra( ) throws Exception
    {
        
        String palabra = Common.pedirString("Palabra: ");
        int coordX = Common.pedirInt("coordX: ");
        int coordY = Common.pedirInt("coordY: ");
        int direccion = Common.pedirInt("direccion: ");
        
        Palabra nuevaPalabra = new Palabra(palabra, palabra.length(), coordX, coordY, direccion);
        palabraDAO.crearElemento(nuevaPalabra);
    }
    
    public static void visualizarUsuarios() throws Exception
    {
         usuarioDAO.printTodos();
    }
    
    public static void visualizarPalabras() throws Exception
    {
         palabraDAO.printTodos();
    }
    
    public static void eliminarUsuario() throws Exception
    {
    	Boolean encontrado = false;
    	Usuario uDelete = null;
    	ArrayList<Usuario> lu = (ArrayList<Usuario>) usuarioDAO.getUsuarios().getListadoUsuarios();
    	int codigo = Common.pedirInt("Escribe el ID del Usuario a Eliminar: ");
    	for (Usuario u : lu) {
    		if(u.getIdUsuario() == codigo){
    			encontrado = true;
    			uDelete = u;
    		}
        }
    	if(encontrado) {
    		System.out.println("El usuario con ID: " + uDelete.getIdUsuario() + " ha sido eliminado");
    		lu.remove(uDelete);
    		usuarioDAO.eliminaElemento(uDelete);
			usuarioDAO.saveTodos();
    	}
    	else{
        	System.out.println("No se encontr?? ning??n Usuario con ID " + codigo);
        }
    }
    
    public static void eliminarPalabra() throws Exception
    {
    	Boolean encontrado = false;
    	Palabra pDelete = null;
    	ArrayList<Palabra> lp = (ArrayList<Palabra>) palabraDAO.getPalabras().getListadoPalabras();
    	int codigo = Common.pedirInt("Escribe el C??digo de la palabra a Eliminar: ");
    	for (Palabra p : lp) {
    		if(p.getIdPalabra() == codigo){
    			encontrado = true;
    			pDelete = p;
    		}
        }
    	if(encontrado) {
    		System.out.println("La palabra con c??digo: " + pDelete.getIdPalabra() + " ha sido eliminada");
    		lp.remove(pDelete);
    		palabraDAO.eliminaElemento(pDelete);
			palabraDAO.saveTodos();
    	}
    	else{
        	System.out.println("No se encontr?? ning??n proyecto con c??digo " + codigo);
        }
    }
    

     // @param args the command line arguments

    public void crearJuego(){

        /*
    	Juego juego = juegoDAO.getJuego();

        altaUsuario();
        altaPalabra();
        eliminarPalabra();
        eliminarUsuario();
        visualizarPalabras();
        visualizarUsuarios();
        */

    }

    public static void main(String [] args){
        //Tablero tab = new Tablero();
        Palabra nuevaPalabra = null;
        Juego juego =  juegoDAO.getJuego();

        ArrayList<Palabra> words = new ArrayList<Palabra>();
        nuevaPalabra = new Palabra("Prueba", 6, 0, 0, 0);
        words.add(nuevaPalabra);
        juego.add(nuevaPalabra);
        nuevaPalabra = new Palabra("Prueba", 6, 1, 0, 0);
        words.add(nuevaPalabra);
        juego.add(nuevaPalabra);
        nuevaPalabra = new Palabra("Prueba", 6, 2, 0, 0);
        words.add(nuevaPalabra);
        juego.add(nuevaPalabra);
        nuevaPalabra = new Palabra("Prueba", 6, 3, 0, 0);
        words.add(nuevaPalabra);
        juego.add(nuevaPalabra);


        //System.out.println(juego.printTablero());



    }

}
