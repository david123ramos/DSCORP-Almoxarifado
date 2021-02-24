package com.descorp.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Produto implements Serializable{

    @Id
    @Column (name= "Produto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column (name="NOME")
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL)
    @Column (name="ID_DEPARTAMENTO")
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "id")
    private Departamento dpto;
    
    @ManyToMany(mappedBy = "produtos_venda")
    private List<Venda> vendas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departamento getDepartamento() {
        return dpto;
    }

    public void setDepartamento(Departamento d) {
        this.dpto = d;
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

        Produto other = (Produto) object;

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.descorp.models.Produto[ id=" + id + " ]";
    }
    
}