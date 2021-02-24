package com.descorp.almoxarifado;

import com.descorp.models.Departamento;
import com.descorp.models.Lojista;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author David
 * @author Giovanni
 */
public class App {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dscorp_persistence");
    public static void main(String[] args) throws ParseException {


        
       //MainWindow mw = new MainWindow(1280, 720);
        Lojista staff = new Lojista();
        fillStaff(staff);

        //EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //EntityManagerFactory realiza a leitura das informações relativas à "persistence-unit".
           // emf = Persistence.createEntityManagerFactory("dscorp_persistence");
            em = emf.createEntityManager(); //Criação do EntityManager.
            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
            et.begin();
            em.persist(staff);
            et.commit();
        } catch (Exception ex) {
            if (et != null)
                et.rollback();
        } finally {
            if (em != null)
                em.close();       
            if (emf != null)
                emf.close();
        }
    }
    
    private static void fillStaff(Lojista s) {
        s.setName("David");
        s.setCnpj("123123123123");
        s.setEmail("drs@a.recife.ifpe.edu.br");
        Departamento d = new Departamento();
        d.setId(123);
        d.setName("LP");
        s.setDepartamentos(d);
        s.setSenha("PSW123adda");
    }
}
