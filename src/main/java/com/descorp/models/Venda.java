package com.descorp.models;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David
 * @author Giovanni
 */
@Entity
@Table(name="TB_VENDA") 
public class Venda {
    
    @Id
    @Column (name="Venda_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_LOJISTA", referencedColumnName = "id")
    private Lojista lojista;
    
    
    @ManyToMany
    @JoinTable(
      name = "venda_produto", 
      joinColumns = @JoinColumn(name = "Venda_id"), 
      inverseJoinColumns = @JoinColumn(name = "id")) 
    private List<Produto> produtos;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CRIACAO")
    private Date date;
    
    @PrePersist
    public void setDataCriacao() {
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lojista getLojista() {
        return lojista;
    }

    public void setLojista(Lojista lojista) {
        this.lojista = lojista;
    }

    public List<Produto> getProduto() {
        return produtos;
    }

    public void setProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
