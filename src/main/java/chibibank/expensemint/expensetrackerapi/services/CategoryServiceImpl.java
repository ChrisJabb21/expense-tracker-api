package chibibank.expensemint.expensetrackerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chibibank.expensemint.expensetrackerapi.domains.Category;
import chibibank.expensemint.expensetrackerapi.exceptions.EmBadRequestException;
import chibibank.expensemint.expensetrackerapi.exceptions.EmResourceNotFoundException;
import chibibank.expensemint.expensetrackerapi.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EmBadRequestException {
        int categoryId = categoryRepository.create(userId, title, description); 
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public List<Category> fetchAllCategories(Integer userId) {
        return categoryRepository.findAll(userId);
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EmResourceNotFoundException {
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EmBadRequestException {
        categoryRepository.update(userId, categoryId, category);
    }

    @Override
    public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId)
            throws EmResourceNotFoundException {
            this.fetchCategoryById(userId, categoryId);
            categoryRepository.removeById(userId, categoryId);
            
    }
    
}