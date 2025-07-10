package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import com.proyecto.domain.Categoria;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_producto")
    private Long idProducto;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    priveta String descripcion;
    private double precio;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    Categoria categoria;

    public Producto() {
    }

    public Producto(String producto, boolean activo) {
        this.descripcion = producto;
        this.activo = activo;
    }
    
}