package com.descorp.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
        return "com.descorp.models.DepartamentoLojista[ id=" + id + " ]";
    }
}