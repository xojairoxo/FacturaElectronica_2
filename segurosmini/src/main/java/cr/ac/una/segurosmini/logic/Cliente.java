package cr.ac.una.segurosmini.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "identificacion")
    private String identificacion;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "clienteByCliente")
    private Collection<Poliza> polizasByIdentificacion;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(identificacion, cliente.identificacion) && Objects.equals(nombre, cliente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion, nombre);
    }

    public Collection<Poliza> getPolizasByIdentificacion() {
        return polizasByIdentificacion;
    }

    public void setPolizasByIdentificacion(Collection<Poliza> polizasByIdentificacion) {
        this.polizasByIdentificacion = polizasByIdentificacion;
    }
}
