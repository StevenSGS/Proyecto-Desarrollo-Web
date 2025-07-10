
package com.proyecto.service;

import com.proyecto.domain.Producto; 
import java.util.List; 

public interface ProductoService {
    //asigna el metodo para despues implementarlo en el serviceImpl (Read)
    public List<Producto> getProductos(boolean activos);
    
    public Producto getProducto(Producto producto);
    
    public void save(Producto producto);
    
     public void delete(Producto producto);
}
 

