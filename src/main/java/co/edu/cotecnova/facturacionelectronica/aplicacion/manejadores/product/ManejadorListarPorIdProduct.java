package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorListarPorIdProduct {
    private ProductService productService;

    public ManejadorListarPorIdProduct(ProductService productService) {
        this.productService = productService;
    }

    public Optional<Product> ejecutar(int productId){
        return productService.findById(productId);
    }
}
