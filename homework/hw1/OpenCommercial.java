/* OpenCommercial.java */

import java.net.*;
import java.io.*;
import java.util.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();

    /* Replace this comment with your solution.  */
    String web;
    web = "http://www." + inputLine + ".com/";
    System.out.println(web);

    // create an URL object and establish URLConnection
    URL url = new URL(web);
    URLConnection urlConnection = url.openConnection();

    int numberofLine = 0;
    List<String> list = new ArrayList<String>();
    BufferedReader urlBuffer = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
    while ((inputLine = urlBuffer.readLine())!= null && numberofLine < 4) {
      numberofLine++;
      list.add(inputLine);
    }
    urlBuffer.close();
    int i;
    for (i = list.size()-1; i >= 0; i--) {
       System.out.println(list.get(i));
     }
    
  }
}