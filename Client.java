import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter gender (M/F): ");
        out.println(scanner.nextLine());

        System.out.print("Enter age: ");
        out.println(scanner.nextLine());

        System.out.print("Enter weight (kg): ");
        out.println(scanner.nextLine());

        System.out.print("Enter height (cm): ");
        out.println(scanner.nextLine());

        System.out.print("Enter activity level (sedentary/moderate/active): ");
        out.println(scanner.nextLine());

        // Receive and print result
        System.out.println("\n--- Result ---");
        System.out.println(in.readLine());
        System.out.println(in.readLine());

        socket.close();
        scanner.close();
    }
}
