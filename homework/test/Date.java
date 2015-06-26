import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class Date {
  /* Put your private data fields here. */
  private int month;
  private int day;
  private int year;
   /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(int month, int day, int year) {
    if (isValidDate(month, day, year)){
      this.month = month;
      this.day = day;
      this.year = year;
    } 
      else {
        System.out.println(month + ", " + day + ", " + year + " is an invalid date");
        System.exit(0);
      }

  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  /*
  public Test(String s) {
    if (s.matches("(\\d{1,2}\\/\\d{1,2}\\/\\d{1,4})")){
      String [] dateinstring = s.split("\\/");
      month = Integer.parseInt(dateinstring[0]);
      day = Integer.parseInt(dateinstring[1]);
      year = Integer.parseInt(dateinstring[2]);
      if (isValidDate(month,day,year)){
        this.month = month;
        this.day = day;
        this.year = year;
      }
      else{
        System.out.println(s + " is an invalid date");
        System.exit(0);
      }
    }
    */
    public int difference(Date d) {
    int diff = 0;
    for (i = year; i < d.year; i++) {
      if (isLeapYear(i)) {
        diff += 366;
      }
      else 
        diff += 365;
      diff += c.dayInYear;
    }
    diff += d.dayInYear - this.dayInYear;
    return diff;                           // replace this line with your solution
  }
    
  }
    public static void main(String[] argv) {
      System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

      System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
      /*
      String s = in.nextLine()
      Test d1 = new Test(s);
      System.out.println("The date after 1 year + 1 month + 1 day is:");
      System.out.println("month: " + (d1.month+1));
      System.out.println("day: " + (d1.day+1));
      System.out.println("year: " + (d1.year+1));
      */
    }
}