/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.pelicules;

import com.erp.FilmERP.model.Pelicules;
import java.util.List;

/**
 *
 * @author salma
 */
public interface PeliculaServiceInterface {
    public List<Pelicules> llistarPelicula(); //Mètode que implementarem per llistar pelicules
    
    public void afegirPelicula(Pelicules pelicula); //Mètode que implementarem per afegir una pelicula
    
    public void eliminarPelicula(Pelicules pelicula); //Mètode que implementarem per eliminar una pelicula
    
    public Pelicules cercarPelicula(Pelicules pelicula); //Mètode que implementarem per cercar una pelicula
}
