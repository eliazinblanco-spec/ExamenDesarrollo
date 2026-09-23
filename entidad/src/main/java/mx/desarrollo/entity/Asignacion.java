package mx.desarrollo.entity;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "asignacion")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignacion", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idprofesor", nullable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "idunidad", nullable = false)
    private UnidadAprendizaje unidad;

    @Column(name = "dia", nullable = false, length = 20)
    private String dia;

    @Column(name = "horaInicio", nullable = false)
    private Time horaInicio;

    @Column(name = "horaFin", nullable = false)
    private Time horaFin;

    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    public Asignacion() {}

    public Asignacion(Profesor profesor, UnidadAprendizaje unidad) {
        this.profesor = profesor;
        this.unidad = unidad;
        this.dia = "Sin especificar";
        this.horaInicio = Time.valueOf("00:00:00");
        this.horaFin = Time.valueOf("00:00:00");
        this.periodo = "Sin especificar";
    }

    public Integer getId() { return id; }
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    public UnidadAprendizaje getUnidad() { return unidad; }
    public void setUnidad(UnidadAprendizaje unidad) { this.unidad = unidad; }
    public String getDia() { return dia; }
    public void setDia(String dia) { this.dia = dia; }
    public Time getHoraInicio() { return horaInicio; }
    public void setHoraInicio(Time horaInicio) { this.horaInicio = horaInicio; }
    public Time getHoraFin() { return horaFin; }
    public void setHoraFin(Time horaFin) { this.horaFin = horaFin; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
}