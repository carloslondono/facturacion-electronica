package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Venta;
import org.springframework.data.repository.CrudRepository;

public interface VentaCrudRepositorio extends CrudRepository<Venta, Integer> {
}
