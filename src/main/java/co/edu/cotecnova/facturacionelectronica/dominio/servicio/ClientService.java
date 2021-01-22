package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ClientException;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final static String DOCUMENTO_YA_EXISTE = "El codigo ya existe en la base de datos";
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> findById(int clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            return client;
        }else{
            throw new ClientException(ID_NO_ENCONTRADO);
        }
    }

    public Client save(Client client){
        Optional<Client> result = clientRepository.findByDocument(client.getDocument());
        if(result.isPresent()){
            throw new ClientException(DOCUMENTO_YA_EXISTE);
        }else{
            return clientRepository.save(client);
        }
    }

    public void delete(int clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            clientRepository.delete(clientId);
        }else{
            throw new ClientException(ID_NO_ENCONTRADO);
        }
    }

    public Client update(Client client, int clientId){
        Optional<Client> result = clientRepository.findById(clientId);
        if(result.isPresent()){
            return clientRepository.update(client);
        }else{
            throw new ClientException(ID_NO_ENCONTRADO);
        }
    }

    public Page<Client> findAll(Pageable pageable){
        return clientRepository.findAll(pageable);
    }
}
