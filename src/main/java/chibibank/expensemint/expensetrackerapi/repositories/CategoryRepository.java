package chibibank.expensemint.expensetrackerapi.repositories;

import java.util.List;

import chibibank.expensemint.expensetrackerapi.domains.Category;
import chibibank.expensemint.expensetrackerapi.exceptions.EmBadRequestException;
import chibibank.expensemint.expensetrackerapi.exceptions.EmResourceNotFoundException;

public interface CategoryRepository {
    List<Category> findAll(Integer userId) throws EmResourceNotFoundException;
    Category findById(Integer userId, Integer categoryId) throws EmResourceNotFoundException;
    Integer create(Integer userId, String title, String description) throws EmBadRequestException;
    void update(Integer userId, Integer categoryId, Category category) throws EmBadRequestException;
    void removeById(Integer userId, Integer categoryId) throws EmResourceNotFoundException;
}
