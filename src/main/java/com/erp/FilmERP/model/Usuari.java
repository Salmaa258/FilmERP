/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author salma
 */

@Data
@Entity
@Table(name = "usuari")
//@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class Usuari implements Serializable {
    
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;
    
    @Id //correu es la clau primaria de la BBDD
    @Column(name = "correu")
    private String correu;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "cognoms")
    private String cognoms;
    
    @Column(name = "edad")
    private int edad;
     
    @Column(name = "sexe")
    private String sexe;
    
    @Column(name = "telefon")
    private int telefon;
   
}
