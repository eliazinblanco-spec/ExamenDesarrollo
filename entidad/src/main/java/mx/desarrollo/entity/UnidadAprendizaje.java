package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "unidad_aprendizaje")
public class UnidadAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idunidad", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "horasClase", nullable = false)
    private Byte horasClase;

    @Column(name = "horasTaller", nullable = false)
    private Byte horasTaller;

    @Column(name = "horasLaboratorio", nullable = false)
    private Byte horasLaboratorio;

    public UnidadAprendizaje() {}

    public UnidadAprendizaje(String nombre, Byte horasClase,
                             Byte horasTaller, Byte horasLaboratorio) {
        this.nombre = nombre;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Byte getHorasClase() { return horasClase; }
    public void setHorasClase(Byte horasClase) { this.horasClase = horasClase; }
    public Byte getHorasTaller() { return horasTaller; }
    public void setHorasTaller(Byte horasTaller) { this.horasTaller = horasTaller; }
    public Byte getHorasLaboratorio() { return horasLaboratorio; }
    public void setHorasLaboratorio(Byte horasLaboratorio) { this.horasLaboratorio = horasLaboratorio; }
}