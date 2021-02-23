package com.descorp.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Distribuidor implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="DOCUMENTO")
    private String document;

    @Column (name="NOME")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "com.descorp.models.Distribuidor[ id=" + id + " ]";
    }
    
    
}