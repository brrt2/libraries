package com.library.libraryProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "location",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<Book> booksAvailable = new HashSet<>(0);

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Location() {
    }

    public void addBook(Book book) {
        booksAvailable.add(book);
    }

    public void removeComment(Book book) {
        booksAvailable.remove(book);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooksAvailable() {
        return booksAvailable;
    }

    public void setBooksAvailable(Set<Book> booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(name, location.name) &&
                Objects.equals(address, location.address) &&
                Objects.equals(booksAvailable, location.booksAvailable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, booksAvailable);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", booksAvailable=" + booksAvailable +
                '}';
    }
}
