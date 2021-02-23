package com.descorp.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
//        if (!(object instanceof Usuario)) {
//            return false;
//        }
//
//        CartaoCredito other = (CartaoCredito) object;
//
//        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
        return false;
    }

    @Override
    public String toString() {
        return "com.descorp.models.DistribuidorLojista[ id=" + id + " ]";
    }
    
    
}