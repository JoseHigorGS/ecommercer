package br.com.sistemasvendas.app.dao;

import br.com.sistemasvendas.app.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryDAO extends CrudRepository<Category,Integer> {
        public ArrayList<Category> findByNameContaining(String key);
}
