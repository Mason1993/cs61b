import java.net.*;
import java.io.*;
import java.util.*;

public class Nuke2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str= in.nextLine();
        String str2;
        str2 = str.substring(0,1) + str.substring(2);
        System.out.println(str2);
        in.close();
    }
}