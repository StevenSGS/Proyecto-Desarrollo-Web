

package com.proyecto.controller;

import com.proyecto.domain.Producto;
import com.proyecto.service.ProductoService;
import com.proyecto.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/producto")
public class ProductoController {
     @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")//localhost:8080/producto/listado
    public String inicio(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);//Union del codigo con la vista
        model.addAttribute("totalProductos", productos.size());
        return "/producto/listado";
    }
    
    @Getmapping("/nuevo")//localhost:8080/producto/nuevo
    public String productoNuevo(Producto producto){
        return "/producto/modifica";
    }
    
    
    @PostMapping("/guardar")
public String productoGuardar(Producto producto,
        @RequestParam("imagenFile") MultipartFile imagenFile) {
    if (!imagenFile.isEmpty()) {
        
    }
    productoService.save(producto);
    return "redirect:/producto/listado";
    
}

@GetMapping("/eliminar/{idProducto}")
public String productoEliminar(Producto producto) {
    productoService.delete(producto);
    return "redirect:/producto/listado";
}

@GetMapping("/modificar/{idProducto}")
public String productoModificar(Producto producto, Model model) {
    producto = productoService.getProducto(producto);
    model.addAttribute("producto", producto);
    return "/producto/modifica";
}





