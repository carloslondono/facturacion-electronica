package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud;

import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Venta;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VentaCrudRepositorio extends PagingAndSortingRepository<Venta, Integer> {
}
