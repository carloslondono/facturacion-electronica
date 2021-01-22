package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product.*;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductoController {
    private ManejadorCrearProduct manejadorCrearProduct;
    private ManejadorActualizarProduct manejadorActualizarProduct;
    private ManejadorEliminarProduct manejadorEliminarProduct;
    private ManejadorListarTodosProduct manejadorListarTodosProduct;
    private ManejadorListarPorIdProduct manejadorListarPorIdProduct;
    private ManejadorPaginarProduct manejadorPaginarProduct;

    public ProductoController(ManejadorCrearProduct manejadorCrearProduct, ManejadorActualizarProduct manejadorActualizarProduct, ManejadorEliminarProduct manejadorEliminarProduct, ManejadorListarTodosProduct manejadorListarTodosProduct, ManejadorListarPorIdProduct manejadorListarPorIdProduct, ManejadorPaginarProduct manejadorPaginarProduct) {
        this.manejadorCrearProduct = manejadorCrearProduct;
        this.manejadorActualizarProduct = manejadorActualizarProduct;
        this.manejadorEliminarProduct = manejadorEliminarProduct;
        this.manejadorListarTodosProduct = manejadorListarTodosProduct;
        this.manejadorListarPorIdProduct = manejadorListarPorIdProduct;
        this.manejadorPaginarProduct = manejadorPaginarProduct;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(manejadorListarTodosProduct.ejecutar(), HttpStatus.OK);
    }

    @GetMapping("/paginador")
    public ResponseEntity<Page<Product>> findAll(Pageable pageable){
        return new ResponseEntity<>(manejadorPaginarProduct.ejecutar(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") int productId){
        return new ResponseEntity<>(manejadorListarPorIdProduct.ejecutar(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ComandoProduct comandoProduct){
        comandoProduct.setActive(true);
        comandoProduct.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(manejadorCrearProduct.ejecutar(comandoProduct), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ComandoProduct comandoProduct,@PathVariable("id") int productId){
        comandoProduct.setProductId(productId);
        return new ResponseEntity<>(manejadorActualizarProduct.ejecutar(comandoProduct, productId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int productId){
        manejadorEliminarProduct.ejecutar(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
