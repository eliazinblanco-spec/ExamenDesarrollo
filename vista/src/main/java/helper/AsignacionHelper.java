package helper;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.integration.ServiceFacadeLocator;

import java.util.List;

public class AsignacionHelper {

    public void asignarUnidades(Profesor profesor, UnidadAprendizaje unidad) {
        ServiceFacadeLocator.getInstanceAsignacionFacade()
                .asignarUnidades(profesor, unidad);
    }

    public List<Asignacion> listarAsignaciones() {
        return ServiceFacadeLocator.getInstanceAsignacionFacade()
                .listarAsignaciones();
    }

    public List<Asignacion> buscarPorProfesor(Integer idProfesor) {
        return ServiceFacadeLocator.getInstanceAsignacionFacade()
                .buscarPorProfesor(idProfesor);
    }

    public void eliminarAsignacion(Integer id) {
        ServiceFacadeLocator.getInstanceAsignacionFacade()
                .eliminarAsignacion(id);
    }
}