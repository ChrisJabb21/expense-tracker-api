package chibibank.expensemint.expensetrackerapi.repositories;

import chibibank.expensemint.expensetrackerapi.domains.User;
import chibibank.expensemint.expensetrackerapi.exceptions.Em_AuthException;

public interface UserRepository {
    
    Integer create(String firstName, String lastName, String email, String password) throws Em_AuthException;    
    User findByEmailandPassword(String email, String password) throws Em_AuthException;
    Integer getCountbyEmail(String email);
    User findUserById(Integer userId);

}
