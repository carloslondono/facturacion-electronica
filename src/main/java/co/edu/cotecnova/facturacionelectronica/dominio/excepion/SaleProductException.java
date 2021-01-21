package co.edu.cotecnova.facturacionelectronica.dominio.excepion;

public class SaleProductException extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public SaleProductException(String mensaje){
        super(mensaje);
    }
}
