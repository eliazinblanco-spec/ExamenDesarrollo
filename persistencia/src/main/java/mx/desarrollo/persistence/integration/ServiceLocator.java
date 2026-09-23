package mx.desarrollo.persistence.integration;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.dao.AsignacionDAO;
import mx.desarrollo.persistence.dao.ProfesorDAO;
import mx.desarrollo.persistence.dao.UsuarioDAO;
import mx.desarrollo.persistence.persistence.HibernateUtil;

public class ServiceLocator {

    public static ProfesorDAO getInstanceProfesorDAO() {
        EntityManager em = HibernateUtil.getEntityManager();
        return new ProfesorDAO(em);
    }

    public static UsuarioDAO getInstanceUsuarioDAO() {
        EntityManager em = HibernateUtil.getEntityManager();
        return new UsuarioDAO(em);
    }

    public static AsignacionDAO getInstanceAsignacionDAO() {
        EntityManager em = HibernateUtil.getEntityManager();
        return new AsignacionDAO(em);
    }
}