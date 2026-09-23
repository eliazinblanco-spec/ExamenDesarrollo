package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class UnidadAprendizajeDAO extends AbstractDAO<UnidadAprendizaje> {

    private final EntityManager entityManager;

    public UnidadAprendizajeDAO(EntityManager em) {
        super(UnidadAprendizaje.class);
        this.entityManager = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<UnidadAprendizaje> listarTodos() {
        return findAll();
    }

    public void registrarUnidad(UnidadAprendizaje unidad) {
        save(unidad);
    }

    public void actualizarUnidad(UnidadAprendizaje unidad) {
        update(unidad);
    }

    public void eliminarUnidad(Integer id) {
        find(id).ifPresent(this::delete);
    }
}