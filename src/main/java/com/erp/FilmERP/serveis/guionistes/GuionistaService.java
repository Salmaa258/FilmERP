/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.serveis.guionistes;

import com.erp.FilmERP.DAO.GuionistesDAO;
import com.erp.FilmERP.model.Guionistes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author salma
 */
@Service 
public class GuionistaService implements GuionistaServiceInterface{
    
    @Autowired
    private GuionistesDAO guionistes;

    @Override
    public List<Guionistes> llistarGuionistes() {
        return (List<Guionistes>) guionistes.findAll();
    }

    @Override
    public void afegirGuionista(Guionistes guionista) {
        this.guionistes.save(guionista);
    }

    @Override
    public void eliminarGuionista(Guionistes guionista) {
        this.guionistes.delete(guionista);
    }

    @Override
    @Transactional(readOnly=true)
    public Guionistes cercarGuionista(Guionistes guionista) {
        return this.guionistes.findById(guionista.getCorreu()).orElse(null);   
    }
    
}
