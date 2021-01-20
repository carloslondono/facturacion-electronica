package co.edu.cotecnova.facturacionelectronica.dominio.excepion;

public class ProductExcepcion extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public ProductExcepcion(String mensaje){
        super(mensaje);
    }
}
