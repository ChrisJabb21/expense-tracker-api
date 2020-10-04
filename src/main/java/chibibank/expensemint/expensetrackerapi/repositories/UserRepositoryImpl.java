package chibibank.expensemint.expensetrackerapi.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import chibibank.expensemint.expensetrackerapi.domains.User;
import chibibank.expensemint.expensetrackerapi.exceptions.Em_AuthException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    //Constants for database queries
    private static final String SQL_CREATE = "INSERT EM_USERS(USER_ID,FIRST_NAME,LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('EM_USERS_SEQ'), ?,?,?,?)";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM EM_USERS WHERE EMAIL = ?";
    private static final String SQL_FIND_BY_ID = "SELECT ALL FROM EM_USERS WHERE USER_ID = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    public Integer create(String firstName, String lastName, String email, String password) 
    throws Em_AuthException {
        try{
            //Keyholder used for retreiving auto generated keys returned by insert statements.
            KeyHolder keyHolder = new GeneratedKeyHolder(); 
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, email);
                ps.setString(4, password);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("USER_ID");
        } catch (Exception e) {
            throw new Em_AuthException("Account registration failed due to Invalid details.");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws Em_AuthException {
        return null;
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[] { email }, Integer.class);
    }

    @Override
    public User findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId}, userRowMapper);
    }


    private RowMapper<User> userRowMapper = ((rs, rowNum) ->{
        return new User(
            rs.getInt("USER_ID"),
            rs.getString("FIRST_NAME"),
            rs.getString("LAST_NAME"),
            rs.getString("EMAIL"),
            rs.getString("PASSWORD"));

    });
    
}
