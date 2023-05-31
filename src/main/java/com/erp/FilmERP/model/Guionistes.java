/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author salma
 */
@Data
@Entity
//@Table(name = "usuari")
public class Guionistes extends Usuari implements Serializable{
    @Column(name = "pelGuiada")
    @NotEmpty
    private String pelGuiada;
}
