/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.model.Pelicules;
import com.erp.FilmERP.serveis.pelicules.PeliculaService;
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
public class controladorAfegirPelicules {
    
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/afegirPelicules")
    public String inici(Model model) {
        
        model.addAttribute("pelicules", peliculaService.llistarPelicula());     
        
        return "afegirPelicules";
    }
    
    @PostMapping("/guardarPelicules") //action=guardarPelicules
    public String guardarPelicules(@Valid Pelicules pelicula, Errors errors) {

        if (errors.hasErrors()) { //Si s'han produït errors...
            return "afegirPelicules"; //Mostrem la pàgina del formulari
        }

        peliculaService.afegirPelicula(pelicula); //Afegim la pelicula passada per paràmetre a la base de dades

        return "redirect:/llistatPelicules"; //Retornem a la pàgina inicial de les pelicules mitjançant redirect
    }
}
