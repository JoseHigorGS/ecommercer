package br.com.sistemasvendas.app.dao;

import br.com.sistemasvendas.app.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {
    public ArrayList<Product> findByNameContaining(String key);
}
