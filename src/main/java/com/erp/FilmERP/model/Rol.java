package com.erp.FilmERP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author fta
 */

@Data
@Entity
@Table(name="rols")
public class Rol implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id //L'atribut idRol és la clau primària de la BBDD
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Generació autonumèrica de l'id
    private Integer idrol;
    
    @NotEmpty//Validació perquè l'usuari afegeixi contingut al camp nom
    private String nom;
    
    @OneToMany(mappedBy = "rol")
    private List<Usuari> usuarios = new ArrayList<>();
}
