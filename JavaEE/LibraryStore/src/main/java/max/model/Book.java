package max.model;

import java.math.BigDecimal;

public class Book {

	private Long id;
	private String author;
	private String title;
	private String category;
	private BigDecimal price;
	private String image;
	
	public Book() {	}

	public Book(Long id, String author, String title, String category,
			BigDecimal price, String image) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title
				+ ", category=" + category + ", price=" + price + ", image="
				+ image + "]";
	}
	
}
