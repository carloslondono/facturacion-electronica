package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;


import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> findById(int clientId);
    Client save(Client client);
    void delete(int clientId);
    Client update(Client client);
    Optional<Client> findByDocument(String document);
    Page<Client> findAll(Pageable pageable);
}
