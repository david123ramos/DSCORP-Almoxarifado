package com.descorp.models;

import com.descorp.models.Staff;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import tests.descorp.java.DbUnitUtil;

/**
 *
 * @author David
 * @author Giovanni
 */
public class StaffTest {

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
    public void persistStaff() {
        Staff staff;
        staff = createStaff();
        em.persist(staff);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(staff.getId());
    }
    
    @Test
    public void consultStaff() {
        Staff staff = em.find(Staff.class, 1);
        assertEquals("908.559.730-72", staff.getDocument());
        assertEquals("Giovanni", staff.getName().toString());
        assertTrue(staff.getPhone().contains("81999999999"));
    }

    private  Staff createStaff() {
        Staff aux = new Staff();
        aux.setName("Oseias rms");
        aux.setDocument("721.313.133-48");
        aux.setPhone("81912313211");
        return aux;
    }
}