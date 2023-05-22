/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.DAO.PeliculesDAO;
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
    private PeliculesDAO peliculesDAO;
    
    @GetMapping("/llistatPelicules")
    public String inici(Model model) {
        
        //findAll retorna el llistat d'objectes pelicules guardats en la taula pelicules de la BBDD  
        model.addAttribute("pelicules", peliculesDAO.findAll());
        
        return "llistatPelicules";
    }
}
