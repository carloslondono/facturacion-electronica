package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> findById(int productId);
    Product save(Product product);
    void delete(int productId);
    Product update(Product product);
    Optional<Product> findByCode(int code);
}
