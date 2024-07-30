package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data//especificar que es una capa de datos 
@Entity//esta clase esta enlazada a una tabla en la base de datos
@Table(name = "categoria")//especificar cual entidad
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;//auto increment en java :0

    @Id//con estas tres lineas se valida la base de datos con la progra sobre el id, tienen que ser iguales
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name = "id_categoria", updatable = false)
    List<Producto> productos;

    public Categoria() {

    }

    public Categoria(String categoria, boolean activo) {
        this.descripcion = categoria;
        this.activo = activo;
    }

}
