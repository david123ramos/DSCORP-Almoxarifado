package com.descorp.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DISTRIBUIDOR")
@PrimaryKeyJoinColumn(name = "id_usuario", referencedColumnName = "id")
public class Distribuidor extends Usuario implements Serializable{
   
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

        Distribuidor other = (Distribuidor) object;

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));

    }

    @Override
    public String toString() {
        return "com.descorp.models.Distribuidor[ id=" + id + " ]";
    }
}