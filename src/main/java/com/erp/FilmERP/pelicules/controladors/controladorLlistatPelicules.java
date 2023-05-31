/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Pelicules;
import com.erp.FilmERP.serveis.pelicules.PeliculaService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
public class controladorLlistatPelicules {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PeliculesService al controlador
    private PeliculaService peliculaService;
    
    @GetMapping("/llistatPelicules")
    public String inici(Model model, Principal principal) {
        
        //Controlem que només el administrador i guionista poden accedir
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esTipoG = auth.getAuthorities().contains(new SimpleGrantedAuthority("Guionistes"));
        boolean esTipoA = auth.getAuthorities().contains(new SimpleGrantedAuthority("Administrador"));
        if (esTipoG || esTipoA ) {
            // Afegir un atribut al model per indicar que s'ha de mostrar la columna X
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }
        
        
        //findAll retorna el llistat d'objectes pelicules guardats en la taula directors de la BBDD  
        model.addAttribute("pelicules", peliculaService.llistarPelicula());
        
        Authentication authentication = (Authentication) principal;
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
//        String username = authentication.getName();
//        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        
        return "llistatPelicules";
    }
    
    @GetMapping("/eliminarPeli/{titol}")
    public String eliminarPeli(Pelicules pelicula) {

        /*Eliminem la peli passada per paràmetre, al qual li correspón el id titol de @GetMapping mitjançant 
         *el mètode eliminarPeli de la capa de servei.*/
        peliculaService.eliminarPelicula(pelicula);
        
        return "redirect:/llistatPelicules"; //Retornem a la pàgina inicial de les pelicules mitjançant redirect
    }
    
    @GetMapping("/buscarPelis/{titol}")
    public String buscarPelis(Pelicules pelicula) {

        /*Eliminem el actor passat per paràmetre, al qual li correspón id correu de @GetMapping mitjançant 
         *el mètode eliminarActor de la capa de servei.*/
        peliculaService.cercarPelicula(pelicula);
        
        return "redirect:/llistatPelicules"; //Retornem a la pàgina inicial dels actors mitjançant redirect
    }
}
