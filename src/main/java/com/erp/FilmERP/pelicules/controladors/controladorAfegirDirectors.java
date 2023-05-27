/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.serveis.directors.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class controladorAfegirDirectors {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/afegirDirectors")
    public String inici(Model model) {
        
       // model.addAttribute("director", new Directors());
        
        model.addAttribute("directors", directorService.llistarDirectors());     
        return "afegirDirectors";
    }

  
    @PostMapping("/guardarDirectors") //action=guardarDirectors
    public String guardarDirectors(@Valid Directors director, Errors errors) {

        if (errors.hasErrors()) { //Si s'han produït errors...
            return "afegirDirectors"; //Mostrem la pàgina del formulari
        }

        directorService.afegirDirector(director); //Afegim el director passat per paràmetre a la base de dades

        return "redirect:/llistatDirectors"; //Retornem a la pàgina inicial dels directors mitjançant redirect
    }
    
    
}
