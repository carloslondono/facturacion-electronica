package co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import org.springframework.stereotype.Component;

@Component
public class FabricaSaleProduct {
    public SaleProduct crear(ComandoSaleProduct comandoSaleProduct){
        return new SaleProduct(comandoSaleProduct.getSaleProductId(), comandoSaleProduct.getProductId(), comandoSaleProduct.getSaleId(), comandoSaleProduct.getQuantity(), comandoSaleProduct.getProduct());
    }
}
