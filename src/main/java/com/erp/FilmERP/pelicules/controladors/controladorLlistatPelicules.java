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
public class controladorLlistatPelicules {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PeliculesDAO al controlador
    private PeliculaService peliculaService;
    
    @GetMapping("/llistatPelicules")
    public String inici(Model model) {
        
        //findAll retorna el llistat d'objectes pelicules guardats en la taula directors de la BBDD  
        model.addAttribute("pelicules", peliculaService.llistarPelicula());
        
        return "llistatPelicules";
    }
    
    @GetMapping("/eliminarPeli/{titol}")
    public String eliminarPeli(Pelicules pelicula) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        peliculaService.eliminarPelicula(pelicula);
        
        return "redirect:/llistatPelicules"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    
    @GetMapping("/buscarPelis/{titol}")
    public String buscarPelis(Pelicules pelicula) {

        /*Eliminem el actor passat per paràmetre, al qual li correspón id correu de @GetMapping mitjançant 
         *el mètode eliminarActor de la capa de servei.*/
        peliculaService.cercarPelicula(pelicula);
        
        return "redirect:/llistatPelicules"; //Retornem a la pàgina inicial dels actors mitjançant redirect
    }
}
