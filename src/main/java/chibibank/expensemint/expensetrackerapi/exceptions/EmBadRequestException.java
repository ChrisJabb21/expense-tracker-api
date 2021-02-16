package chibibank.expensemint.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmBadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmBadRequestException(String message) {
        super(message);
    }
}
