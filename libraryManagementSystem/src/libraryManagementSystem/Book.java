package libraryManagementSystem;

public class Book {
	private String id;
	private String title;
	private String author;
	private String publishYear;
	private String status;
	
	public Book() {
		
	}
	
	public Book(String id,String title,String author,String publishYear,String status) {
		this.id=id;
		this.title=title;
		this.author=author;
		this.publishYear=publishYear;
		this.status=status;
	
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
	      return this.author;
	   }

	   public void setAuthor(String author) {
	      this.author = author;
	   }

	   public String getPublishYear() {
	      return this.publishYear;
	   }

	   public void setPublishYear(String publishYear) {
	      this.publishYear = publishYear;
	   }

	   public String getStatus() {
	      return this.status;
	   }

	   public void setStatus(String status) {
	      this.status = status;
	   }

	   public String toString() {
	      return "Book{id='" + this.id + "', title='" + this.title + "', author='" + this.author + "', publishYear='" + this.publishYear + "', status='" + this.status + "'}";
	   }
	}


