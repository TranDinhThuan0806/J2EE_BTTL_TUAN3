package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private long nextId = 1L;

    public BookService() {
        books.add(new Book(nextId++, "Spring Boot", "Huy Cuong"));
        books.add(new Book(nextId++, "Java Web", "Anh Tuan"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        getBookById(updatedBook.getId()).ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId() == id);
    }
}
