package com.daniminguet.frasescelebresdaniminguet.controllers;

import com.daniminguet.frasescelebresdaniminguet.HashGenerator;
import com.daniminguet.frasescelebresdaniminguet.models.Usuario;
import com.daniminguet.frasescelebresdaniminguet.repo.IUsuarioDao;
import com.daniminguet.frasescelebresdaniminguet.util.Log;
import org.apache.catalina.filters.SetCharacterEncodingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private IUsuarioDao repo;

    @GetMapping("/all")
    public List<Usuario> getUsers() {
        return repo.findAll();
    }

    @GetMapping("/all/{offset}")
    public List<Usuario> getUsersLimit(@PathVariable("offset") int offset) {
        return repo.getUsersLimit(offset);
    }

    @GetMapping(value = "/{id}")
    public Optional<Usuario> getUser(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody Usuario usuario) {
        for (Usuario user : repo.findAll()) {
            if (user.getNombre().equals(usuario.getNombre())) {
                return false;
            }
        }

        String contrasenya = null;
        try {
            contrasenya = HashGenerator.getSHAString(usuario.getContrasenya());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        usuario.setContrasenya(contrasenya);
        usuario.setAdmin((byte) 0);

        try {
            Log.i("Nuevo Usuario: ", usuario.toString());
            repo.save(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody Usuario usuario) {
        try {
            Log.i("Update Usuario: ", usuario.toString());
            repo.save(usuario);
            return true;
        } catch (Exception e){
            Log.e("Update Usuario", e.getMessage());
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        try {
            repo.deleteById(id);
            System.out.println("Usuario eliminado correctamente");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Usuario user) {
        try {
            for (Usuario usuario: getUsers()) {
                if (usuario.getNombre().equals(user.getNombre()) && HashGenerator.getSHAString(user.getContrasenya()).equals(usuario.getContrasenya())) {
                    return true;
                }
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
