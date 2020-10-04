package chibibank.expensemint.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/***
 * Exception to be thrown that returns a HTTP response status code of 401 of unauthorized when an authenication error happens for
 * User Registration and validation.
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Em_AuthException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    /***
     * Method for constructing a runtime exception
     * @param message String of Runtime exception that returns details on exception.
     */
    public Em_AuthException(String message) {
        super(message);
    }
    
}
