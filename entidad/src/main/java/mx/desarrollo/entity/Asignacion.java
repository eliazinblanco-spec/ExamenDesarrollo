package mx.desarrollo.entity;

import jakarta.persistence.*;

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

    public Asignacion() {}

    public Asignacion(Profesor profesor, UnidadAprendizaje unidad) {
        this.profesor = profesor;
        this.unidad = unidad;
    }

    public Integer getId() { return id; }
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    public UnidadAprendizaje getUnidad() { return unidad; }
    public void setUnidad(UnidadAprendizaje unidad) { this.unidad = unidad; }
}