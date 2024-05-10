package com.una.ac.cr.facturaelectronica_2.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "clientes", schema = "facturaelectronica_2")
public class ClientesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcliente")
    private int idcliente;
    @Basic
    @Column(name = "identificacionc")
    private String identificacionc;
    @Basic
    @Column(name = "nombrec")
    private String nombrec;
    @Basic
    @Column(name = "correo")
    private String correo;
    @Basic
    @Column(name = "telefono")
    private int telefono;
    @Basic
    @Column(name = "proveedorc", insertable=false, updatable=false)
    private String proveedorc;
    @ManyToOne
    @JoinColumn(name = "proveedorc", referencedColumnName = "identificacionu", nullable = false)
    private UsuariosEntity usuariosByProveedorc;
    @OneToMany(mappedBy = "clientesByIdentificacionCliente")
    private Collection<FacturasEntity> facturasByIdcliente;

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdentificacionc() {
        return identificacionc;
    }

    public void setIdentificacionc(String identificacionc) {
        this.identificacionc = identificacionc;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getProveedorc() {
        return proveedorc;
    }

    public void setProveedorc(String proveedorc) {
        this.proveedorc = proveedorc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientesEntity that = (ClientesEntity) o;
        return idcliente == that.idcliente && telefono == that.telefono && Objects.equals(identificacionc, that.identificacionc) && Objects.equals(nombrec, that.nombrec) && Objects.equals(correo, that.correo) && Objects.equals(proveedorc, that.proveedorc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcliente, identificacionc, nombrec, correo, telefono, proveedorc);
    }

    public UsuariosEntity getUsuariosByProveedorc() {
        return usuariosByProveedorc;
    }

    public void setUsuariosByProveedorc(UsuariosEntity usuariosByProveedorc) {
        this.usuariosByProveedorc = usuariosByProveedorc;
    }

    public Collection<FacturasEntity> getFacturasByIdcliente() {
        return facturasByIdcliente;
    }

    public void setFacturasByIdcliente(Collection<FacturasEntity> facturasByIdcliente) {
        this.facturasByIdcliente = facturasByIdcliente;
    }
}
