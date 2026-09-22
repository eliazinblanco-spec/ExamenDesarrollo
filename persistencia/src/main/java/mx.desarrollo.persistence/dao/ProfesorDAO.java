package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class ProfesorDAO extends AbstractDAO<Profesor> {

    private final EntityManager entityManager;

    public ProfesorDAO(EntityManager em) {
        super(Profesor.class);
        this.entityManager = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public boolean existeRFC(String rfc) {
        return findByOneParameterUnique(rfc, "rfc") != null;
    }

    public List<Profesor> listarTodos() {
        return findAll();
    }

    public void registrarProfesor(Profesor profesor) {
        if (existeRFC(profesor.getRfc())) {
            throw new IllegalArgumentException(
                    "El RFC " + profesor.getRfc() + " ya está registrado.");
        }
        save(profesor);
    }

    public void actualizarProfesor(Profesor profesor) {
        update(profesor);
    }

    public void eliminarProfesor(Integer id) {
        find(id).ifPresent(this::delete);
    }
}
