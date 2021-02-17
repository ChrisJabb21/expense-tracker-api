package chibibank.expensemint.expensetrackerapi.services;

import chibibank.expensemint.expensetrackerapi.domains.User;
import chibibank.expensemint.expensetrackerapi.exceptions.EmAuthException;

public interface UserService {
    User validateUser(String email, String password) throws EmAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws EmAuthException;
}
