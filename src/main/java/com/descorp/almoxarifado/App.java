package com.descorp.almoxarifado;

import com.descorp.view.MainWindow;
import java.text.ParseException;

/**
 * @author David
 * @author Giovanni
 */
public class App {
    public static void main(String[] args) throws ParseException {


        
        MainWindow mw = new MainWindow(1280, 720);
//        Staff staff = new Staff();;
//        fillStaff(staff);
//
//
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        EntityTransaction et = null;
//        try {
//            //EntityManagerFactory realiza a leitura das informações relativas à "persistence-unit".
//            emf = Persistence.createEntityManagerFactory("dscorp_persistence");
//            em = emf.createEntityManager(); //Criação do EntityManager.
//            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
//            et.begin();
//            em.persist(staff);
//            et.commit();
//        } catch (Exception ex) {
//            if (et != null)
//                et.rollback();
//        } finally {
//            if (em != null)
//                em.close();       
//            if (emf != null)
//                emf.close();
//        }
    }
    
//    private static void fillStaff(Staff s) {;
//        s.setName("David");
//        s.setPhone("123123");
//        s.setDocument("123123");
//    }
}
