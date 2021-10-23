package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Palabra;

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

public class XMLPalabraDAO implements InterfazDAO<Palabra>{
    
	// CAMPOS
	private static final String carpeta = "xml";
	private static final String archivo = "palabras.xml";
    private ListadoPalabras listadoPalabras;
    
    // CONSTRUCTORES
    
  	/**
  	 * Constructor que crea una instancia de patrón DAO.
  	 * Al inicializarse obtiene los datos provenientes de la persistencia
  	 */
    public XMLPalabraDAO()
    {
        
        try {
			getTodos();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
    
    /**
 	 * Constructor que crea una instancia de patrón DAO con una lista de palabras predeterminada.
 	 * 
 	 * @param listadoPalabras lista de palabras predeterminada
 	 */
    public XMLPalabraDAO(ListadoPalabras listadoPalabras)
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
    public List<Palabra> getTodos() throws JAXBException {
    	File ficheroPalabras = new File(carpeta, archivo);
  	  
        if (!ficheroPalabras.exists())
        {
            System.out.println("No existe el archivo "+ archivo + ", no se puede recuperar datos");
            listadoPalabras = new ListadoPalabras();
            return null;
        } else {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListadoPalabras.class);;
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            listadoPalabras = (ListadoPalabras) unmarshaller.unmarshal(ficheroPalabras);
        }

        return listadoPalabras.getListadoPalabras();
    }
    
    /**
	 * Metodo accesor de escritura que añade una palabra a la lista
	 * 
	 * @param elemento Palabra a añadir 
	 */
    @Override
    public void crearElemento(Palabra word) throws JAXBException {
        
    	listadoPalabras.addPalabra(word);
        saveTodos();
       
        System.out.println("Se ha creado la pabara número: "+ word.getIdPalabra());
    }
    
    /**
	 * Imprime la lista de palabras
	 */
    @Override
    public void printTodos() throws JAXBException {
        
        if (listadoPalabras.getListadoPalabras().size() > 0) 
        {
            System.out.println("El juego cuenta con " + listadoPalabras.getListadoPalabras().size() + " palabras:");
	    
            for (Palabra w : listadoPalabras.getListadoPalabras()) {
	    		System.out.println(w.toString());
            }
		    
	    } else {
	    	System.out.println("La lista de palabras está vacía.");
	    }
    }
    
    /**
	 * Guarda todos las palabras en la persistencia
	 */
    @Override
    public void saveTodos() throws JAXBException {
        
        if (listadoPalabras.getListadoPalabras().size() > 0) 
        {
            JAXBContext context = JAXBContext.newInstance(ListadoPalabras.class);
		    Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
            //Crea el directorio "xml" en caso de que no exista.
            File f = new File(carpeta);
            if (!f.exists()) {
            	f.mkdirs();
            }
			
            marshaller.marshal(listadoPalabras, new File(f, archivo));
	    } else {
	    	System.out.println("La lista de palabras está vacía.");
	    }
    }

	@Override
	public void eliminaElemento(Palabra palabra) throws Exception {
		// No Aplica
		
	}
}
