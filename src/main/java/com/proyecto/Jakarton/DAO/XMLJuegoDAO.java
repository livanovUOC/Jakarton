package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Juego;

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

public class XMLJuegoDAO implements InterfazDAO<Juego>{
	
	// CAMPOS
	private static final String carpeta = "xml";
	private static final String archivo = "juego.xml";
	private Juego juego;
   
   public XMLJuegoDAO(){
   	
       try {
       	getTodos();
		} catch (JAXBException e) {
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
   public void crearElemento(Juego elemento) throws JAXBException 
   {
	   
	   juego = elemento;
       saveTodos();
      
       System.out.println("Se ha creado un nuevo Juego: "+juego.getNombre());
   }
   
   /**
	 * Metodo accesor de lectura que se encarga de obtener los datos desde la persistencia
	 * 
	 * @return devuelve una lista de los datos recuperados. O en caso de no existir datos, devuelve una lista vacía
	 */
   @Override
   public List<Juego> getTodos() throws JAXBException {
   	File ficheroJuego = new File(carpeta, archivo);
   	  
       if ( !ficheroJuego.exists())
       {
           System.out.println("No existe el archivo "+ archivo + ", no se puede recuperar datos");
           juego = new Juego("SopaLetras", null, null);
           saveTodos();
       } else {
           JAXBContext jaxbContext = JAXBContext.newInstance(Juego.class);
           Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
           juego = (Juego) unmarshaller.unmarshal(ficheroJuego);
       }

       return null;
   }
   
   /**
	 * Imprime los datos del Juego
	 */
   @Override
   public void printTodos() throws JAXBException {
       
       if (juego != null) 
       {
           System.out.println("El juego registrado es " + juego.getNombre());
		    
	    } else {
	    	System.out.println("No existen datos del Juego.");
	    }
   }
   
   /**
	 * Guarda los datos del Juego en la persistencia
	 */
   @Override
   public void saveTodos() throws JAXBException {
       
       if (juego != null) 
       {
           JAXBContext context = JAXBContext.newInstance(Juego.class);
		    Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
	        File f = new File(carpeta);
           if (!f.exists()) {
           	f.mkdirs();
	        }
           
           marshaller.marshal(juego, new File(f, archivo));
           
	    } else {
	    	System.out.println("No hay datos del Juego.");
	    }
   }

	@Override
	public void eliminaElemento(Juego elemento) throws Exception {
		// No Apñica
		
	}
	
	public Juego getJuego() {
		return this.juego;
	}
}

