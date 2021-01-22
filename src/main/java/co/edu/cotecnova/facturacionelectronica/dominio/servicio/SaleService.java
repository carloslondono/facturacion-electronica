package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.SaleException;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";
    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAll(){
        return saleRepository.getAll();
    }

    public Optional<Sale> findById(int saleId){
        Optional<Sale> sale = saleRepository.findById(saleId);
        if(sale.isPresent()){
            return sale;
        }else{
            throw new SaleException(ID_NO_ENCONTRADO);
        }
    }

    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }

    public Sale update(Sale sale, int saleId){
        Optional<Sale> result = saleRepository.findById(saleId);
        if(result.isPresent()) {
            return saleRepository.update(sale);
        }else{
            throw new SaleException(ID_NO_ENCONTRADO);
        }
    }

    public void delete(int saleId){
        Optional<Sale> sale = saleRepository.findById(saleId);
        if(sale.isPresent()) {
            saleRepository.delete(saleId);
        }else{
            throw new SaleException(ID_NO_ENCONTRADO);
        }
    }

    public Page<Sale> findAll(Pageable pageable){
        return saleRepository.findAll(pageable);
    }
}
