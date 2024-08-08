package br.com.sistemasvendas.app.dto;

import br.com.sistemasvendas.app.dao.UserDAO;
import br.com.sistemasvendas.app.model.User;
import br.com.sistemasvendas.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDAO dao;

    @Override
    public User saveUser(User user) {
        try {
            if (user.getUsername() != null && user.getUsername().trim().length() > 0) {
                dao.save(user);
                return user;
            }

        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG USER:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        try {
            if (user.getId() != null && user.getUsername() != null && user.getUsername().trim().length() > 0) {
                dao.save(user);
                return user;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG USER:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }

    @Override
    public User deleteUser(User user) {
        try {
            if (user.getId() != null) {
                dao.delete(user);
                return user;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG USER:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }

    @Override
    public ArrayList<User> getAllUser() {
        return (ArrayList<User>) dao.findAll();
    }

    @Override
    public ArrayList<User> getByUser(String key) {
        try {
            if (key != null && key.trim().length() > 0) {
                return dao.findByUsernameContaining(key);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG USER:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }
}
