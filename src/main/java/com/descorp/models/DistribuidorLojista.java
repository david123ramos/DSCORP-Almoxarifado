package com.descorp.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DistribuidorLojista implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @OneToOne(cascade = CascadeType.ALL)
    @Column (name="ID_DISTRIBUIDOR")
    @JoinColumn(name = "ID_DISTRIBUIDOR", referencedColumnName = "id")
    private Distribuidor distribuidor;

    @OneToOne(cascade = CascadeType.ALL)
    @Column (name="ID_LOJISTA")
    @JoinColumn(name = "ID_LOJISTA", referencedColumnName = "id")
    private Lojista lojista;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Distribuidor getIdDistribuidor() {
        return distribuidor;
    }

    public void setIdDistribuidor(Distribuidor d) {
        this.distribuidor = d;
    }

    
    public Lojista getIdLojista() {
        return lojista;
    }

    public void setIdLojista(Lojista l) {
        this.lojista = l;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }

        DistribuidorLojista other = (DistribuidorLojista) object;

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));

    }

    @Override
    public String toString() {
        return "com.descorp.models.DistribuidorLojista[ id=" + id + " ]";
    }
    
    
}