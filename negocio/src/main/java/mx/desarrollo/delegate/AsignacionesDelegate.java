package mx.desarrollo.delegate;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class AsignacionesDelegate {

    public List<Asignacion> consultarAsignaciones() {
        return ServiceLocator.getInstanceAsignacionIDDAO().mostrarAsignaciones();
    }

    public List<Asignacion> consultarPorProfesor(Integer idProfesor) {
        return ServiceLocator.getInstanceAsignacionIDDAO().buscarPorProfesor(idProfesor);
    }

    public List<Asignacion> consultarPorUnidad(Integer idUnidad) {
        return ServiceLocator.getInstanceAsignacionIDDAO().buscarPorUnidad(idUnidad);
    }
}