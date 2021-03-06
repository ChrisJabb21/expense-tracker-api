package chibibank.expensemint.expensetrackerapi.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chibibank.expensemint.expensetrackerapi.domains.User;
import chibibank.expensemint.expensetrackerapi.exceptions.EmAuthException;
import chibibank.expensemint.expensetrackerapi.repositories.UserRepository;

@Service
@Transactional 
public class UserServiceImpl implements UserService {

    // private static final String PASSWORD_PATTERN =
    // "((?=.*[a-z])(?=.*\\d)(?=.[A-Z])(?=.*[@#$%!]).{8,40})";
    private static final String EMAIL_PATTERN = "^(.+)@(.+)$";

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EmAuthException {
        if( email != null ) email = email.toLowerCase();

        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EmAuthException {
        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
        if(email != null) email = email.toLowerCase();
        if(!emailPattern.matcher(email).matches())
            throw new EmAuthException("Invalid email format");
            Integer count = userRepository.getCountByEmail(email);
        

        // Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
        // if(password != null){
        //     if(!passwordPattern.matcher(password).matches())
        //     { throw new EmAuthException("Please enter a eight character password with at least one symbol and uppercase letter"); }
        // }
        // else{
        // throw new EmAuthException("password cannot be empty");
        // }

        if(count > 0)
            throw new EmAuthException("Email already exists");
        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }
    
}
