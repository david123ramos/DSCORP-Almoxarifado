package com.descorp.models;

import com.descorp.models.Departamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2021-02-23T23:39:33")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile ListAttribute<Usuario, Departamento> departamentos;
    public static volatile SingularAttribute<Usuario, String> name;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, String> cnpj;
    public static volatile SingularAttribute<Usuario, Date> dataCriacao;
    public static volatile SingularAttribute<Usuario, String> email;

}