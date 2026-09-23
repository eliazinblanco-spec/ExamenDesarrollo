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

    private Profesor profesorSeleccionado;
    private UnidadAprendizaje unidadSeleccionada;

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
            asignacionHelper.asignarUnidades(profesorSeleccionado, unidadSeleccionada);
            cargarAsignaciones();
            limpiarFormulario();
            mensaje(FacesMessage.SEVERITY_INFO, "Asignación realizada exitosamente.");
        } catch (IllegalArgumentException e) {
            mensaje(FacesMessage.SEVERITY_WARN, e.getMessage());
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al realizar la asignación. Intente de nuevo.");
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
        unidades = ServiceLocator.getInstanceAsignacionDAO()
                .listarTodos().stream()
                .map(Asignacion::getUnidad)
                .distinct()
                .collect(java.util.stream.Collectors.toList());
        if (unidades.isEmpty()) {
            unidades = new java.util.ArrayList<>();
        }
    }

    private void cargarAsignaciones() {
        asignaciones = asignacionHelper.listarAsignaciones();
    }

    private void limpiarFormulario() {
        profesorSeleccionado = null;
        unidadSeleccionada = null;
    }

    private void mensaje(FacesMessage.Severity sev, String texto) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(sev, texto, null));
    }

    public Profesor getProfesorSeleccionado() { return profesorSeleccionado; }
    public void setProfesorSeleccionado(Profesor p) { this.profesorSeleccionado = p; }
    public UnidadAprendizaje getUnidadSeleccionada() { return unidadSeleccionada; }
    public void setUnidadSeleccionada(UnidadAprendizaje u) { this.unidadSeleccionada = u; }
    public List<Profesor> getProfesores() { return profesores; }
    public List<UnidadAprendizaje> getUnidades() { return unidades; }
    public List<Asignacion> getAsignaciones() { return asignaciones; }
}