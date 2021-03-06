/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.dao;

import exemplo.jpa.modelo.EntidadeBase;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author samue
 */
public class GenericoDAO<T extends EntidadeBase> {

    public EntityManager getEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventoPU");
        return emf.createEntityManager();
    }

    public T salvar(T t) throws Exception {

        EntityManager em = getEM();

        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);
            } else {
                if (!em.contains(t)) {
                    if (em.find(t.getClass(), t.getId()) == null) {
                        throw new Exception("Erro ao atualizar!");
                    }
                }
                t = em.merge(t);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return t;

    }

    public void remover(Class<T> clazz, Long id) {

        EntityManager em = getEM();
        T t = em.find(clazz, id);

        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public T consultarPorId(Class<T> clazz , Long id) {
        EntityManager em = getEM();
        T t = null;

        try {
            t = em.find(clazz, id);
        } finally {
            em.close();
        }
        return t;
    }

}
