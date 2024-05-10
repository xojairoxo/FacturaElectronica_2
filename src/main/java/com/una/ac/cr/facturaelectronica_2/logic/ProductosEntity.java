package com.una.ac.cr.facturaelectronica_2.logic;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "productos", schema = "facturaelectronica_2")
public class ProductosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproducto")
    private int idproducto;
    @Basic
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio")
    private double precio;
    @Basic
    @Column(name = "proveedorp", insertable=false, updatable=false)
    private String proveedorp;
    @OneToMany(mappedBy = "productosByCodigoproducto")
    private Collection<DetallesEntity> detallesByIdproducto;
    @ManyToOne
    @JoinColumn(name = "proveedorp", referencedColumnName = "identificacionu", nullable = false)
    private UsuariosEntity usuariosByProveedorp;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProveedorp() {
        return proveedorp;
    }

    public void setProveedorp(String proveedorp) {
        this.proveedorp = proveedorp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosEntity that = (ProductosEntity) o;
        return idproducto == that.idproducto && Double.compare(precio, that.precio) == 0 && Objects.equals(codigo, that.codigo) && Objects.equals(descripcion, that.descripcion) && Objects.equals(proveedorp, that.proveedorp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproducto, codigo, descripcion, precio, proveedorp);
    }

    public Collection<DetallesEntity> getDetallesByIdproducto() {
        return detallesByIdproducto;
    }

    public void setDetallesByIdproducto(Collection<DetallesEntity> detallesByIdproducto) {
        this.detallesByIdproducto = detallesByIdproducto;
    }

    public UsuariosEntity getUsuariosByProveedorp() {
        return usuariosByProveedorp;
    }

    public void setUsuariosByProveedorp(UsuariosEntity usuariosByProveedorp) {
        this.usuariosByProveedorp = usuariosByProveedorp;
    }
}
