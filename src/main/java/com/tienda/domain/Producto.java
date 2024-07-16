package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data//especificar que es una capa de datos 
@Entity//esta clase esta enlazada a una tabla en la base de datos
@Table(name = "producto")//especificar cual entidad
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;//auto increment en java :0

    @Id//con estas tres lineas se valida la base de datos con la progra sobre el id, tienen que ser iguales
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private String detalle;
    private int existencias;
    private double precio;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    private long idCategoria;
    
    
    public Producto() {

    }

    public Producto(String producto, boolean activo) {
        this.descripcion = producto;
        this.activo = activo;
    }

}
