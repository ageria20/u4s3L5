package exception;

public class NotFounException extends RuntimeException{

    public NotFounException(String id){
        super("Il record con id" + id + "non è stato trovato");
    }
}
