package br.com.sistemasvendas.app.controller;

import br.com.sistemasvendas.app.model.User;
import br.com.sistemasvendas.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private IUserService service;


    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        System.out.println(user.toString());


        if (user.getId() != null) {
            user.setId(null);
        }

        User result = service.saveUser(user);

        if (result != null) {
            return ResponseEntity.status(200).body(service.saveUser(result));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User result = service.updateUser(user);
        if (result != null) {
            return ResponseEntity.status(200).body(result);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") Integer id) {
        var user = new User();
        user.setId(id);
        User result = service.deleteUser(user);
        if (result != null) {
            return ResponseEntity.status(200).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/user")
    public ResponseEntity<ArrayList<User>> getAllUser() {
        return ResponseEntity.status(200).body(service.getAllUser());
    }

    @GetMapping("/user/search")
    public ResponseEntity<ArrayList<User>> getByUser(@RequestParam(name = "key") String key) {
        if (key != null && key.trim().length() > 0) {
            return ResponseEntity.status(200).body(service.getByUser(key));
        }
        return ResponseEntity.badRequest().build();
    }

}
