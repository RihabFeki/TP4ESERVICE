package pl.piomin.microservices.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.piomin.microservices.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	@Query(value = "SELECT b FROM Book b WHERE b.in_cart = TRUE")
	public List<Book> findByIn_cartTrue();
}

