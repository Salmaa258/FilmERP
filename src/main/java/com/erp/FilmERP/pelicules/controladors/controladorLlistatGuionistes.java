/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.DAO.GuionistesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorLlistatGuionistes {
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GuionistesDAO al controlador
    private GuionistesDAO guionistesDAO;
    
    @GetMapping("/llistatGuionistes")
    public String inici(Model model) {
        
        //findAll retorna el llistat d'objectes guionistes guardats en la taula guionistes de la BBDD  
        model.addAttribute("guionistes", guionistesDAO.findAll());
        
        return "llistatGuionistes";
    }
}
