package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    List<Sale> getAll();
    Optional<Sale> findById(int saleId);
    Sale save(Sale sale);
    Sale update(Sale sale);
    void delete(int saleId);
    Page<Sale> findAll(Pageable pageable);
}
