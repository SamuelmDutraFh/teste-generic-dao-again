/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.teste;

import exemplo.jpa.dao.LocalDAO;
import exemplo.jpa.modelo.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author samue
 */
public class TesteLocal {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventoPU");
        EntityManager em = emf.createEntityManager();

        Local l = new Local();
        //l.setId(1L);
        l.setCapacidade(80);
        l.setPredio("Lambda");
        l.setSala("dois");

//        em.getTransaction().begin();
//        em.persist(l);
//        em.getTransaction().commit();
//        em.close();
        LocalDAO dao = new LocalDAO();
        dao.salvar(l);
        
        dao.remover(Local.class, l.getId());

    }
}
