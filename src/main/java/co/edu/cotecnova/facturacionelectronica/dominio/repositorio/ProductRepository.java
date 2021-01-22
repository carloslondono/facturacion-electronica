package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> findById(int productId);
    Product save(Product product);
    void delete(int productId);
    Product update(Product product);
    Optional<Product> findByCode(int code);
    Page<Product> findAll(Pageable pageable);
}
