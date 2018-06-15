package com.library.libraryProject.controller;


import com.library.libraryProject.model.Book;
import com.library.libraryProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {

        bookRepository.save(book);

    }

}
