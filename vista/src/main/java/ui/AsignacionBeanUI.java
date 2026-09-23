package ui;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.persistence.integration.ServiceLocator;
import helper.AsignacionHelper;

import java.io.Serializable;
import java.util.List;

@Named("asignacionUI")
@SessionScoped
public class AsignacionBeanUI implements Serializable {

    private final AsignacionHelper asignacionHelper;

    private Integer idProfesorSeleccionado;
    private Integer idUnidadSeleccionada;

    private List<Profesor> profesores;
    private List<UnidadAprendizaje> unidades;
    private List<Asignacion> asignaciones;

    public AsignacionBeanUI() {
        this.asignacionHelper = new AsignacionHelper();
    }

    @PostConstruct
    public void init() {
        cargarProfesores();
        cargarUnidades();
        cargarAsignaciones();
    }

    public void asignarUnidades() {
        try {
            Profesor profesor = ServiceLocator.getInstanceProfesorDAO()
                    .find(idProfesorSeleccionado).orElse(null);
            UnidadAprendizaje unidad = ServiceLocator.getInstanceUnidadAprendizajeDAO()
                    .find(idUnidadSeleccionada).orElse(null);
            asignacionHelper.asignarUnidades(profesor, unidad);
            cargarAsignaciones();
            limpiarFormulario();
            mensaje(FacesMessage.SEVERITY_INFO, "Asignación realizada exitosamente.");
        } catch (IllegalArgumentException e) {
            mensaje(FacesMessage.SEVERITY_WARN, e.getMessage());
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al realizar la asignación.");
        }
    }

    public void eliminarAsignacion(Asignacion asignacion) {
        try {
            asignacionHelper.eliminarAsignacion(asignacion.getId());
            cargarAsignaciones();
            mensaje(FacesMessage.SEVERITY_INFO, "Asignación eliminada exitosamente.");
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al eliminar la asignación.");
        }
    }

    private void cargarProfesores() {
        profesores = ServiceLocator.getInstanceProfesorDAO().listarTodos();
    }

    private void cargarUnidades() {
        unidades = ServiceLocator.getInstanceUnidadAprendizajeDAO().listarTodos();
    }

    private void cargarAsignaciones() {
        asignaciones = asignacionHelper.listarAsignaciones();
    }

    private void limpiarFormulario() {
        idProfesorSeleccionado = null;
        idUnidadSeleccionada = null;
    }

    private void mensaje(FacesMessage.Severity sev, String texto) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(sev, texto, null));
    }

    public Integer getIdProfesorSeleccionado() { return idProfesorSeleccionado; }
    public void setIdProfesorSeleccionado(Integer id) { this.idProfesorSeleccionado = id; }
    public Integer getIdUnidadSeleccionada() { return idUnidadSeleccionada; }
    public void setIdUnidadSeleccionada(Integer id) { this.idUnidadSeleccionada = id; }
    public List<Profesor> getProfesores() { return profesores; }
    public List<UnidadAprendizaje> getUnidades() { return unidades; }
    public List<Asignacion> getAsignaciones() { return asignaciones; }
}