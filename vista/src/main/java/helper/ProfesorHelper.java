package mx.desarrollo.helper;

import mx.desarrollo.entity.Profesor;
import mx.desarrollo.facade.FacadeProfesor;

import java.util.List;

public class ProfesorHelper {

    private final FacadeProfesor facadeProfesor;

    public ProfesorHelper() {
        this.facadeProfesor = new FacadeProfesor();
    }

    public void registrarProfesor(String nombre, String apellidoPaterno,
                                  String apellidoMaterno, String rfc) {
        facadeProfesor.registrarProfesor(nombre, apellidoPaterno, apellidoMaterno, rfc);
    }

    public List<Profesor> listarProfesores() {
        return facadeProfesor.listarProfesores();
    }

    public void actualizarProfesor(Profesor profesor) {
        facadeProfesor.actualizarProfesor(profesor);
    }

    public void eliminarProfesor(Integer id) {
        facadeProfesor.eliminarProfesor(id);
    }
}