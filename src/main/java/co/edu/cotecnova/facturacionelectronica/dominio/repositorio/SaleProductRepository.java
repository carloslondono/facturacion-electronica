package co.edu.cotecnova.facturacionelectronica.dominio.repositorio;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;

import java.util.Optional;

public interface SaleProductRepository {
    SaleProduct save(SaleProduct saleProduct);
    void delete(int saleProductId);
    Optional<SaleProduct> findById(int saleProductId);
}
