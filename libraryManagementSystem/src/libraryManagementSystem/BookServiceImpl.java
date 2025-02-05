package libraryManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface {
   public static final String RED = "\u001b[31m";
   public static final String RESET = "\u001b[0m";
   public static final String BLUE = "\u001b[34m";
   public static final String GREEN = "\u001b[32m";
   public static final String CYAN = "\u001b[36m";
   public static final String BLACK = "\u001b[30m";
   Scanner sc;
   Validator validator;
   List<Book> books;

   public BookServiceImpl() {
      this.sc = new Scanner(System.in);
      this.validator = new Validator();
      this.books = new ArrayList();
   }

   public void addBook() {
      String bookid = this.validator.validateId();
      String Author = this.validator.validateAuthorTitle("Author");
      String Title = this.validator.validateAuthorTitle("Title");
      String year = this.validator.validatePublishYear();
      Book book = new Book(bookid, Author, Title, year, "Available");
      this.books.add(book);
      System.out.println("\u001b[32mBook Added Successfully !!!\u001b[0m");
   }

   public void showAllBooks() {
      boolean flag = false;
      System.out.println("\n----------------------------------------------------------------------------------------------");
      System.out.format("\u001b[36m%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS\u001b[0m");
      System.out.println("\n----------------------------------------------------------------------------------------------");

      for(Iterator var2 = this.books.iterator(); var2.hasNext(); flag = true) {
         Book book = (Book)var2.next();
         System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
         System.out.println();
      }

      System.out.println("\n----------------------------------------------------------------------------------------------");
      if (!flag) {
         System.out.println("\u001b[31mThere are no Books in Library\u001b[0m");
      }

   }

   public void showAllAvailableBooks() {
      boolean flag = false;
      System.out.println("\n----------------------------------------------------------------------------------------------");
      System.out.format("\u001b[36m%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS\u001b[0m");
      System.out.println("\n----------------------------------------------------------------------------------------------");
      if (this.books.size() > 0) {
         Iterator var2 = this.books.iterator();

         while(var2.hasNext()) {
            Book book = (Book)var2.next();
            if (book.getStatus() == "Available") {
               System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
               System.out.println();
               flag = true;
            }
         }
      } else {
         System.out.println("\u001b[31mNo Books Available in the library\u001b[0m");
      }

      System.out.println("\n----------------------------------------------------------------------------------------------");
      if (!flag) {
         System.out.println("\u001b[31mThere are no books with status Available\u001b[0m");
      }

   }

   public void borrowBook() {
      String bookid = this.validator.validateId();
      boolean flag = false;
      Iterator var3 = this.books.iterator();

      while(var3.hasNext()) {
         Book book = (Book)var3.next();
         if (book.getId().equals(bookid) && book.getStatus().equals("Available")) {
            flag = true;
            System.out.println("\u001b[32mBook Borrowed Successfully !!!\u001b[0m");
            book.setStatus("Not Available");
            System.out.println("Borrowed Book Details: " + book);
         }
      }

      if (!flag) {
         System.out.println("\u001b[31mThis book is not available to borrow\u001b[0m");
      }

   }

   public void returnBook() {
      boolean flag = false;
      String bookid = this.validator.validateId();
      Iterator var3 = this.books.iterator();

      while(var3.hasNext()) {
         Book book = (Book)var3.next();
         if (book.getId().equals(bookid) && book.getStatus().equals("Not Available")) {
            flag = true;
            System.out.println("\u001b[32mBook Returned Successfully !!!\u001b[0m");
            book.setStatus("Available");
            System.out.println("Returned Book Details: " + book);
         }
      }

      if (!flag) {
         System.out.println("\u001b[31mWe can not return this book\u001b[0m");
      }

   }
}