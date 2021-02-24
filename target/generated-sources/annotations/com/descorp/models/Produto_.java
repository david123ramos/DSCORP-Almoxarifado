package com.descorp.models;

import com.descorp.models.Departamento;
import com.descorp.models.Lojista;
import com.descorp.models.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2021-02-24T17:08:59")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, String> name;
    public static volatile SingularAttribute<Produto, Departamento> dpto;
    public static volatile ListAttribute<Produto, Venda> vendas;
    public static volatile SingularAttribute<Produto, Integer> id;
    public static volatile SingularAttribute<Produto, Lojista> lojista;

}