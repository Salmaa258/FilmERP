/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.directors;

import com.erp.FilmERP.DAO.DirectorsDAO;
import com.erp.FilmERP.model.Directors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author salma
 */
@Service 
public class DirectorService implements DirectorServiceInterface{

    @Autowired
    private DirectorsDAO directors;
    
    @Override
    public List<Directors> llistarDirectors() {
        return (List<Directors>) directors.findAll();
    }

    @Override    
    public void afegirDirector(Directors directors) {
       this.directors.save(directors);
    }

    @Override
    public void eliminarDirector(Directors directors) {
        this.directors.delete(directors);
    }

    @Override
    @Transactional(readOnly=true)
    public Directors cercarDirector(Directors directors) {
       return this.directors.findById(directors.getCorreu()).orElse(null);   
    }
    
}
