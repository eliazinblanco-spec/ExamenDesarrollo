package mx.desarrollo.facade;

import mx.desarrollo.delegate.AsignacionDelegate;
import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.entity.UnidadAprendizaje;

import java.util.List;

public class AsignacionFacade {

    private final AsignacionDelegate delegate;

    public AsignacionFacade() {
        this.delegate = new AsignacionDelegate();
    }

    public void asignarUnidades(Profesor profesor, UnidadAprendizaje unidad) {
        validarVacios(profesor, unidad);
        validarTraslape(profesor, unidad);
        Asignacion asignacion = new Asignacion(profesor, unidad);
        delegate.asignarUnidades(asignacion);
    }

    public List<Asignacion> listarAsignaciones() {
        return delegate.listarAsignaciones();
    }

    public List<Asignacion> buscarPorProfesor(Integer idProfesor) {
        return delegate.buscarPorProfesor(idProfesor);
    }

    public void eliminarAsignacion(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        delegate.eliminarAsignacion(id);
    }

    private void validarVacios(Profesor profesor, UnidadAprendizaje unidad) {
        if (profesor == null)
            throw new IllegalArgumentException("Debe seleccionar un profesor.");
        if (unidad == null)
            throw new IllegalArgumentException("Debe seleccionar una unidad de aprendizaje.");
    }

    private void validarTraslape(Profesor profesor, UnidadAprendizaje unidad) {
        List<Asignacion> asignaciones = delegate.buscarPorProfesor(profesor.getId());
        for (Asignacion a : asignaciones) {
            if (a.getUnidad().getId().equals(unidad.getId())) {
                throw new IllegalArgumentException(
                        "El profesor ya tiene asignada esta unidad de aprendizaje.");
            }
        }
    }

    private void validarHoras(UnidadAprendizaje unidad) {
        if (unidad.getHorasClase() < 0 || unidad.getHorasClase() > 4)
            throw new IllegalArgumentException("Las horas de clase deben estar entre 0 y 4.");
        if (unidad.getHorasTaller() < 0 || unidad.getHorasTaller() > 4)
            throw new IllegalArgumentException("Las horas de taller deben estar entre 0 y 4.");
        if (unidad.getHorasLaboratorio() < 0 || unidad.getHorasLaboratorio() > 4)
            throw new IllegalArgumentException("Las horas de laboratorio deben estar entre 0 y 4.");
    }
}