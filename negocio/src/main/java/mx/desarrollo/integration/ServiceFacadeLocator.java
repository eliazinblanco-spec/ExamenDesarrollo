package mx.desarrollo.integration;

import mx.desarrollo.facade.AsignacionFacade;
import mx.desarrollo.facade.AsignacionesFacade;
import mx.desarrollo.facade.FacadeProfesor;
import mx.desarrollo.facade.FacadeUsuario;
import mx.desarrollo.facade.UnidadAprendizajeFacade;

public class ServiceFacadeLocator {

    private static FacadeUsuario facadeUsuario;
    private static FacadeProfesor facadeProfesor;
    private static AsignacionFacade asignacionFacade;
    private static UnidadAprendizajeFacade unidadAprendizajeFacade;
    private static AsignacionesFacade asignacionesFacade;

    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
        }
        return facadeUsuario;
    }

    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
        }
        return facadeProfesor;
    }

    public static AsignacionFacade getInstanceAsignacionFacade() {
        if (asignacionFacade == null) {
            asignacionFacade = new AsignacionFacade();
        }
        return asignacionFacade;
    }

    public static UnidadAprendizajeFacade getInstanceUnidadAprendizajeFacade() {
        if (unidadAprendizajeFacade == null) {
            unidadAprendizajeFacade = new UnidadAprendizajeFacade();
        }
        return unidadAprendizajeFacade;
    }

    public static AsignacionesFacade getInstanceAsignacionesFacade() {
        if (asignacionesFacade == null) {
            asignacionesFacade = new AsignacionesFacade();
        }
        return asignacionesFacade;
    }
}