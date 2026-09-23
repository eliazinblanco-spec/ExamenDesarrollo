package mx.desarrollo.delegate;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class AsignacionDelegate {

    public void asignarUnidades(Asignacion asignacion) {
        ServiceLocator.getInstanceAsignacionDAO().asignarUnidades(asignacion);
    }

    public List<Asignacion> listarAsignaciones() {
        return ServiceLocator.getInstanceAsignacionDAO().listarTodos();
    }

    public List<Asignacion> buscarPorProfesor(Integer idProfesor) {
        return ServiceLocator.getInstanceAsignacionDAO().buscarPorProfesor(idProfesor);
    }

    public void eliminarAsignacion(Integer id) {
        ServiceLocator.getInstanceAsignacionDAO().eliminarAsignacion(id);
    }
}