package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.databuilder.ProductTestDataBuilder;
import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ProductExcepcion;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Product;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private static final int PRODUCT_ID = 1;
    private static final int CODE = 9090;
    private static final String NAME = "producto";
    private static final double PRICE = 2500;
    private static final boolean ACTIVE = true;
    private static final LocalDateTime CREATION_DATE = LocalDateTime.of(2021, 01,22,21,05);

    private List<Product> productList = new ArrayList<>();
    private Product product = new ProductTestDataBuilder().build();

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @BeforeEach
    public void init(){
        productList.add(product);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTest() {
        //ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(productRepository.getAll()).thenReturn(productList);
        //ProductService productService = new ProductService(productRepository);

        List<Product> productListLocal = productService.getAll();

        assertEquals(PRODUCT_ID, productListLocal.get(0).getProductId());
        assertEquals(CODE, productListLocal.get(0).getCode());
        assertEquals(NAME, productListLocal.get(0).getName());
        assertEquals(PRICE, productListLocal.get(0).getPrice());
        assertEquals(ACTIVE, productListLocal.get(0).isActive());
        assertEquals(CREATION_DATE, productListLocal.get(0).getCreationDate());
    }

    @Test
    void findByIdTest() {
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(java.util.Optional.ofNullable(product));

        Optional<Product> productLocal = productService.findById(PRODUCT_ID);

        assertEquals(PRODUCT_ID, productLocal.get().getProductId());
        assertEquals(CODE, productLocal.get().getCode());
        assertEquals(NAME, productLocal.get().getName());
        assertEquals(PRICE, productLocal.get().getPrice());
        assertEquals(ACTIVE, productLocal.get().isActive());
        assertEquals(CREATION_DATE, productLocal.get().getCreationDate());
    }

    @Test
    void findByIdExceptionTest() {
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.empty());
        assertThrows(ProductExcepcion.class, () -> productService.findById(PRODUCT_ID));
    }

    @Test
    void saveTest() {
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product productLocal = productService.save(product);
        assertEquals(PRODUCT_ID, productLocal.getProductId());
        assertEquals(CODE, productLocal.getCode());
        assertEquals(NAME, productLocal.getName());
        assertEquals(PRICE, productLocal.getPrice());
        assertEquals(ACTIVE, productLocal.isActive());
        assertEquals(CREATION_DATE, productLocal.getCreationDate());
    }
}