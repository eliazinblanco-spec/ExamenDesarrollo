package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprofesor", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidoMaterno", nullable = false, length = 50)
    private String apellidoMaterno;

    @Pattern(regexp = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$",
            message = "El RFC no tiene un formato válido")
    @NotNull
    @Column(name = "rfc", nullable = false, length = 13, unique = true)
    private String rfc;

    public Profesor() {}

    public Profesor(String nombre, String apellidoPaterno,
                    String apellidoMaterno, String rfc) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String v) { this.apellidoPaterno = v; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String v) { this.apellidoMaterno = v; }
    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
}
