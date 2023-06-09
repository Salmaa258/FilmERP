/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    @NotEmpty
    private String titol;
    
    @Column(name = "sinopsi")
    @NotEmpty
    private String sinopsi;
    
    @Column(name = "genere")
    @NotEmpty
    private String genere;
    
    @Column(name = "any")
    @Pattern(regexp = "[0-9]{4}$")
    private String any;
}
