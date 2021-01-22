package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepositorio extends PagingAndSortingRepository<Cliente, Integer> {
    Optional<Cliente> findByDocumento(String documento);
    List<Cliente> findByEstadoTrue();
}
