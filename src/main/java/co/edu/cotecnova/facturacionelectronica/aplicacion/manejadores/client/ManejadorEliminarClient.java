package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarClient {
    private ClientService clientService;

    public ManejadorEliminarClient(ClientService clientService) {
        this.clientService = clientService;
    }

    public void ejecutar(int clientId){
        clientService.delete(clientId);
    }
}
