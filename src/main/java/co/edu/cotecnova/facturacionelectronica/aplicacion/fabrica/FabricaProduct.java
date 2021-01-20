package co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import org.springframework.stereotype.Component;

@Component
public class FabricaProduct {
    public Product crear(ComandoProduct comandoProduct){
        return new Product(comandoProduct.getProductId(), comandoProduct.getCode(), comandoProduct.getName(), comandoProduct.getPrice(), comandoProduct.isActive(),comandoProduct.getCreationDate());
    }
}
