package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.saleproduct;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleProductService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarSaleProduct {
    private SaleProductService saleProductService;

    public ManejadorEliminarSaleProduct(SaleProductService saleProductService) {
        this.saleProductService = saleProductService;
    }

    public void ejecutar(int saleProductId){
        saleProductService.delete(saleProductId);
    }
}
