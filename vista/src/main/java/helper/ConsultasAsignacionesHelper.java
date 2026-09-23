package helper;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class ConsultasAsignacionesHelper {

    public List<Asignacion> mostrarAsignaciones() {
        return ServiceLocator.getInstanceAsignacionIDDAO().mostrarAsignaciones();
    }

    public List<Asignacion> buscarPorProfesor(Integer idProfesor) {
        return ServiceLocator.getInstanceAsignacionIDDAO().buscarPorProfesor(idProfesor);
    }

    public List<Asignacion> buscarPorUnidad(Integer idUnidad) {
        return ServiceLocator.getInstanceAsignacionIDDAO().buscarPorUnidad(idUnidad);
    }
}