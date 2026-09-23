package mx.desarrollo.facade;

import mx.desarrollo.delegate.AsignacionesDelegate;
import mx.desarrollo.entity.Asignacion;

import java.util.List;

public class AsignacionesFacade {

    private final AsignacionesDelegate delegate;

    public AsignacionesFacade() {
        this.delegate = new AsignacionesDelegate();
    }

    public List<Asignacion> consultarAsignaciones() {
        return delegate.consultarAsignaciones();
    }

    public List<Asignacion> consultarPorProfesor(Integer idProfesor) {
        if (idProfesor == null)
            throw new IllegalArgumentException("El ID del profesor no puede ser nulo.");
        return delegate.consultarPorProfesor(idProfesor);
    }

    public List<Asignacion> consultarPorUnidad(Integer idUnidad) {
        if (idUnidad == null)
            throw new IllegalArgumentException("El ID de la unidad no puede ser nulo.");
        return delegate.consultarPorUnidad(idUnidad);
    }
}