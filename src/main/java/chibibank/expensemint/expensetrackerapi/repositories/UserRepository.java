package chibibank.expensemint.expensetrackerapi.repositories;

import chibibank.expensemint.expensetrackerapi.domains.User;
import chibibank.expensemint.expensetrackerapi.exceptions.EmAuthException;

public interface UserRepository {
    
    Integer create(String firstName, String lastName, String email, String password) throws EmAuthException;    
    User findByEmailAndPassword(String email, String password) throws EmAuthException;
    Integer getCountByEmail(String email);
    User findById(Integer userId);
    
}
