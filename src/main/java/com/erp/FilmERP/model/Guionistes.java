/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.FilmERP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author salma
 */
@Data
@Entity
@Table(name = "guionistes")
public class Guionistes extends Usuari implements Serializable{
    @Column(name = "pelGuiada")
    private String pelGuiada;
}
