// I love you n times program
import java.io.*;
import java.util.*;
class love {

public static void main(String[] args) {
		System.out.println("How many times do I love you?");
		Scanner in = new Scanner(System.in);
		String i = in.nextLine();
		int times = Integer.parseInt(i);
		for (int n = 1; n <= times; n++) {
		System.out.println("I love you " + n + " times.");
	    }
	    System.out.println("Powered by Java, programmed by M.Z");
	}
		
}