package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.entity.Profesor;

import java.util.List;

public class FacadeProfesor {

    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public void registrarProfesor(String nombre, String apellidoPaterno,
                                  String apellidoMaterno, String rfc) {
        validarCampos(nombre, apellidoPaterno, apellidoMaterno, rfc);
        Profesor p = new Profesor(nombre.trim(), apellidoPaterno.trim(),
                apellidoMaterno.trim(), rfc.trim().toUpperCase());
        delegateProfesor.registrarProfesor(p);
    }

    public List<Profesor> listarProfesores() {
        return delegateProfesor.listarProfesores();
    }

    public boolean existeRFC(String rfc) {
        return delegateProfesor.existeRFC(rfc);
    }

    public void actualizarProfesor(Profesor profesor) {
        validarCampos(profesor.getNombre(), profesor.getApellidoPaterno(),
                profesor.getApellidoMaterno(), profesor.getRfc());
        delegateProfesor.actualizarProfesor(profesor);
    }

    public void eliminarProfesor(Integer id) {
        if (id == null) throw new IllegalArgumentException("ID no puede ser nulo.");
        delegateProfesor.eliminarProfesor(id);
    }

    private void validarCampos(String nombre, String apellidoPaterno,
                               String apellidoMaterno, String rfc) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio.");
        if (nombre.trim().length() > 50)
            throw new IllegalArgumentException("El nombre no puede exceder 50 caracteres.");
        if (apellidoPaterno == null || apellidoPaterno.trim().isEmpty())
            throw new IllegalArgumentException("El apellido paterno es obligatorio.");
        if (apellidoPaterno.trim().length() > 50)
            throw new IllegalArgumentException("El apellido paterno no puede exceder 50 caracteres.");
        if (apellidoMaterno == null || apellidoMaterno.trim().isEmpty())
            throw new IllegalArgumentException("El apellido materno es obligatorio.");
        if (apellidoMaterno.trim().length() > 50)
            throw new IllegalArgumentException("El apellido materno no puede exceder 50 caracteres.");
        if (rfc == null || rfc.trim().isEmpty())
            throw new IllegalArgumentException("El RFC es obligatorio.");
        if (!rfc.trim().toUpperCase().matches("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$"))
            throw new IllegalArgumentException("RFC inválido. Formato: 4 letras + 6 dígitos + 3 alfanuméricos.");
    }
}