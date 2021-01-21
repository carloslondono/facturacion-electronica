package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSale;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaSale;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSale {
    private SaleService saleService;
    private FabricaSale fabricaSale;

    public ManejadorCrearSale(SaleService saleService, FabricaSale fabricaSale) {
        this.saleService = saleService;
        this.fabricaSale = fabricaSale;
    }

    public Sale ejecutar(ComandoSale comandoSale){
        Sale sale = fabricaSale.crear(comandoSale);
        return saleService.save(sale);
    }
}
