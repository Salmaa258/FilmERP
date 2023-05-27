/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.actors;

import com.erp.FilmERP.DAO.ActorsDAO;
import com.erp.FilmERP.model.Actors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author salma
 */
@Service 
public class ActorService implements ActorServiceInterface{
    @Autowired
    private ActorsDAO actors;

    @Override
    public List<Actors> llistarActor() {
        return (List<Actors>) actors.findAll();
    }

    @Override
    public void afegirActor(Actors actors) {
        this.actors.save(actors);
    }

    @Override
    public void eliminarActor(Actors actors) {
        this.actors.delete(actors);
    }

    @Override
    @Transactional(readOnly=true)
    public Actors cercarActor(Actors actors) {
        return this.actors.findById(actors.getCorreu()).orElse(null);  
    }
}
