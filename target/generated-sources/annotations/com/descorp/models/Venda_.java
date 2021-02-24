package com.descorp.models;

import com.descorp.models.Lojista;
import com.descorp.models.Produto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2021-02-24T17:15:39")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Date> date;
    public static volatile ListAttribute<Venda, Produto> produtos;
    public static volatile SingularAttribute<Venda, Long> id;
    public static volatile SingularAttribute<Venda, Lojista> lojista;

}