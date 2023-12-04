package models.dominio.excepciones;

public class cargaIncorrectaException extends RuntimeException{
    public cargaIncorrectaException(String message) {
            super(message);
        }
}
