/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Actors;
import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.serveis.actors.ActorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorAfegirActors {
    
    @Autowired
    private ActorService actorService;
    
    @GetMapping("/afegirActors")
    public String inici(Model model, Actors actors) {
        
        model.addAttribute("actor", actorService.llistarActor());    
        
        return "afegirActors";
    }
    
    @PostMapping("/guardarActors") //action=guardarActors
    public String guardarActors(@Valid Actors actors, Errors errors) {

        if (errors.hasErrors()) { //Si s'han produït errors...
            return "afegirActors"; //Mostrem la pàgina del formulari
        }
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String a = encoder.encode(actors.getPassword());
        actors.setPassword(a);

        actorService.afegirActor(actors); //Afegim el actor passat per paràmetre a la base de dades

        return "redirect:/llistatActors"; //Retornem a la pàgina inicial dels actors mitjançant redirect
    }
    
    @PostMapping("/guardarActor") //action=guardarActors
    public String guardarActor(@Valid Actors actors, Errors errors) {

        if (errors.hasErrors()) { //Si s'han produït errors...
            return "editarActors"; //Mostrem la pàgina del formulari
        }
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String a = encoder.encode(actors.getPassword());
        actors.setPassword(a);

        actorService.afegirActor(actors); //Afegim el actor passat per paràmetre a la base de dades

        return "redirect:/llistatActors"; //Retornem a la pàgina inicial dels actors mitjançant redirect
    }
    
}
