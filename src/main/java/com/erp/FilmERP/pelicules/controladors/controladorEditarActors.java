/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Actors;
import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.serveis.actors.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorEditarActors {
    
    @Autowired
    private ActorService actorService;
    
    /*@GetMapping("/editarActors")
    public String inici() {
        return "editarActors";
    }*/
    
    @GetMapping("/editarActors/{correu}")
    public String editarActors(Actors actors, Model model) {
        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.
        //model.addAttribute("gos", gosService.cercarGos(gos));*/
        model.addAttribute("actors", actorService.cercarActor(actors));

        return "editarActors"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
