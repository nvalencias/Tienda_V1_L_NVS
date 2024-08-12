package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository <Producto,Long>{
    
    //consultas ampliadas cam1
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);//consultas ampliadas
    
    
    //consultas ampliadas con JPQL cam2
    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf")double precioInf,@Param("precioSup") double precioSup);
    
    
    //consultas ampliadas nativas cam3
    @Query(nativeQuery = true,  value= "SELECT * FROM  producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf")double precioInf,@Param("precioSup") double precioSup);
}
