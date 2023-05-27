/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.pelicules;

import com.erp.FilmERP.DAO.PeliculesDAO;
import com.erp.FilmERP.model.Pelicules;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author salma
 */
@Service 
public class PeliculaService implements PeliculaServiceInterface {
    
    @Autowired
    private PeliculesDAO pelicules;

    @Override
    public List<Pelicules> llistarPelicula() {
        return (List<Pelicules>) pelicules.findAll();
    }

    @Override
    public void afegirPelicula(Pelicules pelicula) {
        this.pelicules.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Pelicules pelicula) {
        this.pelicules.delete(pelicula);
    }

    @Override
    @Transactional(readOnly=true)
    public Pelicules cercarPelicula(Pelicules pelicula) {
        return this.pelicules.findById(pelicula.getTitol()).orElse(null); 
    }
    
}
