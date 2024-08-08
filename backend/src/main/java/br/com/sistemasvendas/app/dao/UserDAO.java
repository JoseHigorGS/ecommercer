package br.com.sistemasvendas.app.dao;

import br.com.sistemasvendas.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
    public ArrayList<User> findByUsernameContaining(String key);
}
