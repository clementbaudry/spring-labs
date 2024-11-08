package fr.ctb.labs.cache.repository;

import fr.ctb.labs.cache.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByIsbn(String isbn);
}
