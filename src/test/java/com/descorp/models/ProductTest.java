/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.descorp.models;

import com.descorp.models.Product;
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
public class ProductTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    
    public ProductTest() {
    }
    
    @BeforeClass
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

    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void persistProduct() {
        Product product;
        product = createProduct();
        em.persist(product);
        em.flush();

        assertNotNull(product.getId());
    }

    /**
     * Test of setId method, of class Product.
     */
    @Test
    public void consultProduct() {
        Product product = em.find(Product.class, 1);
        assertTrue(200.00F == product.getPrice());
        assertEquals("Gabinete VGA", product.getName().toString());
    }

    private Product createProduct(){
        Product aux = new Product();
        aux.setName("Teclado logitech");
        aux.setPrice(129.90F);

        return aux;
    }
    
}
