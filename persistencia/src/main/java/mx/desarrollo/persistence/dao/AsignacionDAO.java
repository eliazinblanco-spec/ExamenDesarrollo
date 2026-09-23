package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class AsignacionDAO extends AbstractDAO<Asignacion> {

    private final EntityManager entityManager;

    public AsignacionDAO(EntityManager em) {
        super(Asignacion.class);
        this.entityManager = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void asignarUnidades(Asignacion asignacion) {
        save(asignacion);
    }

    public List<Asignacion> listarTodos() {
        return findAll();
    }

    public List<Asignacion> buscarPorProfesor(Integer idProfesor) {
        return findByField("profesor.id", idProfesor);
    }

    public List<Asignacion> buscarPorUnidad(Integer idUnidad) {
        return findByField("unidad.id", idUnidad);
    }

    public void eliminarAsignacion(Integer id) {
        find(id).ifPresent(this::delete);
    }

    public UnidadAprendizaje findUnidad(Integer id) {
        return entityManager.find(UnidadAprendizaje.class, id);
    }

    public List<UnidadAprendizaje> listarUnidades() {
        return entityManager.createQuery(
                        "SELECT u FROM UnidadAprendizaje u", UnidadAprendizaje.class)
                .getResultList();
    }
}