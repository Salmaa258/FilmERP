/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.model;

import jakarta.persistence.Column;
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
@Table(name = "pelicules")
public class Pelicules implements Serializable{
    @Id
    @Column(name = "titol")
    private String titol;
    
    @Column(name = "sinopsi")
    private String sinopsi;
    
    @Column(name = "genere")
    private String genere;
    
    @Column(name = "any")
    private int any;
}
