package ui;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.entity.UnidadAprendizaje;
import helper.UnidadAprendizajeHelper;

import java.io.Serializable;
import java.util.List;

@Named("unidadUI")
@SessionScoped
public class UnidadAprendizajeBeanUI implements Serializable {

    private final UnidadAprendizajeHelper helper;

    private String nombre;
    private Byte horasClase;
    private Byte horasTaller;
    private Byte horasLaboratorio;

    private List<UnidadAprendizaje> unidades;
    private UnidadAprendizaje unidadSeleccionada;
    private boolean modoEdicion = false;

    public UnidadAprendizajeBeanUI() {
        this.helper = new UnidadAprendizajeHelper();
    }

    @PostConstruct
    public void init() {
        cargarUnidades();
    }

    public void registrarUnidad() {
        try {
            helper.registrarUnidad(nombre, horasClase, horasTaller, horasLaboratorio);
            cargarUnidades();
            limpiarFormulario();
            mensaje(FacesMessage.SEVERITY_INFO, "Unidad registrada exitosamente.");
        } catch (IllegalArgumentException e) {
            mensaje(FacesMessage.SEVERITY_WARN, e.getMessage());
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al registrar. Intente de nuevo.");
        }
    }

    public void seleccionarParaEditar(UnidadAprendizaje unidad) {
        this.unidadSeleccionada = unidad;
        this.nombre            = unidad.getNombre();
        this.horasClase        = unidad.getHorasClase();
        this.horasTaller       = unidad.getHorasTaller();
        this.horasLaboratorio  = unidad.getHorasLaboratorio();
        this.modoEdicion       = true;
    }

    public void actualizarUnidad() {
        try {
            unidadSeleccionada.setNombre(nombre.trim());
            unidadSeleccionada.setHorasClase(horasClase);
            unidadSeleccionada.setHorasTaller(horasTaller);
            unidadSeleccionada.setHorasLaboratorio(horasLaboratorio);
            helper.actualizarUnidad(unidadSeleccionada);
            cargarUnidades();
            limpiarFormulario();
            mensaje(FacesMessage.SEVERITY_INFO, "Unidad actualizada exitosamente.");
        } catch (IllegalArgumentException e) {
            mensaje(FacesMessage.SEVERITY_WARN, e.getMessage());
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al actualizar. Intente de nuevo.");
        }
    }

    public void eliminarUnidad(UnidadAprendizaje unidad) {
        try {
            helper.eliminarUnidad(unidad.getId());
            cargarUnidades();
            mensaje(FacesMessage.SEVERITY_INFO, "Unidad eliminada exitosamente.");
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al eliminar la unidad.");
        }
    }

    public void cancelarEdicion() {
        limpiarFormulario();
    }

    private void cargarUnidades() {
        unidades = helper.listarUnidades();
    }

    private void limpiarFormulario() {
        nombre = null; horasClase = null;
        horasTaller = null; horasLaboratorio = null;
        unidadSeleccionada = null; modoEdicion = false;
    }

    private void mensaje(FacesMessage.Severity sev, String texto) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(sev, texto, null));
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Byte getHorasClase() { return horasClase; }
    public void setHorasClase(Byte horasClase) { this.horasClase = horasClase; }
    public Byte getHorasTaller() { return horasTaller; }
    public void setHorasTaller(Byte horasTaller) { this.horasTaller = horasTaller; }
    public Byte getHorasLaboratorio() { return horasLaboratorio; }
    public void setHorasLaboratorio(Byte horasLaboratorio) { this.horasLaboratorio = horasLaboratorio; }
    public List<UnidadAprendizaje> getUnidades() { return unidades; }
    public UnidadAprendizaje getUnidadSeleccionada() { return unidadSeleccionada; }
    public boolean isModoEdicion() { return modoEdicion; }
}