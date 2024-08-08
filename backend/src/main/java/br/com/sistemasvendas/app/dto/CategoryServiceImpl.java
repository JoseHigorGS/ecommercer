package br.com.sistemasvendas.app.dto;

import br.com.sistemasvendas.app.dao.CategoryDAO;
import br.com.sistemasvendas.app.model.Category;
import br.com.sistemasvendas.app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryDAO dao;

    @Override
    public Category saveCategory(Category category) {

        try {
            if (category.getName() != null && category.getName().trim().length() > 0) {
                dao.save(category);
                return category;
            }

        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG CATEGORY = " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("DEBUG - Exception CATEGORY = " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        try {
            if (category.getId() != null && category.getName().trim().length() > 0) {
                dao.save(category);
                return category;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG CATEGORY = " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("DEBUG - Exception CATEGORY = " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Category deleteCategory(Category category) {
        try {
            if (category.getId() != null) {
                dao.delete(category);
                return category;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG CATEGORY = " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("DEBUG - Exception CATEGORY = " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Category> getAllCategory() {
        return (ArrayList<Category>) dao.findAll();
    }

    @Override
    public ArrayList<Category> getByKey(String key) {

        try {
            if (key != null) {
                return dao.findByNameContaining(key);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG CATEGORY = " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("DEBUG - Exception CATEORY= " + ex.getMessage());
        }

        return null;
    }
}
