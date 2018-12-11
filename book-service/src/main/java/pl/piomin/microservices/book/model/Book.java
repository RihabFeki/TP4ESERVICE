package pl.piomin.microservices.book.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6893016508187480071L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String genre;
	private String description;
	private String author;
	private String publisher;
	private String pages;
	private String image_url;
	private String buy_url;
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	private boolean in_cart;
	private double price;
	
	public Book() {
	}

	public Book(String title, String genre, String description, String author, String publisher, String pages,
			String image_url, String buy_url, Date create_date, boolean in_cart, double price) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.author = author;
		this.publisher = publisher;
		this.pages = pages;
		this.image_url = image_url;
		this.buy_url = buy_url;
		this.create_date = create_date;
		this.in_cart = in_cart;
		this.price = price;
	}

	@PrePersist
	protected void onCreate() {
		if (this.create_date == null) {
			this.create_date = new Date();
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getBuy_url() {
		return buy_url;
	}

	public void setBuy_url(String buy_url) {
		this.buy_url = buy_url;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public boolean isIn_cart() {
		return in_cart;
	}

	public void setIn_cart(boolean in_cart) {
		this.in_cart = in_cart;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
		
}
