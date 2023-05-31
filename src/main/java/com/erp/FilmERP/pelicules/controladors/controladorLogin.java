/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.pelicules.controladors;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author salma
 */
@Controller
public class controladorLogin {

    @GetMapping("/login")
    public String inici(@AuthenticationPrincipal UserDetails user) {

        if (user != null) {
            return "redirect:/moduls";
        }
        return "login";
    }
   
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Invalidar la sesión actual
        request.getSession().invalidate();
        return "login";
    }
}