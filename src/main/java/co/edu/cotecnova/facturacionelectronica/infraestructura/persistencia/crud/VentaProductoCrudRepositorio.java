package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.VentaProducto;
import org.springframework.data.repository.CrudRepository;

public interface VentaProductoCrudRepositorio extends CrudRepository<VentaProducto, Integer> {
}
