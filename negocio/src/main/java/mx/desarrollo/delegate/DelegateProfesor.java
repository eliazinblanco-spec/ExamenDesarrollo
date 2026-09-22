package mx.desarrollo.delegate;

import mx.desarrollo.entity.Profesor;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class DelegateProfesor {

    public void registrarProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDAO().registrarProfesor(profesor);
    }

    public boolean existeRFC(String rfc) {
        return ServiceLocator.getInstanceProfesorDAO().existeRFC(rfc);
    }

    public List<Profesor> listarProfesores() {
        return ServiceLocator.getInstanceProfesorDAO().listarTodos();
    }

    public void actualizarProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDAO().actualizarProfesor(profesor);
    }

    public void eliminarProfesor(Integer id) {
        ServiceLocator.getInstanceProfesorDAO().eliminarProfesor(id);
    }
}