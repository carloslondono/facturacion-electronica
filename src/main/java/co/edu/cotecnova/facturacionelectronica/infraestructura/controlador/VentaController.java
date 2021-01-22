package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSale;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale.*;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class VentaController {
    private ManejadorCrearSale manejadorCrearSale;
    private ManejadorActualizarSale manejadorActualizarSale;
    private ManejadorEliminarSale manejadorEliminarSale;
    private ManejadorListarTodosSale manejadorListarTodosSale;
    private ManejadorListarPorIdSale manejadorListarPorIdSale;
    private ManejadorPaginadorSale manejadorPaginadorSale;

    public VentaController(ManejadorCrearSale manejadorCrearSale, ManejadorActualizarSale manejadorActualizarSale, ManejadorEliminarSale manejadorEliminarSale, ManejadorListarTodosSale manejadorListarTodosSale, ManejadorListarPorIdSale manejadorListarPorIdSale, ManejadorPaginadorSale manejadorPaginadorSale) {
        this.manejadorCrearSale = manejadorCrearSale;
        this.manejadorActualizarSale = manejadorActualizarSale;
        this.manejadorEliminarSale = manejadorEliminarSale;
        this.manejadorListarTodosSale = manejadorListarTodosSale;
        this.manejadorListarPorIdSale = manejadorListarPorIdSale;
        this.manejadorPaginadorSale = manejadorPaginadorSale;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAll(){
        return new ResponseEntity<>(manejadorListarTodosSale.ejecutar(), HttpStatus.OK);
    }

    @GetMapping("/paginador")
    public ResponseEntity<Page<Sale>> findAll(Pageable pageable){
        return new ResponseEntity<>(manejadorPaginadorSale.ejecutar(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Sale>> findById(@PathVariable("id") int saleId){
        return new ResponseEntity<>(manejadorListarPorIdSale.ejecutar(saleId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody ComandoSale comandoSale){
        comandoSale.setActive(true);
        comandoSale.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(manejadorCrearSale.ejecutar(comandoSale), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@RequestBody ComandoSale comandoSale, @PathVariable("id") int saleId){
        comandoSale.setSaleId(saleId);
        return new ResponseEntity<>(manejadorActualizarSale.ejecutar(comandoSale, saleId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int saleId){
        manejadorEliminarSale.ejecutar(saleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
