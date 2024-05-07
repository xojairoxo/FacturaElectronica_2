package com.una.ac.cr.facturaelectronica_2.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "detalles", schema = "facturaelectronica_2")
public class DetallesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddetalle")
    private int iddetalle;
    @Basic
    @Column(name = "idfacdetalle", insertable=false, updatable=false)
    private int idfacdetalle;
    @Basic
    @Column(name = "codigoproducto", insertable=false, updatable=false)
    private int codigoproducto;
    @Basic
    @Column(name = "cantidad")
    private int cantidad;
    @Basic
    @Column(name = "descripciondetalle")
    private String descripciondetalle;
    @Basic
    @Column(name = "valorfinal")
    private double valorfinal;
    @ManyToOne
    @JoinColumn(name = "idfacdetalle", referencedColumnName = "idfactura", nullable = false)
    private FacturasEntity facturasByIdfacdetalle;
    @ManyToOne
    @JoinColumn(name = "codigoproducto", referencedColumnName = "idproducto", nullable = false)
    private ProductosEntity productosByCodigoproducto;

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIdfacdetalle() {
        return idfacdetalle;
    }

    public void setIdfacdetalle(int idfacdetalle) {
        this.idfacdetalle = idfacdetalle;
    }

    public int getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(int codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripciondetalle() {
        return descripciondetalle;
    }

    public void setDescripciondetalle(String descripciondetalle) {
        this.descripciondetalle = descripciondetalle;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(double valorfinal) {
        this.valorfinal = valorfinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallesEntity that = (DetallesEntity) o;
        return iddetalle == that.iddetalle && idfacdetalle == that.idfacdetalle && codigoproducto == that.codigoproducto && cantidad == that.cantidad && Double.compare(valorfinal, that.valorfinal) == 0 && Objects.equals(descripciondetalle, that.descripciondetalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddetalle, idfacdetalle, codigoproducto, cantidad, descripciondetalle, valorfinal);
    }

    public FacturasEntity getFacturasByIdfacdetalle() {
        return facturasByIdfacdetalle;
    }

    public void setFacturasByIdfacdetalle(FacturasEntity facturasByIdfacdetalle) {
        this.facturasByIdfacdetalle = facturasByIdfacdetalle;
    }

    public ProductosEntity getProductosByCodigoproducto() {
        return productosByCodigoproducto;
    }

    public void setProductosByCodigoproducto(ProductosEntity productosByCodigoproducto) {
        this.productosByCodigoproducto = productosByCodigoproducto;
    }
}
