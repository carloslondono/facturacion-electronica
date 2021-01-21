package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarSale {
    private SaleService saleService;

    public ManejadorEliminarSale(SaleService saleService) {
        this.saleService = saleService;
    }

    public void ejecutar(int saleId){
        saleService.delete(saleId);
    }
}
