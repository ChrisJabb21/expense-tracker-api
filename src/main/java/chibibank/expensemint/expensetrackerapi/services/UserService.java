package chibibank.expensemint.expensetrackerapi.services;

import chibibank.expensemint.expensetrackerapi.domains.User;
import chibibank.expensemint.expensetrackerapi.exceptions.Em_AuthException;

/** Interface for UserService implementation
 * Service layer for encapsulating business logic, cementing data access
 */
public interface UserService {
    User validateUser(String email, String password) throws Em_AuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws Em_AuthException;
}
