package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.SaleProductException;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.SaleProduct;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.SaleProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleProductService {
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";
    private SaleProductRepository saleProductRepository;

    public SaleProductService(SaleProductRepository saleProductRepository) {
        this.saleProductRepository = saleProductRepository;
    }

    public SaleProduct save(SaleProduct saleProduct){
        return saleProductRepository.save(saleProduct);
    }

    public void delete(int saleProductId){
        Optional<SaleProduct> saleProduct = saleProductRepository.findById(saleProductId);
        if(saleProduct.isPresent()){
            saleProductRepository.delete(saleProductId);
        }else{
            throw new SaleProductException(ID_NO_ENCONTRADO);
        }
    }
}
