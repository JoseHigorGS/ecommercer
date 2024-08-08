package br.com.sistemasvendas.app.service;

import br.com.sistemasvendas.app.model.Category;

import java.util.ArrayList;

public interface ICategoryService {
    public Category saveCategory(Category category);
    public Category updateCategory(Category category);
    public Category deleteCategory(Category category);
    public ArrayList<Category> getAllCategory();
    public ArrayList<Category> getByKey(String key);
}
