package chibibank.expensemint.expensetrackerapi.services;

import java.util.List;

import chibibank.expensemint.expensetrackerapi.domains.Category;
import chibibank.expensemint.expensetrackerapi.exceptions.EmBadRequestException;
import chibibank.expensemint.expensetrackerapi.exceptions.EmResourceNotFoundException;

public interface CategoryService {
    List<Category> fetchAllCategories(Integer userId);
    Category fetchCategoryById(Integer userId, Integer categoryId) throws EmResourceNotFoundException;
    Category addCategory(Integer userId, String title, String description) throws EmBadRequestException;
    void updateCategory(Integer userId, Integer categoryId, Category category) throws EmBadRequestException;
    void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EmResourceNotFoundException;
}
