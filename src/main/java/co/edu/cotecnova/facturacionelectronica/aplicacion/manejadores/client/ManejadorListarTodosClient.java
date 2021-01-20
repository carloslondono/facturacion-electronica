package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTodosClient {
    private ClientService clientService;

    public ManejadorListarTodosClient(ClientService clientService) {
        this.clientService = clientService;
    }

    public List<Client> ejecutar(){
        return clientService.getAll();
    }
}
