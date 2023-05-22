/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.DAO;

import com.erp.FilmERP.model.Administrador;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author salma
 */
public interface AdministradorDAO extends CrudRepository<Administrador,String> {
    List<Administrador> findByCorreu(String correu);
}
