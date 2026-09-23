package mx.desarrollo.facade;

import mx.desarrollo.delegate.UnidadAprendizajeDelegate;
import mx.desarrollo.entity.UnidadAprendizaje;

import java.util.List;

public class UnidadAprendizajeFacade {

    private final UnidadAprendizajeDelegate delegate;

    public UnidadAprendizajeFacade() {
        this.delegate = new UnidadAprendizajeDelegate();
    }

    public void registrarUnidad(String nombre, Byte horasClase,
                                Byte horasTaller, Byte horasLaboratorio) {
        validarLongitud(nombre);
        validarHoras(horasClase, horasTaller, horasLaboratorio);
        UnidadAprendizaje unidad = new UnidadAprendizaje(
                nombre.trim(), horasClase, horasTaller, horasLaboratorio);
        delegate.registrarUnidad(unidad);
    }

    public List<UnidadAprendizaje> listarUnidades() {
        return delegate.listarUnidades();
    }

    public void actualizarUnidad(UnidadAprendizaje unidad) {
        validarLongitud(unidad.getNombre());
        validarHoras(unidad.getHorasClase(), unidad.getHorasTaller(),
                unidad.getHorasLaboratorio());
        delegate.actualizarUnidad(unidad);
    }

    public void eliminarUnidad(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        delegate.eliminarUnidad(id);
    }

    private void validarLongitud(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio.");
        if (nombre.trim().length() > 50)
            throw new IllegalArgumentException("El nombre no puede exceder 50 caracteres.");
    }

    private void validarHoras(Byte horasClase, Byte horasTaller, Byte horasLaboratorio) {
        if (horasClase == null || horasClase < 0 || horasClase > 4)
            throw new IllegalArgumentException("Las horas de clase deben estar entre 0 y 4.");
        if (horasTaller == null || horasTaller < 0 || horasTaller > 4)
            throw new IllegalArgumentException("Las horas de taller deben estar entre 0 y 4.");
        if (horasLaboratorio == null || horasLaboratorio < 0 || horasLaboratorio > 4)
            throw new IllegalArgumentException("Las horas de laboratorio deben estar entre 0 y 4.");
    }
}