/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorInfoPelicules {
    @GetMapping("/infoPelicules")
    public String inici() {
        return "infoPelicules";
    }
}
