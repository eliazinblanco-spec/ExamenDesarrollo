package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class AsignacionIDDAO extends AbstractDAO<Asignacion> {

    private final EntityManager entityManager;

    public AsignacionIDDAO(EntityManager em) {
        super(Asignacion.class);
        this.entityManager = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Asignacion> mostrarAsignaciones() {
        return findAll();
    }

    public List<Asignacion> buscarPorProfesor(Integer idProfesor) {
        return findByField("profesor.id", idProfesor);
    }

    public List<Asignacion> buscarPorUnidad(Integer idUnidad) {
        return findByField("unidad.id", idUnidad);
    }
}