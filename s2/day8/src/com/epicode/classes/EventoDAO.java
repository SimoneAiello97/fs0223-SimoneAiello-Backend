package com.epicode.classes;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.epicode.util.JPAUtils;

public class EventoDAO extends JPAUtils{

	static EntityManagerFactory  emf = getEntityManagerFactory();
    static EntityManager em = emf.createEntityManager();

    public static void save(Evento e) throws SQLException {
        em.getTransaction().begin();
        em.persist(e); // INSERT
        em.getTransaction().commit();
        em.refresh(e);
        System.out.println(e);
    }
    
    public static Evento getById(long id) throws SQLException {
        em.getTransaction().begin();
        Evento e = em.find(Evento.class, id);
        em.getTransaction().commit();
        return e;
    }

    public static void delete(long id) throws SQLException {
        em.getTransaction().begin();
        Evento e = em.find(Evento.class, id);
        em.remove(e); // DELETE
        em.getTransaction().commit();
        System.out.println(e.getTitle() + " " + e.getTipoEvento() + " deleted!!!");
    }
}
