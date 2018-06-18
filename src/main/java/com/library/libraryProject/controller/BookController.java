package com.library.libraryProject.controller;

import com.library.libraryProject.model.Book;
import com.library.libraryProject.repository.BookRepository;
import com.library.libraryProject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/locations/{locationId}/books")
    public List<Book> getAllBooksByLocationId(@PathVariable (value = "locationId") Long locationId) {
        return bookRepository.findByLocation_Id(locationId);
    }

    @PostMapping("/locations/{locationId}/books")
    public Book addBook(@PathVariable (value = "locationId") Long locationId,
                                  @RequestBody Book book) {
        return locationRepository.findById(locationId).map(location -> {
            book.setLocation(location);
            return bookRepository.save(book);
        }).orElseThrow(() -> new NoSuchElementException(" Did not find id " + String.valueOf(locationId)));
    }

    @PutMapping("/locations/{locationId}/books/{bookId}")
    public Book updateBook(@PathVariable (value = "locationId") Long locationId,
                                 @PathVariable (value = "bookId") Long bookId,
                                 @Valid @RequestBody Book bookRequest) {
        if(!locationRepository.existsById(locationId)) {
            throw new NoSuchElementException(" Did not find id " + String.valueOf(locationId));
        }

        return bookRepository.findById(bookId).map(book -> {
            book.setAuthor(bookRequest.getAuthor());
            book.setTitle(bookRequest.getTitle());
            book.setYearPublished(bookRequest.getYearPublished());

            return bookRepository.save(book);
        }).orElseThrow(() -> new NoSuchElementException(" Did not find book id " + String.valueOf(bookId)));
    }

    @DeleteMapping("/locations/{locationId}/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable (value = "locationId") Long locationId,
                                           @PathVariable (value = "bookId") Long bookId) {
        if(!locationRepository.existsById(locationId)) {
            throw new NoSuchElementException(" Did not find book id " + String.valueOf(locationId));
        }

        return bookRepository.findById(bookId).map(book -> {
            bookRepository.delete(book);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NoSuchElementException(" Did not find book id " + String.valueOf(locationId)));
    }


    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }


//    @GetMapping("/getById")
//    public Book getById(Long bookId) {
//
//        return bookRepository.
//
//    }



}
