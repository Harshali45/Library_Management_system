package libraryManagementSystem;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
public static final String RED = "\u001b[31m";
public static final String RESET = "\u001b[0m";
private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
private static Pattern AuthorTitle_Pattern = Pattern.compile("^[a-zA-Z ]+$");
private static Pattern PublishYear_Pattern = Pattern.compile("^\\d{4}$");
Scanner sc;

public Validator() {
   this.sc = new Scanner(System.in);
}

public String validateId() {
   while(true) {
      System.out.println("Enter Book ID ");
      String bookid = this.sc.nextLine();
      if (ID_PATTERN.matcher(bookid).matches()) {
         return bookid;
      }

      System.out.println("\u001b[31mSORRY ! PLEASE ENTER VALID BOOK ID \u001b[0m");
   }
}

public String validateAuthorTitle(String input) {
   while(true) {
      if (input == "Title") {
         System.out.println("Enter Title");
      } else {
         System.out.println("Enter Author");
      }

      String result = this.sc.nextLine();
      if (AuthorTitle_Pattern.matcher(result).matches()) {
         return result;
      }

      System.out.println("\u001b[31mPlease Enter Valid " + input + "\u001b[0m");
   }
}

public String validatePublishYear() {
   while(true) {
      System.out.println("Enter Publish Year of Book ");
      String year = this.sc.nextLine();
      if (PublishYear_Pattern.matcher(year).matches()) {
         return year;
      }

      System.out.println("\u001b[31mEnter valid Publish Year\u001b[0m");
   }
}
}