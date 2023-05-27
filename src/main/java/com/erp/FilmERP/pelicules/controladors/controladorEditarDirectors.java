/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.serveis.directors.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorEditarDirectors {
    
    @Autowired
    private DirectorService directorService;
    
    /*@GetMapping("/editarDirectors")
    public String inici(Model model) {
        //findAll retorna el llistat d'objectes directors guardats en la taula directors de la BBDD  
        model.addAttribute("directors", directorService.llistarDirectors());
        
        return "editarDirectors";
    }*/
    
    @GetMapping("/editar/{correu}")
    public String editar(Directors director, Model model) {
        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.
        //model.addAttribute("gos", gosService.cercarGos(gos));*/
        model.addAttribute("directors", directorService.cercarDirector(director));

        return "editarDirectors"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
