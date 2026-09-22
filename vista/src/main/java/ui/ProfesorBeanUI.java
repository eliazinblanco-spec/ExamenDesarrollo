package mx.desarrollo.ui;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.helper.ProfesorHelper;

import java.io.Serializable;
import java.util.List;

@Named("profesorUI")
@SessionScoped
public class ProfesorBeanUI implements Serializable {

    private final ProfesorHelper profesorHelper;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rfc;

    private List<Profesor> profesores;
    private Profesor profesorSeleccionado;
    private boolean modoEdicion = false;

    public ProfesorBeanUI() {
        this.profesorHelper = new ProfesorHelper();
    }

    @PostConstruct
    public void init() {
        cargarProfesores();
    }

    public void registrarProfesor() {
        try {
            profesorHelper.registrarProfesor(nombre, apellidoPaterno, apellidoMaterno, rfc);
            cargarProfesores();
            limpiarFormulario();
            mensaje(FacesMessage.SEVERITY_INFO, "Profesor registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            mensaje(FacesMessage.SEVERITY_WARN, e.getMessage());
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al registrar. Intente de nuevo.");
        }
    }

    public void seleccionarParaEditar(Profesor profesor) {
        this.profesorSeleccionado = profesor;
        this.nombre          = profesor.getNombre();
        this.apellidoPaterno = profesor.getApellidoPaterno();
        this.apellidoMaterno = profesor.getApellidoMaterno();
        this.rfc             = profesor.getRfc();
        this.modoEdicion     = true;
    }

    public void actualizarProfesor() {
        try {
            profesorSeleccionado.setNombre(nombre.trim());
            profesorSeleccionado.setApellidoPaterno(apellidoPaterno.trim());
            profesorSeleccionado.setApellidoMaterno(apellidoMaterno.trim());
            profesorSeleccionado.setRfc(rfc.trim().toUpperCase());
            profesorHelper.actualizarProfesor(profesorSeleccionado);
            cargarProfesores();
            limpiarFormulario();
            mensaje(FacesMessage.SEVERITY_INFO, "Profesor actualizado exitosamente.");
        } catch (IllegalArgumentException e) {
            mensaje(FacesMessage.SEVERITY_WARN, e.getMessage());
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al actualizar. Intente de nuevo.");
        }
    }

    public void eliminarProfesor(Profesor profesor) {
        try {
            profesorHelper.eliminarProfesor(profesor.getId());
            cargarProfesores();
            mensaje(FacesMessage.SEVERITY_INFO, "Profesor eliminado exitosamente.");
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al eliminar el profesor.");
        }
    }

    public void cancelarEdicion() {
        limpiarFormulario();
    }

    private void cargarProfesores() {
        profesores = profesorHelper.listarProfesores();
    }

    private void limpiarFormulario() {
        nombre = null; apellidoPaterno = null;
        apellidoMaterno = null; rfc = null;
        profesorSeleccionado = null; modoEdicion = false;
    }

    private void mensaje(FacesMessage.Severity sev, String texto) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(sev, texto, null));
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String v) { this.apellidoPaterno = v; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String v) { this.apellidoMaterno = v; }
    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
    public List<Profesor> getProfesores() { return profesores; }
    public Profesor getProfesorSeleccionado() { return profesorSeleccionado; }
    public boolean isModoEdicion() { return modoEdicion; }
}