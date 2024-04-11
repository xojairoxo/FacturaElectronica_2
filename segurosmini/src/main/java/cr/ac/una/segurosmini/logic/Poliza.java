package cr.ac.una.segurosmini.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Poliza {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero")
    private int numero;
    @Basic
    @Column(name = "placa")
    private String placa;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "identificacion", nullable = false)
    private Cliente clienteByCliente;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poliza poliza = (Poliza) o;
        return numero == poliza.numero && Objects.equals(placa, poliza.placa) && Objects.equals(descripcion, poliza.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, placa, descripcion);
    }

    public Cliente getClienteByCliente() {
        return clienteByCliente;
    }

    public void setClienteByCliente(Cliente clienteByCliente) {
        this.clienteByCliente = clienteByCliente;
    }
}
