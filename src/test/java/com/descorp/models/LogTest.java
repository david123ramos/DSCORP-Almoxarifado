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
 */
public class LogTest {
    
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

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

    @Test
    public void persistLog() {
        Log log;
        log = createLog();
        em.persist(log);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(log.getId());
    }
    
    @Test
    public void consultLog() throws ParseException {
        Log log = em.find(Log.class, 1);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date expResult = format.parse("2021-02-02 12:20:36");
        assertEquals(expResult, log.getDate());
        assertTrue(3 == log.getAmount());
        assertTrue(1 == log.getProduct().getId());
    }

    private  Log createLog() {
        Log aux = new Log();
        aux.setDate(new Date());
        aux.setOperation("ENTRADA");
        aux.setAmount(30);
        Staff staff = em.find(Staff.class, 1);
        Product prd = em.find(Product.class, 1);
        aux.setStaff(staff);
        aux.setProduct(prd);
        return aux;
    }

    @Test
    public void testGetDate() throws ParseException {

        Log instance = em.find(Log.class, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date expResult = format.parse("2021-02-02 12:20:36");
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetOperation() {
        Log instance = em.find(Log.class, 3);
        assertEquals("SAIDA", instance.getOperation());
    }


    @Test
    public void testGetId() {
      
        Log instance = em.find(Log.class, 4);
      
       assertTrue(4 == instance.getId());
  
    }
    
}
