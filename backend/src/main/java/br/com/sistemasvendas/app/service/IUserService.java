package br.com.sistemasvendas.app.service;

import br.com.sistemasvendas.app.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public interface IUserService {
    public User saveUser(User user);
    public User updateUser(User user);
    public User deleteUser(User user);
    public ArrayList<User> getAllUser();
    public ArrayList<User> getByUser(String key);
}
