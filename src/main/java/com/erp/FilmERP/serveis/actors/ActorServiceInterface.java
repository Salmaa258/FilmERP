
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.actors;

import com.erp.FilmERP.model.Actors;
import java.util.List;

/**
 *
 * @author salma
 */
public interface ActorServiceInterface {
    public List<Actors> llistarActor(); //Mètode que implementarem per llistar Directors
    
    public void afegirActor(Actors director); //Mètode que implementarem per afegir un Director
    
    public void eliminarActor(Actors director); //Mètode que implementarem per eliminar un Director
    
    public Actors cercarActor(Actors director); //Mètode que implementarem per cercar un Director
}
