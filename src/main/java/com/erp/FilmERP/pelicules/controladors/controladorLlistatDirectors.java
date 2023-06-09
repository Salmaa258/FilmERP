/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.serveis.directors.DirectorService;
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
public class controladorLlistatDirectors {
    @Autowired
    private DirectorService directorService;
    
    @GetMapping("/llistatDirectors")
    public String inici(Model model) {
        
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esTipoX = auth.getAuthorities().contains(new SimpleGrantedAuthority("Administrador"));
        if (esTipoX) {
            // Afegir un atribut al model per indicar que s'ha de mostrar la columna X
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }
        
        //findAll retorna el llistat d'objectes directors guardats en la taula directors de la BBDD  
        model.addAttribute("directors", directorService.llistarDirectors());
        
        
        return "llistatDirectors";
    }
    
    @GetMapping("/eliminar/{correu}")
    public String eliminar(Directors director) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        directorService.eliminarDirector(director);
        
        return "redirect:/llistatDirectors"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
