package com.example.SistemaDeProductosdemo.Repository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.SistemaDeProductosdemo.Model.Producto;

@Repository
public class ProductoRepository {

    private List<Producto> listaProductos = new ArrayList<>();

    public List<Producto> listarProducto(){
        return listaProductos;
    }

    public Producto agregaProducto(Producto producto){
        listaProductos.add(producto);
        return producto;
    }
    

    public Producto eliminarPorId(Integer id){

        Producto productoEncontrado = null;

        for(Producto producto: listaProductos){
            if(producto.getId().equals(id)){
                productoEncontrado = producto;
                break;
            }
        }
        if(productoEncontrado != null){
            listaProductos.remove(productoEncontrado);
        }
        return productoEncontrado;

    }

   public List<Producto> buscarPorDisponibilidad(Boolean disponible){
    List<Producto> resultado = new ArrayList<>();
    for(Producto producto : listaProductos){
        if(producto.getDisponible().equals(disponible)){
            resultado.add(producto);
        }
    }
    return resultado;
}

    public Producto buscarPorId(Integer id){
        for(Producto producto: listaProductos){
            if(producto.getId().equals(id)){
                return producto;
            }
        }
        return null;
    }

    public Producto actualizarPrecio(Integer id,Double precio){
    for(Producto producto : listaProductos){
        if(producto.getId().equals(id)){
            producto.setPrecio(precio);
            return producto;
        }
    }
    return null;
}



    
}
