/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.DAO.ActorsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorLlistatActors {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de ActorsDAO al controlador
    private ActorsDAO actorsDAO;
    
    @GetMapping("/llistatActors")
    public String inici(Model model) {
        
        //findAll retorna el llistat d'objectes actors guardats en la taula actors de la BBDD  
        model.addAttribute("actors", actorsDAO.findAll());
        
        return "llistatActors";
    }
}
