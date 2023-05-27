
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.directors;

import com.erp.FilmERP.model.Directors;
import java.util.List;

/**
 *
 * @author salma
 */
public interface DirectorServiceInterface {
    public List<Directors> llistarDirectors(); //Mètode que implementarem per llistar Directors
    
    public void afegirDirector(Directors director); //Mètode que implementarem per afegir un Director
    
    public void eliminarDirector(Directors director); //Mètode que implementarem per eliminar un Director
    
    public Directors cercarDirector(Directors director); //Mètode que implementarem per cercar un Director
}
