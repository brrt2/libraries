package com.library.libraryProject.controller;

import com.library.libraryProject.model.Book;
import com.library.libraryProject.repository.BookRepository;
import com.library.libraryProject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/locations/{locationId}/books")
    public Page<Book> getAllBooksByLocationId(@PathVariable (value = "locationId") Long locationId,
                                             Pageable pageable) {
        return bookRepository.findByLocation_Id(locationId, pageable);
    }


    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {

        bookRepository.save(book);

    }

}
