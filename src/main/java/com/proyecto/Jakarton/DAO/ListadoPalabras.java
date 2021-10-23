package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Palabra;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

@XmlRootElement(name = "palabras")
public class ListadoPalabras {
    
	// CAMPOS
    private List<Palabra> listadoPalabras;
    
    // CONSTRUCTORES
    
    /**
	 * Constructor que llama a un nuevo objeto Listadopalabras sin inicializar sus campos.
	 */
    public ListadoPalabras() {
        super();
        listadoPalabras = new ArrayList<Palabra>();        
    }
    
    /**
	 * Constructor que crea una instancia del objeto con datos predeterminados.
	 * 
	 * @param listadoPalabras Lista que inicializa la instancia que se cree
	 */
    public ListadoPalabras(List<Palabra> listadoPalabras) {
        super();
        this.listadoPalabras = listadoPalabras;
    }
    
    /**
	 * Metodo accesor de lectura que nos da el listado de usuarios.
	 * 
	 * @return Nos devuelve el listado de palabras. 
	 */
    @XmlElement(name = "palabra")
    public List<Palabra> getListadoPalabras() {
        return listadoPalabras;
    }
    
    /**
     * Metodo accesor de escritura que asigna el listado de palabras.
     * 
     * @param listadoPalabras El listado de palabras.
     */
    public void setListadoPalabras(List<Palabra> listadoPalabras) {
        this.listadoPalabras = listadoPalabras;
    }
    
    /**
     * Este metodo nos permite agregar una palabara al listado.
     * 
     * @param word Palabra.
     */
    public void addPalabra(Palabra word)
    {
        this.listadoPalabras.add(word);
    }
    
}
