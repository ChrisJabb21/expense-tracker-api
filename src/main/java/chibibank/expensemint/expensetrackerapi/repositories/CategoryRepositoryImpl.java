package chibibank.expensemint.expensetrackerapi.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import chibibank.expensemint.expensetrackerapi.domains.Category;
import chibibank.expensemint.expensetrackerapi.exceptions.EmBadRequestException;
import chibibank.expensemint.expensetrackerapi.exceptions.EmResourceNotFoundException;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String SQL_FIND_ALL = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, " +
    "COALESCE(SUM(T.AMOUNT), 0) TOTAL_EXPENSE " +
    "FROM EM_TRANSACTIONS T RIGHT OUTER JOIN EM_CATEGORIES C ON C.CATEGORY_ID = T.CATEGORY_ID " +
    "WHERE C.USER_ID = ? GROUP BY C.CATEGORY_ID";  
    private static final String SQL_FIND_BY_ID = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, " +
    "COALESCE(SUM(T.AMOUNT), 0) TOTAL_EXPENSE " +
    "FROM EM_TRANSACTIONS T RIGHT OUTER JOIN EM_CATEGORIES C ON C.CATEGORY_ID = T.CATEGORY_ID " +
    "WHERE C.USER_ID = ? AND C.CATEGORY_ID = ? GROUP BY C.CATEGORY_ID";  
    private static final String SQL_CREATE = "INSERT INTO EM_CATEGORIES (CATEGORY_ID, USER_ID, TITLE, DESCRIPTION) VALUES(NEXTVAL('EM_CATEGORIES_SEQ'), ? , ? , ?)";
    private static final String SQL_UPDATE = "UPDATE EM_CATEGORIES SET TITLE = ?, DESCRIPTION = ? " +
        "WHERE USER_ID = ? AND CATEGORY_ID = ? ";

    @Autowired
    JdbcTemplate jdbcTemplate;    

    @Override
    public List<Category> findAll(Integer userId) throws EmResourceNotFoundException {
        return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{userId}, categoryRowMapper);
    }

    @Override
    public Category findById(Integer userId, Integer categoryId) throws EmResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId, categoryId}, categoryRowMapper);
        } catch (Exception e) {
            throw new EmResourceNotFoundException("Category not found");
        }
    }

    @Override
    public Integer create(Integer userId, String title, String description) throws EmBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.setString(2, title);
                ps.setString(3, description);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("CATEGORY_ID");
        } catch (Exception e) {
            throw new EmBadRequestException("Invalid request");
        }
    }

    @Override
    public void update(Integer userId, Integer categoryId, Category category) throws EmBadRequestException {
        try {
            jdbcTemplate.update(SQL_UPDATE, 
            new Object[]{category.getTitle(), 
                category.getDescription(),
                userId, categoryId});
        } catch (Exception e) {
            throw new EmBadRequestException("Invalid request");
        }
    }

    @Override
    public void removeById(Integer userId, Integer categoryId) {
        // TODO Auto-generated method stub

    }



    private RowMapper<Category> categoryRowMapper = ((rs, rowNum) -> {
        return new Category(rs.getInt("CATEGORY_ID"),
        rs.getInt("USER_ID"),
        rs.getString("TITLE"),
        rs.getString("DESCRIPTION"),
        rs.getDouble("TOTAL_EXPENSE"));
    });
}
