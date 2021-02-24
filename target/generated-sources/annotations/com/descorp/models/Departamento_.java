package com.descorp.models;

import com.descorp.models.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2021-02-24T17:08:59")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> name;
    public static volatile SingularAttribute<Departamento, Integer> id;
    public static volatile ListAttribute<Departamento, Usuario> usuarios;

}