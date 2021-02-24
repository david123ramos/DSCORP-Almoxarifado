package com.descorp.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tests.descorp.java.DbUnitUtil;

/**
 *
 * @author David
 * @author Giovanni
 */

 public class ProdutoTest{
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
    public void persistProduto() {
        Produto produto;
        produto = createProduto();
        em.persist(produto);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(produto.getId());
    }

    @Test
    public void consultProduto() throws ParseException {
        Produto produto = em.find(Produto.class, 1);

        assertEquals("Retroescavadeira", produto.getName());
        assertEquals("2", produto.getDepartamento().getId());
    }

    private Produto createProduto() {
        Produto aux = new Produto();
        aux.setName("Ar-condicionado");
        Departamento dpto  = new Departamento();
        dpto.setName("Limpeza");
        aux.setDepartamento(dpto);
        return aux;
    }
 }