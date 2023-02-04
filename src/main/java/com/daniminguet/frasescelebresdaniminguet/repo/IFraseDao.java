package com.daniminguet.frasescelebresdaniminguet.repo;

import com.daniminguet.frasescelebresdaniminguet.models.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;


public interface IFraseDao extends JpaRepository<Frase, Integer> {

    @Query(value = "SELECT f.* FROM frase f INNER JOIN autor a on a.id = f.autor_id INNER JOIN categoria c on c.id = f.categoria_id WHERE f.fechaprogramada = ?1", nativeQuery = true)
    Frase getFraseDelDia(Date fecha);

    @Query(value="SELECT f FROM Frase f WHERE f.categoriaId = ?1")
    List<Frase> getFrasesByCategoria(int id);

    @Query(value="SELECT f FROM Frase f WHERE f.autorId = ?1")
    List<Frase> getFrasesByAutor(int id);

    @Query(value="SELECT * FROM frase f LIMIT 10 OFFSET ?1", nativeQuery = true)
    List<Frase> getFrasesLimit(int offset);

}
