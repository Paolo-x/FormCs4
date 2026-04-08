package com.example.SistemaDeProductosdemo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SistemaDeProductosdemo.Model.Producto;
import com.example.SistemaDeProductosdemo.Service.ProductoService;


@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>>listaProductos(){
        List<Producto> producto = productoService.listarProducto();
        return ResponseEntity.ok(producto);
    }


    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto){
        Producto productoNuevo = productoService.agregaProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id){
        String resultado = productoService.eliminarPorId(id);
        if(resultado.equals("Producto eliminado")){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id) {
        Producto producto = productoService.buscarPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/disponibilidad/{disponible}")
    public ResponseEntity<List<Producto>> buscarPorDisponibilidad(@PathVariable Boolean disponible) {
        List<Producto> productos = productoService.buscarPorDisponibilidad(disponible);
        return ResponseEntity.ok(productos);
    }

    @PutMapping("/{id}/precio/{nuevoPrecio}")
public ResponseEntity<Producto> actualizarPrecio(@PathVariable Integer id,
                                                      @PathVariable Double nuevoPrecio){
    Producto productoActualizado = productoService.actualiarPrecio(id, nuevoPrecio);

    if(productoActualizado != null){
        return ResponseEntity.ok(productoActualizado);
    }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
    

}
