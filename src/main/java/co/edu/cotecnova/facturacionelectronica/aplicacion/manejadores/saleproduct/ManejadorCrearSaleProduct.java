package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.saleproduct;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSaleProduct;
import co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica.FabricaSaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleProductService;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSaleProduct {
    private SaleProductService saleProductService;
    private FabricaSaleProduct fabricaSaleProduct;

    public ManejadorCrearSaleProduct(SaleProductService saleProductService, FabricaSaleProduct fabricaSaleProduct) {
        this.saleProductService = saleProductService;
        this.fabricaSaleProduct = fabricaSaleProduct;
    }

    public SaleProduct ejecutar(ComandoSaleProduct comandoSaleProduct){
        SaleProduct saleProduct = fabricaSaleProduct.crear(comandoSaleProduct);
        return saleProductService.save(saleProduct);
    }
}
