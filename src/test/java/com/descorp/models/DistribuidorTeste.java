package com.descorp.models;

import static com.descorp.models.DistribuidorLojista_.id;
import java.text.ParseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tests.descorp.java.DbUnitUtil;

/**
 *
 * @author David
 * @author Giovanni
 */

 public class DistribuidorTeste{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dscorp_persistence");
    private EntityManager em;
    private EntityTransaction et;

    public static void setUpClass() {
        DbUnitUtil.insertData();
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
    }

    @After
    public void tearDown() {
        if (!et.getRollbackOnly()) {
            et.commit();
        }
        em.close();
    }

    @Test
    public void persistDistribuidor() {
        Distribuidor distribuidor;
        distribuidor = createDistribuidor();
        em.persist(distribuidor);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(distribuidor.getId());
    }

    @Test
    public void consultDistribuidor() throws ParseException {
        Usuario distribuidor = em.find(Distribuidor.class, 1L);

        assertEquals("59.442.943/0001-17", distribuidor.getCnpj());
        assertEquals("Distribuidora Paulista Filial", distribuidor.getName());
        
        String jpql = "select d from Distribuidor d";
        TypedQuery<Distribuidor> typedQuery = em.createQuery(jpql, Distribuidor.class);
        List<Distribuidor> listaDistribuidor = typedQuery.getResultList();

        for(Distribuidor d: listaDistribuidor) {
                System.out.println(d.getName());
        }


        String jpql1 = "select d from TB_USUARIO d where id = :idDistribuidor ";
        int idDistribuidor = 3;

        TypedQuery<Distribuidor> typedQuery2 = em.createQuery(jpql, Distribuidor.class).setParameter("id", idDistribuidor);
                
        List<Distribuidor> listaDistribuidor2 = typedQuery2.getResultList();

        for(Distribuidor d2: listaDistribuidor2) {
            System.out.println(d2.getName());
        }
    }

    private Distribuidor createDistribuidor() {
        Distribuidor aux = new Distribuidor();
        aux.setName("Distribuidora Estadual - Matriz");
        aux.setEmail("distribuidora@dist.com");
        aux.setSenha("DistD123");
        aux.setCnpj("65.139.251/0001-05");
        return aux;
    }


    

 }