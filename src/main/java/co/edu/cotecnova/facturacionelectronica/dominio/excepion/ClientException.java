package co.edu.cotecnova.facturacionelectronica.dominio.excepion;

public class ClientException extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public ClientException(String mensaje){
        super(mensaje);
    }
}
