package com.descorp.models;

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

 public class LojistaTest{
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
    public void persistLojista() {
        Lojista lojista;
        lojista = createLojista();
        em.persist(lojista);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(lojista.getId());
    }

    @Test
    public void consultLojista() throws ParseException {
        Usuario lojista = em.find(Lojista.class, 5L);

        assertEquals("Extra", lojista.getName());
        assertTrue(1 == lojista.getId());
        
        String jpql = "select l from TB_USUARIO l";
        TypedQuery<Lojista> typedQuery = em.createQuery(jpql, Lojista.class);
        List<Lojista> listaLojista = typedQuery.getResultList();

        for(Lojista l: listaLojista) {
            System.out.println(l.getName());
        }


        String jpql2 = "select l from TB_USUARIO l where id = :idLojista ";
        int idLojista = 3;

        TypedQuery<Lojista> typedQuery2 = em
                .createQuery(jpql, Lojista.class)
                .setParameter("id", idLojista);
        List<Lojista> listaLojista2 = typedQuery.getResultList();

        for(Lojista l2: listaLojista) {
                System.out.println(l2.getName());
        }
    }

    private Lojista createLojista() {
        Lojista s = new Lojista();
        s.setName("David");
        s.setCnpj("123123123123");
        s.setEmail("drs@a.recife.ifpe.edu.br");
        Departamento d = new Departamento();
        d.setId(123);
        d.setName("LP");
        s.setDepartamentos(d);
        s.setSenha("PSW123adda");
        return s;
    }

 }