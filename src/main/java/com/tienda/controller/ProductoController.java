package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/categoria")//(categoria/listado)
public class ProductoController {
    
    @Autowired
    private ProductoService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getProductos(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", categorias.size());
        return "/categoria/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(Producto categoria) {
        return "/categoria/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
        @PostMapping("/guardar")
    public String categoriaGuardar(Producto categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            categoria.getIdProducto()));
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String categoriaEliminar(Producto categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String categoriaModificar(Producto categoria, Model model) {
        categoria = categoriaService.getProducto(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}