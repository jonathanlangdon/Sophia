import java.util.Scanner;
import java.io.*;

public class WeightManagement {
  public static void main(String[] args) {
    String[] regimentItems = {
        "Eating window - 4 hours",
        "100g protein in diet",
        "8h+ sleep",
        "Daily 15m Workout",
        "Only milk or non-calorie drinks",
        "No flour, rice, potatoes (high glycemic)",
        "MyFitnessPal: Track Calories: 2,000 Calories",
        "Burn supplement"
    };

    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    while (true) {
      System.out.println("Press 1 to see the current regiment or press 2 to calculate a new regiment");
      try {
        choice = scanner.nextInt();
        if (choice == 1 || choice == 2) {
          break;
        } else {
          System.out.println("Invalid input: Please enter either 1 or 2");
        }
      } catch (Exception e) {
        System.out.println("Invalid input: Please enter either 1 or 2");
        scanner.next();
      }
    }
    if (choice == 1) {
      displayCurrentRegiment();
    } else if (choice == 2) {
      calculateNewRegiment();
    }
  }

  public static void displayCurrentRegiment() {
    try {
      File file = new File("regiment.txt");
      Scanner fileScanner = new Scanner(file);
      while (fileScanner.hasNextLine()) {
        System.out.println(fileScanner.nextLine());
      }
      fileScanner.close();
    } catch (Exception e) {
      System.out.println("Error reading file");
    }
  }

  public static void calculateNewRegiment(Scanner scanner, String[] regimentItems) {
    int poundsFat = 0;
    while (true) {
      System.out.println("Please enter number of pounds of fat");
      try {
        poundsFat = scanner.nextInt();
        if (poundsFat >= 0 && poundsFat <= 100) {
          break;
        } else {
          System.out.println("Invalid input, please enter a number between 0 and 100");
        }
      } catch (Exception e) {
        System.out.println("Invalid input");
        scanner.next();
      }

      int endIndex = 0;
      if (poundsFat > 20) {
        endIndex = 7;
      } else if (poundsFat > 19) {
        endIndex = 5;
      } else if (poundsFat > 18) {
        endIndex = 4;
      } else {
        endIndex = 3;
      }

      try {
        PrintWriter writer = new PrintWriter("regiment.txt");
        for (int i = 0; i <= endIndex; i++) {
          writer.println(regimentItems[i]);
        }
        displayCurrentRegiment();
      } catch (Exception e) {
        System.out.println("Error writing to file")
      }
    }
  }
}