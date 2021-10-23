/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Usuario;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

public class XMLUsuarioDAO implements InterfazDAO<Usuario>{
    
	// CAMPOS
	private static final String carpeta = "xml";
	private static final String archivo = "usuarios.xml";
    private ListadoUsuarios listadoUsuarios;
    
    // CONSTRUCTORES
    
  	/**
  	 * Constructor que crea una instancia de patrón DAO.
  	 * Al inicializarse obtiene los datos provenientes de la persistencia
  	 */
    public XMLUsuarioDAO()
    {
        
        try {
			getTodos();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
    
    /**
 	 * Constructor que crea una instancia de patrón DAO con una lista de usuarios predeterminada.
 	 * 
 	 * @param listadoUsuarios lista de usuarios predeterminada
 	 */
    public XMLUsuarioDAO(ListadoUsuarios listadoUsuarios)
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
    public List<Usuario> getTodos() throws JAXBException {
    	File ficheroUsuarios = new File(carpeta, archivo);
  	  
        if (!ficheroUsuarios.exists())
        {
            System.out.println("No existe el archivo "+ archivo + ", no se puede recuperar datos");
            listadoUsuarios = new ListadoUsuarios();
            return null;
        } else {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListadoUsuarios.class);;
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            listadoUsuarios = (ListadoUsuarios) unmarshaller.unmarshal(ficheroUsuarios);
        }

        return listadoUsuarios.getListadoUsuarios();
    }
    
    /**
	 * Metodo accesor de escritura que añade un usuario a la lista
	 * 
	 * @param elemento Usuario a añadir 
	 */
    @Override
    public void crearElemento(Usuario user) throws JAXBException {
        
    	listadoUsuarios.addUsuario(user);
        saveTodos();
       
        System.out.println("Se ha creado el usuario número: "+ user.getIdUsuario());
    }
    
    /**
	 * Imprime la lista de usuarios
	 */
    @Override
    public void printTodos() throws JAXBException {
        
        if (listadoUsuarios.getListadoUsuarios().size() > 0) 
        {
            System.out.println("El juego cuenta con " + listadoUsuarios.getListadoUsuarios().size() + " usuarios:");
	    
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
    public void saveTodos() throws JAXBException {
        
        if (listadoUsuarios.getListadoUsuarios().size() > 0) 
        {
            JAXBContext context = JAXBContext.newInstance(ListadoUsuarios.class);
		    Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
            //Crea el directorio "xml" en caso de que no exista.
            File f = new File(carpeta);
            if (!f.exists()) {
            	f.mkdirs();
            }
			
            marshaller.marshal(listadoUsuarios, new File(f, archivo));
	    } else {
	    	System.out.println("La lista de usuarios está vacía.");
	    }
    }

	@Override
	public void eliminaElemento(Usuario elemento) throws Exception {
		// No Aplica
		
	}
}
