package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.product;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProduct {
    private ProductService productService;
    private FabricaProduct fabricaProduct;

    public ManejadorCrearProduct(ProductService productService, FabricaProduct fabricaProduct) {
        this.productService = productService;
        this.fabricaProduct = fabricaProduct;
    }

    public Product ejecutar(ComandoProduct comandoProduct){
        Product product = fabricaProduct.crear(comandoProduct);
        return productService.save(product);
    }
}
