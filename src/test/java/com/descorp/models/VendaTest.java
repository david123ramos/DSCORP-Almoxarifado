package com.descorp.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
 */
public class VendaTest {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dscorp_persistence");;
    private EntityManager em ;
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
    public void persistVenda() {
        Venda v;
        v = createVenda();
        em.persist(v);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(v.getId());
    }

    @Test
    public void readVenda() throws ParseException {
        Venda v = em.find(Venda.class, 1L);

        assertEquals("Extra", v.getLojista().getName());
        assertTrue(1 == v.getId());
    }

    private Venda createVenda() {
        Lojista aux = new Lojista();
        aux.setName("Extra");
        aux.setCnpj("25.441.900/0001-03");
        aux.setEmail("lojista@loja.com");
        aux.setSenha("Senha123");
        Departamento dpto  = new Departamento();
        dpto.setName("Limpeza");
        aux.setDepartamentos(dpto);
        
        Venda v = new Venda();
        v.setDate(new Date());
        v.setLojista(aux);
        List<Produto> l = new ArrayList<>();
        
        Produto p = new Produto();
        p.setDpto(dpto);
        p.setLojista(aux);
        p.setName("Shampoo");
        l.add(p);
        v.setProduto(l);
        return v;
    }
    
}
