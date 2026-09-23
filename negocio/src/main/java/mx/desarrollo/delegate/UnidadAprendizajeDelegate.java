package mx.desarrollo.delegate;

import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class UnidadAprendizajeDelegate {

    public void registrarUnidad(UnidadAprendizaje unidad) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().registrarUnidad(unidad);
    }

    public List<UnidadAprendizaje> listarUnidades() {
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().listarTodos();
    }

    public void actualizarUnidad(UnidadAprendizaje unidad) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().actualizarUnidad(unidad);
    }

    public void eliminarUnidad(Integer id) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().eliminarUnidad(id);
    }
}