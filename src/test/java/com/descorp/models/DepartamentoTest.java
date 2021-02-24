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

 public class DepartamentoTest{
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
    public void persistDepartamento() {
        Departamento departamento;
        departamento = createDepartamento();
        em.persist(departamento);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(departamento.getId());
    }

    @Test
    public void consultDepartamento() throws ParseException {
        Departamento departamento = em.find(Departamento.class, 1);

        assertEquals("Usados", departamento.getName());
        assertTrue(1 == departamento.getId());
    }

    private Departamento createDepartamento() {
        Departamento aux = new Departamento();
        aux.setName("Usados");
        return aux;
    }
 }