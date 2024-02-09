
// import libraries needed for program
import java.util.Scanner;
import java.io.*;

public class WeightManagement {
  // main method - entry point
  public static void main(String[] args) {
    // this array holds the different items we can do to lose weight
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

    // scanner object for user input
    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    // Loop to get user input until valid input is recieved
    while (true) {
      System.out.println("Press 1 to see the current regiment or press 2 to calculate a new regiment");
      try {
        // get user's choice for what to do in program
        choice = scanner.nextInt();
        if (choice == 1 || choice == 2) {
          // if valid choice, exit loop
          break;
        } else {
          // feedback to user if invalid input
          System.out.println("Invalid input: Please enter either 1 or 2");
        }
      } catch (Exception e) {
        System.out.println("Invalid input: Please enter either 1 or 2");
        scanner.next();
      }
    }
    // based on user input, decide what to do
    if (choice == 1) {
      displayCurrentRegiment();
    } else if (choice == 2) {
      calculateNewRegiment(scanner, regimentItems);
    }
  }

  // this method displays what's the current regiment from the file
  public static void displayCurrentRegiment() {
    try {
      // open file to read regiment
      File file = new File("regiment.txt");
      Scanner fileScanner = new Scanner(file);
      // read each line in file and print to console
      while (fileScanner.hasNextLine()) {
        System.out.println(fileScanner.nextLine());
      }
      // release scanner as we are done with it
      fileScanner.close();
    } catch (Exception e) {
      // if no file present, will let user know
      System.out.println("It seems we don't have a regiment yet. Please run program again and run option 2");
    }
  }

  // function to calculate and create new regiment
  public static void calculateNewRegiment(Scanner scanner, String[] regimentItems) {
    int poundsFat = 0;
    // loop until get valid fat input
    while (true) {
      System.out.println("Please enter number of pounds of fat");
      try {
        // get user input for pounds of fat
        poundsFat = scanner.nextInt();
        // valid range for fat
        if (poundsFat >= 0 && poundsFat <= 100) {
          break;
        } else {
          // let user know if input is invalid
          System.out.println("Invalid input, please enter a number between 0 and 100");
        }
      } catch (Exception e) {
        System.out.println("Invalid input");
        scanner.next();
      }
    }

    // determine how much of regiment array to use based on pounds of fat
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
    System.out.println("Pounds of fat: " + poundsFat);

    // write to file with new regiment
    try {
      PrintWriter writer = new PrintWriter("regiment.txt");
      writer.println();
      writer.println("Below is your regiment to lose weight:");
      writer.println();
      // for each item in array we're using, put in a new line in file
      for (int i = 0; i <= endIndex; i++) {
        writer.println(regimentItems[i]);
      }
      writer.println();
      // properly close the file
      writer.close();
      displayCurrentRegiment();
    } catch (Exception e) {
      // in case something goes wrong
      System.out.println("Error writing to file");
    }
  }
}