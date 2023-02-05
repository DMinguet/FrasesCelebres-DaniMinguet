package com.daniminguet.frasescelebresdaniminguet.repo;

import com.daniminguet.frasescelebresdaniminguet.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
    @Query(value="SELECT * FROM usuario ORDER BY usuario.id LIMIT 3 OFFSET ?1", nativeQuery = true)
    List<Usuario> getUsersLimit(int offset);
}
