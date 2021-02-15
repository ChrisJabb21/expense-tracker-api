package chibibank.expensemint.expensetrackerapi.repositories;

import chibibank.expensemint.expensetrackerapi.domains.User;
import chibibank.expensemint.expensetrackerapi.exceptions.Em_AuthException;

public interface UserRepository {
    
    Integer create(String firstName, String lastName, String email, String password) throws Em_AuthException;    
    User findByEmailAndPassword(String email, String password) throws Em_AuthException;
    Integer getCountByEmail(String email); //Check if an email already exists 
    User findById(Integer userId);
    
}
