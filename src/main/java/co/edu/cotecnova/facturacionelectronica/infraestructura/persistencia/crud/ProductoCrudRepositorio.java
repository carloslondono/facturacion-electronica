package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepositorio extends PagingAndSortingRepository<Producto, Integer> {
    Optional<Producto> findByCodigo(int code);

    //@Query(value = "SELECT * FROM productos WHERE estado = 1", nativeQuery = true)
    List<Producto> findByEstadoTrue();
}
