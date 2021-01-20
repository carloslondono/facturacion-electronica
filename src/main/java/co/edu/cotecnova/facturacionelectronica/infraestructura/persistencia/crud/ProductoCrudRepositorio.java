package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductoCrudRepositorio extends CrudRepository<Producto, Integer> {
    Optional<Producto> findByCodigo(int code);
}
