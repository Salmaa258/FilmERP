/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.guionistes;

import com.erp.FilmERP.model.Guionistes;
import java.util.List;

/**
 *
 * @author salma
 */
public interface GuionistaServiceInterface {
    public List<Guionistes> llistarGuionistes(); //Mètode que implementarem per llistar Guionistes
    
    public void afegirGuionista(Guionistes guionista); //Mètode que implementarem per afegir un Guionistes
    
    public void eliminarGuionista(Guionistes guionista); //Mètode que implementarem per eliminar un Guionistes
    
    public Guionistes cercarGuionista(Guionistes guionista); //Mètode que implementarem per cercar un Guionistes
}
