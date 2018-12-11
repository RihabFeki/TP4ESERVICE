package pl.piomin.microservices.book.api;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.collections.map.SingletonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.book.model.Book;
import pl.piomin.microservices.book.repository.BookRepository;

@RestController
public class Api {
	
	@Autowired
	private BookRepository bookRepository;
	
	protected Logger logger = Logger.getLogger(Api.class.getName());

	
	public Api() {
		//init
	}
	
	@RequestMapping(path="/books", method=RequestMethod.GET)
	public List<Book> list_all_books () {
		logger.info("list_all_books");
		return this.bookRepository.findAll();
	}
	
	@RequestMapping(path="/books", method=RequestMethod.POST)
	public Book create_a_book (@RequestBody Book book) {
		logger.info("create_a_book");
		return this.bookRepository.save(book);
	}
	
	@RequestMapping(path="/books/{id}", method=RequestMethod.GET)
	public Book read_a_book (@PathVariable("id") long id) {
		logger.info("read_a_book");
		return this.bookRepository.findOne(id);
	}
	
	@RequestMapping(path="/books/{id}", method=RequestMethod.PUT)
	public Book update_a_book (@PathVariable("id") long id, @RequestBody Book book) {
		logger.info("update_a_book");
		return this.bookRepository.save(book);
	}
	
	@RequestMapping(path="/books/{id}", method=RequestMethod.DELETE)
	public SingletonMap delete_a_book (@PathVariable("id") long id) {
		logger.info("delete_a_book");
		this.bookRepository.delete(id);
		return new SingletonMap("message","Book successfully deleted");
	}
	
	@RequestMapping(path="/cart", method=RequestMethod.GET)
	public List<Book> books_in_cart () {
		logger.info("books_in_cart");
		return this.bookRepository.findByIn_cartTrue();
	}
	
	@RequestMapping(path="/cart/{id}", method=RequestMethod.PUT)
	public Book add_to_cart (@PathVariable("id") long id) {
		logger.info("add_to_cart");
		Book book = this.bookRepository.findOne(id);
		book.setIn_cart(true);
		return this.bookRepository.save(book);
	}
	
	@RequestMapping(path="/cart_d/{id}", method=RequestMethod.PUT)
	public Book delete_from_cart(@PathVariable("id") long id) {
		logger.info("delete_from_cart");
		Book book = this.bookRepository.findOne(id);
		book.setIn_cart(false);
		this.bookRepository.save(book);
		return this.bookRepository.findOne(id);
	}
	
	@RequestMapping(path="/buy", method=RequestMethod.GET)
	public Double get_cart_price() {
		logger.info("get_cart_price");
		double price = 0;
		List<Book> booksInCart = this.bookRepository.findByIn_cartTrue();
		for (Book book : booksInCart) {
			price += book.getPrice();
		}
		return price;
	}
	
	@RequestMapping(path="/buy/{id}", method=RequestMethod.GET)
	public Double get_book_price(@PathVariable("id") long id) {
		logger.info("get_book_price");
		return this.bookRepository.findOne(id).getPrice();
	}
	
}
