package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoClient;
import co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client.*;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClienteController {
    private ManejadorCrearClient manejadorCrearClient;
    private ManejadorActualizarClient manejadorActualizarClient;
    private ManejadorEliminarClient manejadorEliminarClient;
    private ManejadorListarTodosClient manejadorListarTodosClient;
    private ManejadorListarPorIdClient manejadorListarPorIdClient;
    private ManejadorPaginarClient manejadorPaginarClient;

    public ClienteController(ManejadorCrearClient manejadorCrearClient, ManejadorActualizarClient manejadorActualizarClient, ManejadorEliminarClient manejadorEliminarClient, ManejadorListarTodosClient manejadorListarTodosClient, ManejadorListarPorIdClient manejadorListarPorIdClient, ManejadorPaginarClient manejadorPaginarClient) {
        this.manejadorCrearClient = manejadorCrearClient;
        this.manejadorActualizarClient = manejadorActualizarClient;
        this.manejadorEliminarClient = manejadorEliminarClient;
        this.manejadorListarTodosClient = manejadorListarTodosClient;
        this.manejadorListarPorIdClient = manejadorListarPorIdClient;
        this.manejadorPaginarClient = manejadorPaginarClient;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(manejadorListarTodosClient.ejecutar(), HttpStatus.OK);
    }

    @GetMapping("/paginador")
    public ResponseEntity<Page<Client>> findAll(Pageable pageable){
        return new ResponseEntity<>(manejadorPaginarClient.ejecutar(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findById(@PathVariable("id") int clientID){
        return new ResponseEntity<>(manejadorListarPorIdClient.ejecutar(clientID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody ComandoClient comandoClient){
        comandoClient.setActive(true);
        comandoClient.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(manejadorCrearClient.ejecutar(comandoClient), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody ComandoClient comandoClient, @PathVariable("id") int clientId){
        comandoClient.setClientId(clientId);
        return new ResponseEntity<>(manejadorActualizarClient.ejecutar(comandoClient, clientId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int clientId){
        manejadorEliminarClient.ejecutar(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
