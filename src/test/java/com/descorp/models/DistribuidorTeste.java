package com.descorp.models;

import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("dscorp_persistence");
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
        Distribuidor distribuidor = em.find(Distribuidor.class, 1);

        assertEquals("59.442.943/0001-17", distribuidor.getCnpj());
        assertEquals("Distribuidora Paulista Filial", distribuidor.getName());
    }

    private Distribuidor createDistribuidor() {
        Distribuidor aux = new Distribuidor();
        aux.setName("Distribuidora Estadual - Matriz");
        aux.setCnpj("65.139.251/0001-05");
        return aux;
    }
 }