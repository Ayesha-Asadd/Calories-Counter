import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Read user inputs from client
        String gender = in.readLine();
        int age = Integer.parseInt(in.readLine());
        double weight = Double.parseDouble(in.readLine());
        double height = Double.parseDouble(in.readLine());
        String activityLevel = in.readLine();

        // Calculate BMR
        double bmr = calculateBMR(gender, age, weight, height);
        double calories = calculateCalorieNeeds(bmr, activityLevel);

        // Send result to client
        out.println("BMR: " + Math.round(bmr) + " calories/day");
        out.println("Daily Calorie Needs: " + Math.round(calories) + " calories/day");

        socket.close();
        serverSocket.close();
    }

    private static double calculateBMR(String gender, int age, double weight, double height) {
        if (gender.equalsIgnoreCase("M")) {
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
    }

    private static double calculateCalorieNeeds(double bmr, String level) {
        switch (level.toLowerCase()) {
            case "sedentary": return bmr * 1.2;
            case "moderate": return bmr * 1.55;
            case "active": return bmr * 1.725;
            default: return bmr;
        }
    }
}
