package una.ac.cr.accesousuariobackend.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "datos_usuario", schema = "usuariosbackend", catalog = "")
public class DatosUsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_datos_usuarios")
    private int idDatosUsuarios;
    @Basic
    @Column(name = "falcultad")
    private String falcultad;
    @Basic
    @Column(name = "Escuela")
    private String escuela;
    @Basic
    @Column(name = "Carrera")
    private String carrera;
    @Basic
    @Column(name = "fecha_ingreso")
    private String fechaIngreso;
    @Basic
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public int getIdDatosUsuarios() {
        return idDatosUsuarios;
    }

    public void setIdDatosUsuarios(int idDatosUsuarios) {
        this.idDatosUsuarios = idDatosUsuarios;
    }

    public String getFalcultad() {
        return falcultad;
    }

    public void setFalcultad(String falcultad) {
        this.falcultad = falcultad;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosUsuarioEntity that = (DatosUsuarioEntity) o;
        return idDatosUsuarios == that.idDatosUsuarios && Objects.equals(falcultad, that.falcultad) && Objects.equals(escuela, that.escuela) && Objects.equals(carrera, that.carrera) && Objects.equals(fechaIngreso, that.fechaIngreso) && Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDatosUsuarios, falcultad, escuela, carrera, fechaIngreso, idUsuario);
    }
}
