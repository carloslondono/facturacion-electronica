package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.client;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoClient;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaClient;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ClientService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearClient {
    private FabricaClient fabricaClient;
    private ClientService clientService;

    public ManejadorCrearClient(FabricaClient fabricaClient, ClientService clientService) {
        this.fabricaClient = fabricaClient;
        this.clientService = clientService;
    }

    public Client ejecutar(ComandoClient comandoClient){
        Client client = fabricaClient.crear(comandoClient);
        return clientService.save(client);
    }
}
