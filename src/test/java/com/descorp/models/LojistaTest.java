package com.descorp.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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

 public class LojistaTest{
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
    public void persistLojista() {
        Lojista lojista;
        lojista = createLojista();
        em.persist(lojista);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(lojista.getId());
    }

    @Test
    public void consultLojista() throws ParseException {
        Lojista lojista = em.find(Lojista.class, 1);

        assertEquals("Casas Bahia", lojista.getName());
        assertEquals("4", lojista.getId());
    }

    private Lojista createLojista() {
        Lojista aux = new Lojista();
        aux.setName("Extra");
        Departamento dpto  = new Departamento();
        dpto.setName("Limpeza");
        
        List<Departamento> dptos = new ArrayList<>();
        dptos.add(dpto);
        
        aux.setDepartamentos(dptos);
        return aux;
    }
 }