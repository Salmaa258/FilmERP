/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.DAO.DirectorsDAO;
import com.erp.FilmERP.model.Directors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorLlistatDirectors {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de DirectorsDAO al controlador
    private DirectorsDAO directorsDAO;
    
    @GetMapping("/llistatDirectors")
    public String inici(Model model) {
        
        //findAll retorna el llistat d'objectes directors guardats en la taula directors de la BBDD  
        model.addAttribute("directors", directorsDAO.findAll());
        
        
        return "llistatDirectors";
    }
}
