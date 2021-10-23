/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Jakarton.DAO;

import com.proyecto.Jakarton.sopa.Juego;
import com.proyecto.Jakarton.sopa.Palabra;
import com.proyecto.Jakarton.sopa.Usuario;

/**
*
* @author Lucian, Javier, Pol, Oriol, Chadouli
* 
* Interfaz que define el patrón DAO
* 
*/

public class XMLDAOFactory extends FactoriaDAO{

    @Override
    public InterfazDAO<Usuario> getUsuarioDAO() {
        return new XMLUsuarioDAO();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public InterfazDAO<Palabra> getPalabraDAO() {
        return new XMLPalabraDAO();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public InterfazDAO<Juego> getJuegoDAO() {
        return new XMLJuegoDAO();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
