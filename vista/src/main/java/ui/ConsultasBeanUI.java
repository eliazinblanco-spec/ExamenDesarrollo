package ui;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.entity.Asignacion;
import helper.ConsultasAsignacionesHelper;

import java.io.Serializable;
import java.util.List;

@Named("consultasUI")
@SessionScoped
public class ConsultasBeanUI implements Serializable {

    private final ConsultasAsignacionesHelper helper;
    private List<Asignacion> asignaciones;
    private Integer idProfesorFiltro;
    private Integer idUnidadFiltro;

    public ConsultasBeanUI() {
        this.helper = new ConsultasAsignacionesHelper();
    }

    @PostConstruct
    public void init() {
        cargarAsignaciones();
    }

    public void cargarAsignaciones() {
        asignaciones = helper.mostrarAsignaciones();
    }

    public void buscarPorProfesor() {
        try {
            if (idProfesorFiltro != null) {
                asignaciones = helper.buscarPorProfesor(idProfesorFiltro);
            } else {
                cargarAsignaciones();
            }
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al buscar asignaciones.");
        }
    }

    public void buscarPorUnidad() {
        try {
            if (idUnidadFiltro != null) {
                asignaciones = helper.buscarPorUnidad(idUnidadFiltro);
            } else {
                cargarAsignaciones();
            }
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error al buscar asignaciones.");
        }
    }

    public void limpiarFiltros() {
        idProfesorFiltro = null;
        idUnidadFiltro = null;
        cargarAsignaciones();
    }

    private void mensaje(FacesMessage.Severity sev, String texto) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(sev, texto, null));
    }

    public List<Asignacion> getAsignaciones() { return asignaciones; }
    public Integer getIdProfesorFiltro() { return idProfesorFiltro; }
    public void setIdProfesorFiltro(Integer id) { this.idProfesorFiltro = id; }
    public Integer getIdUnidadFiltro() { return idUnidadFiltro; }
    public void setIdUnidadFiltro(Integer id) { this.idUnidadFiltro = id; }
}
