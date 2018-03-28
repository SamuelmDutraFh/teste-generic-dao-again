/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.dao;

import exemplo.jpa.modelo.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocalDAO extends GenericoDAO<Local> {

    public EntityManager getEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventoPU");
        return emf.createEntityManager();
    }

    public Local salvar(Local local) {

        EntityManager em = getEM();

        try {
            em.getTransaction().begin();
            if (local.getId() == null) {
                em.persist(local);
            } else {
                local = em.merge(local);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }

        return local;

    }

    public void remover(Long id) {

        EntityManager em = getEM();
        Local l = em.find(Local.class, id);

        try {
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public Local consultarPorId(Long id) {
        EntityManager em = getEM();
        Local l = null;

        try {
            l = em.find(Local.class, id);
        } finally {
            em.close();
        }
        return l;
    }

}
