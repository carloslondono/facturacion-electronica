package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProduct {
    private FabricaProduct fabricaProduct;
    private ProductService productService;

    public ManejadorActualizarProduct(FabricaProduct fabricaProduct, ProductService productService) {
        this.fabricaProduct = fabricaProduct;
        this.productService = productService;
    }

    public Product ejecutar(ComandoProduct comandoProduct, int productId){
        Product product = fabricaProduct.crear(comandoProduct);
        return productService.update(product, productId);
    }
}
