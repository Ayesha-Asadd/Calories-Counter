import java.util.Scanner;

// Pipe-and-Filter style Calorie Calculator
public class pipe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stage 1: Input Filter
        InputData inputData = InputFilter.getInput(scanner);

        // Stage 2: Validation Filter
        if (!ValidationFilter.isValidGender(inputData.gender)) {
            System.out.println("Invalid gender input. Please enter 'M' or 'F'.");
            scanner.close();
            return;
        }
        if (!ValidationFilter.isValidActivityLevel(inputData.activityLevel)) {
            System.out.println("Invalid activity level input. Please choose 'sedentary', 'moderate', or 'active'.");
            scanner.close();
            return;
        }

        // Stage 3: BMR Calculation Filter
        double bmr = BMRCalculationFilter.calculateBMR(inputData);

        // Stage 4: Calorie Needs Calculation Filter
        double calorieNeeds = CalorieCalculationFilter.calculateCalories(bmr, inputData.activityLevel);

        // Stage 5: Output Filter
        OutputFilter.displayResults(bmr, calorieNeeds);

        scanner.close();
    }
}

// Data class to hold input data
class InputData {
    String gender;
    int age;
    double weight;
    double height;
    String activityLevel;
}

// Filter 1: Input Filter
class InputFilter {
    public static InputData getInput(Scanner scanner) {
        InputData data = new InputData();

        System.out.println("Calorie Calculator");

        System.out.print("Enter your gender (M/F): ");
        data.gender = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter your age (in years): ");
        data.age = getValidIntInput(scanner);
        scanner.nextLine(); // Consume newline

        System.out.print("Enter your weight (in kilograms): ");
        data.weight = getValidDoubleInput(scanner);
        scanner.nextLine();

        System.out.print("Enter your height (in centimeters): ");
        data.height = getValidDoubleInput(scanner);
        scanner.nextLine();

        System.out.print("Enter your activity level (sedentary/moderate/active): ");
        data.activityLevel = scanner.nextLine().trim().toLowerCase();

        return data;
    }

    private static int getValidIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}

// Filter 2: Validation Filter
class ValidationFilter {
    public static boolean isValidGender(String gender) {
        return gender.equals("M") || gender.equals("F");
    }

    public static boolean isValidActivityLevel(String level) {
        return level.equals("sedentary") || level.equals("moderate") || level.equals("active");
    }
}

// Filter 3: BMR Calculation Filter
class BMRCalculationFilter {

    private static final double MALE_BMR_CONSTANT = 88.362;
    private static final double FEMALE_BMR_CONSTANT = 447.593;
    private static final double MALE_WEIGHT_COEFFICIENT = 13.397;
    private static final double FEMALE_WEIGHT_COEFFICIENT = 9.247;
    private static final double MALE_HEIGHT_COEFFICIENT = 4.799;
    private static final double FEMALE_HEIGHT_COEFFICIENT = 3.098;
    private static final double MALE_AGE_COEFFICIENT = 5.677;
    private static final double FEMALE_AGE_COEFFICIENT = 4.330;

    public static double calculateBMR(InputData data) {
        if (data.gender.equals("M")) {
            return MALE_BMR_CONSTANT
                    + (MALE_WEIGHT_COEFFICIENT * data.weight)
                    + (MALE_HEIGHT_COEFFICIENT * data.height)
                    - (MALE_AGE_COEFFICIENT * data.age);
        } else {
            return FEMALE_BMR_CONSTANT
                    + (FEMALE_WEIGHT_COEFFICIENT * data.weight)
                    + (FEMALE_HEIGHT_COEFFICIENT * data.height)
                    - (FEMALE_AGE_COEFFICIENT * data.age);
        }
    }
}

// Filter 4: Calorie Needs Calculation Filter
class CalorieCalculationFilter {

    private static final double SEDENTARY_MULTIPLIER = 1.2;
    private static final double MODERATE_MULTIPLIER = 1.55;
    private static final double ACTIVE_MULTIPLIER = 1.725;

    public static double calculateCalories(double bmr, String level) {
        switch (level) {
            case "sedentary":
                return bmr * SEDENTARY_MULTIPLIER;
            case "moderate":
                return bmr * MODERATE_MULTIPLIER;
            case "active":
                return bmr * ACTIVE_MULTIPLIER;
            default:
                throw new IllegalArgumentException("Invalid activity level.");
        }
    }
}

// Filter 5: Output Filter
class OutputFilter {
    public static void displayResults(double bmr, double calories) {
        System.out.printf("Your Basal Metabolic Rate (BMR) is: %.0f calories per day.\n", bmr);
        System.out.printf("Your estimated daily calorie needs are: %.0f calories per day.\n", calories);
    }
}
