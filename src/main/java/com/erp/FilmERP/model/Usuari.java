/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
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
@Table(name = "usuari")
public class Usuari implements Serializable {
    
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;
    
    @Id //correu es la clau primaria de la BBDD
    @Column(name = "correu")
    @NotEmpty
    private String correu;
    
    @Column(name = "password")
    @NotEmpty
    private String password;
    
    @Column(name = "nom")
    @NotEmpty
    private String nom;
    
    @Column(name = "cognoms")
    @NotEmpty
    private String cognoms;
    
    @Column(name = "edad")
    @Pattern(regexp = "[0-9]+([0-9]{1})?")
    private String edad;
     
    @Column(name = "sexe")
    @NotEmpty
    private String sexe;
    
    @Column(name = "telefon")
    @Pattern(regexp = "[0-9]{9}$")
    private String telefon;
   
    
    @ManyToOne //Indica al sistema que la relació entre les taules usuari i rol en aquest cas és d'un a molts.
    @JoinColumn(name="rol") //Columna de la base de dades que farà de clau forana relacionant les dues taules.
    private Rol rol;
}
