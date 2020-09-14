package chibibank.expensemint.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Em_AuthException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public Em_AuthException(String message) {
        super(message);
    }
    
}
