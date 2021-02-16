package chibibank.expensemint.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public EmResourceNotFoundException(String message) {
        super(message);
    }
}
