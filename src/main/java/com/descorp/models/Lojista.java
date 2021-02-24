package com.descorp.models;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name="TB_LOJISTA") 
@DiscriminatorValue(value = "LJ")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
public class Lojista extends Usuario implements Serializable{
    
    @OneToMany(mappedBy = "lojista", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Produto.class)
    //@JoinColumn(name = "ID_PRODUTOS", referencedColumnName = "Produto_id")
    private List<Produto> produtos;
    
    public boolean adicionar(Produto item) {
        return produtos.add(item);
    }
    
    public List<Produto> getItens() {
        return produtos;
    }

    public boolean remover(Produto item) {
        return produtos.remove(item);
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

        Lojista other = (Lojista) object;

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.descorp.models.Lojista[ id=" + id + " ]";
    }
}