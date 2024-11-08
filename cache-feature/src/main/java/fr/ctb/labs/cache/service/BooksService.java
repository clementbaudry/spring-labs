package fr.ctb.labs.cache.service;

import fr.ctb.labs.cache.model.Book;
import fr.ctb.labs.cache.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BooksService {

    private final BookRepository bookRepository;

    @Cacheable("books")
    public Book getBook(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }
}
