package com.example.SistemaDeProductosdemo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SistemaDeProductosdemo.Model.Producto;
import com.example.SistemaDeProductosdemo.Repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

public List<Producto> listarProducto(){
    return productoRepository.listarProducto();
}

public Producto agregaProducto(Producto producto){
    return productoRepository.agregaProducto(producto);
}

public String eliminarPorId (Integer id){

    Producto productoEncontrado = productoRepository.eliminarPorId(id);
    if(productoEncontrado != null){
        return "Producto eliminado";
    }else{
        return "Producto no encontrado";
    }

}

public Producto buscarPorId(Integer id){
    return productoRepository.buscarPorId(id);
}
public List<Producto> buscarPorDisponibilidad(Boolean disponible){
    return productoRepository.buscarPorDisponibilidad(disponible);
}
    
}
