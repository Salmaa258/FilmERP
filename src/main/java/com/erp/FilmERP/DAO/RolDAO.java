/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.DAO;

import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.model.Rol;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author salma
 */

public interface RolDAO extends CrudRepository<Rol,String>{
   // List<Directors> findByCorreu(String correu);
}
