package mx.desarrollo.integration;

import mx.desarrollo.facade.AsignacionFacade;
import mx.desarrollo.facade.FacadeProfesor;
import mx.desarrollo.facade.FacadeUsuario;

public class ServiceFacadeLocator {

    private static FacadeUsuario facadeUsuario;
    private static FacadeProfesor facadeProfesor;
    private static AsignacionFacade asignacionFacade;

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
}