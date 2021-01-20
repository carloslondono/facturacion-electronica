package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorListarPorIdClient {
    private ClientService clientService;

    public ManejadorListarPorIdClient(ClientService clientService) {
        this.clientService = clientService;
    }

    public Optional<Client> ejecutar(int clientId){
        return clientService.findById(clientId);
    }
}
