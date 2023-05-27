/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Pelicules;
import com.erp.FilmERP.serveis.pelicules.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorEditarPelicules {
    
    @Autowired
    private PeliculaService peliculaService;
    
    /*@GetMapping("/editarPelicules")
    public String inici() {
        return "editarPelicules";
    }*/
    
    @GetMapping("/editarPelis/{titol}")
    public String editarPelis(Pelicules pelicules, Model model) {
        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.
        //model.addAttribute("gos", gosService.cercarGos(gos));*/
        model.addAttribute("pelicules", peliculaService.cercarPelicula(pelicules));

        return "editarPelicules"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
