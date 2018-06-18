package com.library.libraryProject.repository;

import com.library.libraryProject.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findAll();

    Book save(Book book);

    List<Book> findByLocation_Id(Long locationId);

}
