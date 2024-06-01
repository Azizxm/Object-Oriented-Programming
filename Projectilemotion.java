// Name: Aziz Mohmand
// 30/05/2024
// This Program is gonna to measure the distance horizontally and vertically by calculating the velocity and time of the projectile


import java.util.Scanner;

public class Projectilemotion {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get the initial angle from the user
    double angle = getUserInput(scanner, "Enter the initial angle (in degrees): ");

    // Get the initial velocity from the user
    double velocity = getUserInput(scanner, "Enter the initial velocity (in m/s): ");

    // Get the time from the user
    double time = getUserInput(scanner, "Enter the time (in seconds): ");

    // Convert the angle from degrees to radians
    double angleInRadians = Math.toRadians(angle);

    // Calculate horizontal distance
    double d_x = (velocity * Math.cos(angleInRadians)) * time;

    // Calculate vertical distance
    double g = -9.81; // Gravitational force
    double d_y = (velocity * Math.sin(angleInRadians)) * time + 0.5 * g * Math.pow(time, 2);

    // Round results to two decimal places
    d_x = Math.round(d_x * 100.0) / 100.0;
    d_y = Math.round(d_y * 100.0) / 100.0;

    // Display the results
    System.out.println("The position of the projectile after " + time + " seconds is:");
    System.out.println("The Horizontal distance (d_x): " + d_x + " meters");
    System.out.println("The Vertical distance (d_y): " + d_y + " meters");

    scanner.close();
}

    // Method to get and validate user input
    private static double getUserInput(Scanner scanner, String prompt) {
        double value = -1;
        while (value < 0) {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. " + prompt);
                scanner.next();
            }
            value = scanner.nextDouble();
            if (value < 0) {
                System.out.println("Please enter a positive value.");
            }
        }
        return value;
    }
}