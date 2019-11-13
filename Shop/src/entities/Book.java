package entities;

public class Book extends Product {
	private String author, category;
	private int pages;
	public Book () {}
	/**
	 * @param author
	 * @param category
	 * @param pages
	 */
	public Book(String author, String category, int pages) {
		super();
		this.author = author;
		this.category = category;
		this.pages = pages;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public int getPages() {
		return pages;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		return super.toString() + (author != null ? "author: " + author + ",\n" : "")
				+ (category != null ? "category: " + category + ",\n" : "") + "pages: " + pages;
	}
	
	
	
	

}
