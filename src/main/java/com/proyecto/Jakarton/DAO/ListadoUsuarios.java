/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Usuario;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
*/

@XmlRootElement(name = "usuarios")
public class ListadoUsuarios {
    
	// CAMPOS
    private List<Usuario> listadoUsuarios;
    
    // CONSTRUCTORES
    
    /**
	 * Constructor que llama a un nuevo objeto Listadousuarios sin inicializar sus campos.
	 */
    public ListadoUsuarios() {
        super();
        listadoUsuarios = new ArrayList<Usuario>();        
    }
    
    /**
	 * Constructor que crea una instancia del objeto con datos predeterminados.
	 * 
	 * @param listadoUsuarios Lista que inicializa la instancia que se cree
	 */
    public ListadoUsuarios(List<Usuario> listadoUsuarios) {
        super();
        this.listadoUsuarios = listadoUsuarios;
    }
    
    /**
	 * Metodo accesor de lectura que nos da el listado de usuarios.
	 * 
	 * @return Nos devuelve el listado de usuarios. 
	 */
    @XmlElement(name = "usuario")
    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }
    
    /**
     * Metodo accesor de escritura que asigna el listado de usuarios.
     * 
     * @param listadoUsuarios El listado de usuarios.
     */
    public void setListadoPalabras(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }
    
    /**
     * Este metodo nos permite agregar un usuario al listado.
     * 
     * @param user Usuario.
     */
    public void addUsuario(Usuario user)
    {
        this.listadoUsuarios.add(user);
    }
    
}
