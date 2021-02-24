package com.descorp.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.br.CPF;



@Entity
@Table(name = "TB_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@Access(AccessType.FIELD)
public abstract class Usuario implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Column(name = "TXT_CNPJ")
    protected String cnpj;

    @NotBlank
    @Size(max = 30)
    @Column(name = "name")
    protected String name;
    
    @NotNull
    @Email
    @Column(name = "TXT_EMAIL", length = 30, nullable = false)
    protected String email;

    @NotBlank
    @Size(min = 6, max = 20)
    @Column(name = "TXT_SENHA")
    protected String senha;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CRIACAO")
    protected Date dataCriacao;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, targetEntity = Departamento.class)
    @JoinColumn(name = "id" , insertable=false, updatable=false)
    private Departamento departamento;
    
    @PrePersist
    public void setDataCriacao() {
        this.setDataCriacao(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamentos(Departamento departamento) {
        this.departamento = departamento;
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
        Usuario other = (Usuario) object;

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(", ");
        sb.append(this.name);
        sb.append(", ");
        sb.append(", ");
        sb.append(this.cnpj);

        return sb.toString();
    }
}