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

public class SQLDAOFactory extends FactoriaDAO{

    @Override
    public InterfazDAO<Usuario> getUsuarioDAO() {
        return new SQLUsuarioDAO();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public InterfazDAO<Palabra> getPalabraDAO() {
        return new SQLPalabraDAO();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public InterfazDAO<Juego> getJuegoDAO() {
        return new SQLJuegoDAO();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
