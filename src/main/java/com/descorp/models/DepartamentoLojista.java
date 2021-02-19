package com.descorp.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class DepartamentoLojista implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="ID_LOJISTA")
    private Integer idLojista;

    @Column (name="ID_DEPARTAMENTO")
    private Integer idDepartamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }


    public Integer getIdLojista() {
        return idLojista;
    }

    public void setIdLojista(Integer idLojista) {
        this.idLojista = idLojista;
    }
}