package com.una.ac.cr.facturaelectronica_2.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "facturaelectronica_2")
public class UsuariosEntity {
    @Id
    @Column(name = "identificacionu")
    private String identificacionu;
    @Basic
    @Column(name = "nombreu")
    private String nombreu;
    @Basic
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic
    @Column(name = "tipo")
    private String tipo;
    @Basic
    @Column(name = "tipo_Persona")
    private String tipoPersona;
    @Basic
    @Column(name = "aprobado")
    private byte aprobado;
    @OneToMany(mappedBy = "usuariosByProveedorc")
    private Collection<ClientesEntity> clientesByIdentificacionu;
    @OneToMany(mappedBy = "usuariosByIdentificacionUsuario")
    private Collection<FacturasEntity> facturasByIdentificacionu;
    @OneToMany(mappedBy = "usuariosByProveedorp")
    private Collection<ProductosEntity> productosByIdentificacionu;

    public String getIdentificacionu() {
        return identificacionu;
    }

    public void setIdentificacionu(String identificacionu) {
        this.identificacionu = identificacionu;
    }

    public String getNombreu() {
        return nombreu;
    }

    public void setNombreu(String nombreu) {
        this.nombreu = nombreu;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public byte getAprobado() {
        return aprobado;
    }

    public void setAprobado(byte aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return aprobado == that.aprobado && Objects.equals(identificacionu, that.identificacionu) && Objects.equals(nombreu, that.nombreu) && Objects.equals(contrasenia, that.contrasenia) && Objects.equals(tipo, that.tipo) && Objects.equals(tipoPersona, that.tipoPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacionu, nombreu, contrasenia, tipo, tipoPersona, aprobado);
    }

    public Collection<ClientesEntity> getClientesByIdentificacionu() {
        return clientesByIdentificacionu;
    }

    public void setClientesByIdentificacionu(Collection<ClientesEntity> clientesByIdentificacionu) {
        this.clientesByIdentificacionu = clientesByIdentificacionu;
    }

    public Collection<FacturasEntity> getFacturasByIdentificacionu() {
        return facturasByIdentificacionu;
    }

    public void setFacturasByIdentificacionu(Collection<FacturasEntity> facturasByIdentificacionu) {
        this.facturasByIdentificacionu = facturasByIdentificacionu;
    }

    public Collection<ProductosEntity> getProductosByIdentificacionu() {
        return productosByIdentificacionu;
    }

    public void setProductosByIdentificacionu(Collection<ProductosEntity> productosByIdentificacionu) {
        this.productosByIdentificacionu = productosByIdentificacionu;
    }
}
