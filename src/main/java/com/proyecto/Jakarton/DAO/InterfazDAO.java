/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Jakarton.DAO;

import java.util.List;

/**
 *
 * @author Lucian, Javier, Pol, Oriol, Chadouli
 * @param <Tipo> Interface de tipo genérico para el DAO
 */
public interface InterfazDAO<Tipo> {
    
    /**
     * Metodo para crear un nuevo elemento
     * @param elemento
     * @throws javax.xml.bind.Exception
     */
    public void crearElemento(Tipo elemento) throws Exception;
    
    /**
     * Metodo para eliminar un elemento
     * @param elemento
     * @throws javax.xml.bind.Exception
     */
    public void eliminaElemento(Tipo elemento) throws Exception;

    /**
    * Metodo para obtener todos los elementos
     * @return 
     * @throws javax.xml.bind.Exception 
    */
    public List<Tipo> getTodos() throws Exception ;
    
    /**
     * Metodo para imprimir todos los elementos
      * @return 
      * @throws javax.xml.bind.Exception 
     */
     public void printTodos() throws Exception ;
     
     /**
      * Metodo para guardar todos los elementos
       * @return 
       * @throws javax.xml.bind.Exception 
      */
      public void saveTodos() throws Exception ;
    
}
