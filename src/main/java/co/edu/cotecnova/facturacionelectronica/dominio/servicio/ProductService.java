package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ProductExcepcion;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final static String CODIGO_YA_EXISTE = "El codigo ya existe en la base de datos";
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> findById(int productId){
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            return product;
        }else{
            throw new ProductExcepcion(ID_NO_ENCONTRADO);
        }
    }

    public Product save(Product product){
        Optional<Product> result = productRepository.findByCode(product.getCode());
        if(result.isPresent()){
            throw new ProductExcepcion(CODIGO_YA_EXISTE);
        }else{
            return productRepository.save(product);
        }
    }

    public void delete(int productId){
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(productId);
        }else{
            throw new ProductExcepcion(ID_NO_ENCONTRADO);
        }
    }

    public Product update(Product product, int productId){
        Optional<Product> result = productRepository.findById(productId);
        if(result.isPresent()){
            return productRepository.update(product);
        }else{
            throw new ProductExcepcion(ID_NO_ENCONTRADO);
        }
    }
}
