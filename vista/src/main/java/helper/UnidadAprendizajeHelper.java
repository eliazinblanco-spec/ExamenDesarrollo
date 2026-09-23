package helper;

import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.integration.ServiceFacadeLocator;

import java.util.List;

public class UnidadAprendizajeHelper {

    public void registrarUnidad(String nombre, Byte horasClase,
                                Byte horasTaller, Byte horasLaboratorio) {
        ServiceFacadeLocator.getInstanceUnidadAprendizajeFacade()
                .registrarUnidad(nombre, horasClase, horasTaller, horasLaboratorio);
    }

    public List<UnidadAprendizaje> listarUnidades() {
        return ServiceFacadeLocator.getInstanceUnidadAprendizajeFacade()
                .listarUnidades();
    }

    public void actualizarUnidad(UnidadAprendizaje unidad) {
        ServiceFacadeLocator.getInstanceUnidadAprendizajeFacade()
                .actualizarUnidad(unidad);
    }

    public void eliminarUnidad(Integer id) {
        ServiceFacadeLocator.getInstanceUnidadAprendizajeFacade()
                .eliminarUnidad(id);
    }
}