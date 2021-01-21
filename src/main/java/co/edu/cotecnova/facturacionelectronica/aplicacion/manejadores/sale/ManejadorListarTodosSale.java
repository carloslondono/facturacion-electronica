package co.edu.cotecnova.facturacionelectronica.aplicacion.manejadores.sale;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.SaleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTodosSale {
    private SaleService saleService;

    public ManejadorListarTodosSale(SaleService saleService) {
        this.saleService = saleService;
    }

    public List<Sale> ejecutar(){
        return saleService.getAll();
    }
}
