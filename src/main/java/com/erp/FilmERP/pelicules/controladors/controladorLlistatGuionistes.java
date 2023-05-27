/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Guionistes;
import com.erp.FilmERP.serveis.guionistes.GuionistaService;
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
    private GuionistaService guionistaService;
    
    @GetMapping("/llistatGuionistes")
    public String inici(Model model) {
        
        //findAll retorna el llistat d'objectes directors guardats en la taula directors de la BBDD  
        model.addAttribute("guionistes", guionistaService.llistarGuionistes());
        
        return "llistatGuionistes";
    }
    
    
    @GetMapping("/eliminarGuionistes/{correu}")
    public String eliminarGuionistes(Guionistes guionistes) {

        /*Eliminem el guionista passat per paràmetre, al qual li correspón id correu de @GetMapping mitjançant 
         *el mètode eliminarGuionista de la capa de servei.*/
        guionistaService.eliminarGuionista(guionistes);
        
        return "redirect:/llistatGuionistes"; //Retornem a la pàgina inicial dels guionistes mitjançant redirect
    }
    
    
}
