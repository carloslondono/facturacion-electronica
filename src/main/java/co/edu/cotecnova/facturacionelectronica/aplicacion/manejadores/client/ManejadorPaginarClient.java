package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPaginarClient {
    private ClientService clientService;

    public ManejadorPaginarClient(ClientService clientService) {
        this.clientService = clientService;
    }

    public Page<Client> ejecutar(Pageable pageable){
        return clientService.findAll(pageable);
    }
}
