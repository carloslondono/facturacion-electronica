package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPaginadorSale {
    private SaleService saleService;

    public ManejadorPaginadorSale(SaleService saleService) {
        this.saleService = saleService;
    }

    public Page<Sale> ejecutar(Pageable pageable){
        return saleService.findAll(pageable);
    }
}
