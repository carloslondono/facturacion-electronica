package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPaginarProduct {
    private ProductService productService;

    public ManejadorPaginarProduct(ProductService productService) {
        this.productService = productService;
    }

    public Page<Product> ejecutar(Pageable pageable){
        return productService.findAll(pageable);
    }
}
