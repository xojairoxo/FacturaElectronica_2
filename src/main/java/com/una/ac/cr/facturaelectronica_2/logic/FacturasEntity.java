package com.una.ac.cr.facturaelectronica_2.logic;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "facturas", schema = "facturaelectronica_2")
public class FacturasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfactura")
    private int idfactura;
    @Basic
    @Column(name = "identificacion_usuario", insertable=false, updatable=false)
    private String identificacionUsuario;
    @Basic
    @Column(name = "identificacion_cliente", insertable=false, updatable=false)
    private int identificacionCliente;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @OneToMany(mappedBy = "facturasByIdfacdetalle")
    private Collection<DetallesEntity> detallesByIdfactura;
    @ManyToOne
    @JoinColumn(name = "identificacion_usuario", referencedColumnName = "identificacionu", nullable = false)
    private UsuariosEntity usuariosByIdentificacionUsuario;
    @ManyToOne
    @JoinColumn(name = "identificacion_cliente", referencedColumnName = "idcliente", nullable = false)
    private ClientesEntity clientesByIdentificacionCliente;

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(int identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacturasEntity that = (FacturasEntity) o;
        return idfactura == that.idfactura && identificacionCliente == that.identificacionCliente && Objects.equals(identificacionUsuario, that.identificacionUsuario) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfactura, identificacionUsuario, identificacionCliente, fecha);
    }

    public Collection<DetallesEntity> getDetallesByIdfactura() {
        return detallesByIdfactura;
    }

    public void setDetallesByIdfactura(Collection<DetallesEntity> detallesByIdfactura) {
        this.detallesByIdfactura = detallesByIdfactura;
    }

    public UsuariosEntity getUsuariosByIdentificacionUsuario() {
        return usuariosByIdentificacionUsuario;
    }

    public void setUsuariosByIdentificacionUsuario(UsuariosEntity usuariosByIdentificacionUsuario) {
        this.usuariosByIdentificacionUsuario = usuariosByIdentificacionUsuario;
    }

    public ClientesEntity getClientesByIdentificacionCliente() {
        return clientesByIdentificacionCliente;
    }

    public void setClientesByIdentificacionCliente(ClientesEntity clientesByIdentificacionCliente) {
        this.clientesByIdentificacionCliente = clientesByIdentificacionCliente;
    }
}
