/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Actors;
import com.erp.FilmERP.serveis.actors.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorLlistatActors {
    @Autowired
    private ActorService actorService;
    
    @GetMapping("/llistatActors")
    public String inici(Model model) {
        
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esTipoX = auth.getAuthorities().contains(new SimpleGrantedAuthority("Administrador"));
        boolean esTipoD = auth.getAuthorities().contains(new SimpleGrantedAuthority("Directors"));
        if (esTipoX || esTipoD) {
            // Afegir un atribut al model per indicar que s'ha de mostrar la columna X
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }
        
        //findAll retorna el llistat d'objectes actors guardats en la taula directors de la BBDD  
        model.addAttribute("actors", actorService.llistarActor());
        
        return "llistatActors";
    }
    
    @GetMapping("/eliminarActors/{correu}")
    public String eliminarActors(Actors actors) {

        /*Eliminem el actor passat per paràmetre, al qual li correspón id correu de @GetMapping mitjançant 
         *el mètode eliminarActor de la capa de servei.*/
        actorService.eliminarActor(actors);
        
        return "redirect:/llistatActors"; //Retornem a la pàgina inicial dels actors mitjançant redirect
    }
}
