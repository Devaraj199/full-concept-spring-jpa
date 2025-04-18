package com.devamasterjpa.repository;

import com.devamasterjpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findByFirstName(String firstName);

    List<Author> findByFirstNameIgnoreCase(String firstName);

    List<Author> findByFirstNameContainingIgnoreCase(String firstName);

    @Modifying
    @Transactional
    @Query("update Author a set a.age =:age where a.id = :id")
    int updateAuthor(int age,int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age =:age")
    int updateAllAuthorsAges(int age);

    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

}
