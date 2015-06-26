import java.net.*;
import java.io.*;
import java.util.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL google = new URL("http://www.1point3acres.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(google.openStream()));

        String inputLine;
        
        int number  = -1;
        List<String> list = new ArrayList<String>();
        while ((inputLine = in.readLine()) != null && number < 5) {
        	number++;
            list.add(inputLine);
            System.out.println(inputLine);
            System.out.println(number);
        }
        in.close();
    }
}