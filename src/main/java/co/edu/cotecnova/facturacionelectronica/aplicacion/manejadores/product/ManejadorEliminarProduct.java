package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProduct {
    private ProductService productService;

    public ManejadorEliminarProduct(ProductService productService) {
        this.productService = productService;
    }

    public void ejecutar(int productId){
        productService.delete(productId);
    }
}
