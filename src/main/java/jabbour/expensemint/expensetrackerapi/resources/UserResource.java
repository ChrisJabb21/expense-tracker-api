package jabbour.expensemint.expensetrackerapi.resources;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    
    //HTTP Request methods
    /**  post method for register user
     * @param userMap key-value data structure with a String key and Object value
     * @return String
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, Object> userMap) {
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        return firstName + ", " + lastName + ", " + email + ", " + password;  
    }


}
