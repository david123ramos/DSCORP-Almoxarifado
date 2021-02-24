package com.descorp.models;

import com.descorp.models.Distribuidor;
import com.descorp.models.Lojista;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2021-02-24T17:08:59")
@StaticMetamodel(DistribuidorLojista.class)
public class DistribuidorLojista_ { 

    public static volatile SingularAttribute<DistribuidorLojista, Integer> id;
    public static volatile SingularAttribute<DistribuidorLojista, Lojista> lojista;
    public static volatile SingularAttribute<DistribuidorLojista, Distribuidor> distribuidor;

}