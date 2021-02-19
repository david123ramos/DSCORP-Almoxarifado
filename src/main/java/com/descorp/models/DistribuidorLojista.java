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
public class DistribuidorLojista implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="ID_DISTRIBUIDOR")
    private Integer idDistribuidor;

    @Column (name="ID_LOJISTA")
    private Integer idLojista;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Integer idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    
    public Integer getIdLojista() {
        return idLojista;
    }

    public void setIdLojista(Integer idLojista) {
        this.idLojista = idLojista;
    }
}