package com.library.libraryProject.repository;

import com.library.libraryProject.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findAll();

    Book save(Book book);

    Page<Book> findByLocation_Id(Long postId,Pageable pageable);


}
