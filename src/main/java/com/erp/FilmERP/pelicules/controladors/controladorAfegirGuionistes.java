/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.model.Guionistes;
import com.erp.FilmERP.serveis.guionistes.GuionistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorAfegirGuionistes {
    
    @Autowired
    private GuionistaService guionistaService;
    
    @GetMapping("/afegirGuionistes")
    public String inici(Model model, Guionistes guionista) {
        
        model.addAttribute("guionista", guionistaService.llistarGuionistes());     
        
        return "afegirGuionistes";
    }
    
    @PostMapping("/guardarGuionistes") //action=guardarGuionistes
    public String guardarGuionistes(@Valid Guionistes guionista, Errors errors) {

        if (errors.hasErrors()) { //Si s'han produït errors...
            return "afegirGuionistes"; //Mostrem la pàgina del formulari
        }
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String a = encoder.encode(guionista.getPassword());
        guionista.setPassword(a);

        guionistaService.afegirGuionista(guionista); //Afegim el guionista passat per paràmetre a la base de dades

        return "redirect:/llistatGuionistes"; //Retornem a la pàgina inicial dels guionistes mitjançant redirect
    }
    
    @PostMapping("/guardarGuionista") //action=guardarGuionistes
    public String guardarGuionista(@Valid Guionistes guionista, Errors errors) {

        if (errors.hasErrors()) { //Si s'han produït errors...
            return "editarGuionistes"; //Mostrem la pàgina del formulari
        }
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String a = encoder.encode(guionista.getPassword());
        guionista.setPassword(a);

        guionistaService.afegirGuionista(guionista); //Afegim el guionista passat per paràmetre a la base de dades

        return "redirect:/llistatGuionistes"; //Retornem a la pàgina inicial dels guionistes mitjançant redirect
    }
    
}
