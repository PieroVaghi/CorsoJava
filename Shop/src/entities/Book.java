package entities;

public class Book extends Product
{
	private String author, category;
	private int pages;
	
	public Book() {}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String genre) {
		this.category = genre;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}


	@Override
	public String toString() {
		return super.toString()+ "\nBook [author=" + author + ", category=" + category + ", pages=" + pages + "]";
	}
	
	@Override
	public boolean valid()
	{
		return 
				super.valid()				&&
				pages>0						&&
				notVoid(author)				&&
				notVoid(category)			;
	}
	
	
}