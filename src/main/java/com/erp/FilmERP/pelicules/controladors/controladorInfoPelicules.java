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
public class controladorInfoPelicules {
    
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/infoPelicules")
    public String inici() {
        return "infoPelicules";
    }
    
    @GetMapping("/infoPelicules/{titol}")
    public String infoPelicules(Pelicules pelicules, Model model) {
        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.
        //model.addAttribute("gos", gosService.cercarGos(gos));*/
        model.addAttribute("pelicules", peliculaService.cercarPelicula(pelicules));

        return "infoPelicules"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
