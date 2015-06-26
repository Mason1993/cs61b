import java.net.*;
import java.io.*;
import java.util.*;

/*
public class DataURL {
    public static void main(String[] args) throws Exception {
        String url;
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.print("Please enter the name of a company (without spaces): ");
        url = "http://www." + name +".com/";

        String inputLine;

       int numberofLine = 0;
    int i;

    List<String> list = new ArrayList<String>();
    while ((inputLine = in.readLine()) != null && numberofLine < 5) {
      numberofLine++;
      list.add(inputLine);
    }
    in.close();

    for (i = list.size()-1; i >= 0; i--) {
       System.out.println(list.get(i));
       System.out.println(i);
        }   
    }   
}
*/

public class DataURL {
    public static void main(String[] args) throws Exception {
        URL yahoo = new URL("http://www.1point3acres.com/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                yahoo.openStream()));

        String inputLine;

       int numberofLine = 0;
    int i;

    List<String> list = new ArrayList<String>();
    while ((inputLine = in.readLine()) != null && numberofLine < 5) {
      numberofLine++;
      list.add(inputLine);
    }
    in.close();

    for (i = list.size()-1; i >= 0; i--) {
       System.out.println(list.get(i));
        }   
    }   
}