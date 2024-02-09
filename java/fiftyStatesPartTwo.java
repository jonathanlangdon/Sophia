import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fiftyStatesPartTwo {
  public static Map<String, String> statesAndCapitals = new HashMap<>();

  public static void setupCapitals() {
    statesAndCapitals.put("Alabama", "Montgomery");
    statesAndCapitals.put("Alaska", "Juneau");
    statesAndCapitals.put("Arizona", "Phoenix");
    statesAndCapitals.put("Arkansas", "Little Rock");
    statesAndCapitals.put("California", "Sacramento");
    statesAndCapitals.put("Colorado", "Denver");
    statesAndCapitals.put("Connecticut", "Hartford");
    statesAndCapitals.put("Delaware", "Dover");
    statesAndCapitals.put("Florida", "Tallahassee");
    statesAndCapitals.put("Georgia", "Atlanta");
    statesAndCapitals.put("Hawaii", "Honolulu");
    statesAndCapitals.put("Idaho", "Boise");
    statesAndCapitals.put("Illinois", "Springfield");
    statesAndCapitals.put("Indiana", "Indianapolis");
    statesAndCapitals.put("Iowa", "Des Moines");
    statesAndCapitals.put("Kansas", "Topeka");
    statesAndCapitals.put("Kentucky", "Frankfort");
    statesAndCapitals.put("Louisiana", "Baton Rouge");
    statesAndCapitals.put("Maine", "Augusta");
    statesAndCapitals.put("Maryland", "Annapolis");
    statesAndCapitals.put("Massachusetts", "Boston");
    statesAndCapitals.put("Michigan", "Lansing");
    statesAndCapitals.put("Minnesota", "Saint Paul");
    statesAndCapitals.put("Mississippi", "Jackson");
    statesAndCapitals.put("Missouri", "Jefferson City");
    statesAndCapitals.put("Montana", "Helena");
    statesAndCapitals.put("Nebraska", "Lincoln");
    statesAndCapitals.put("Nevada", "Carson City");
    statesAndCapitals.put("New Hampshire", "Concord");
    statesAndCapitals.put("New Jersey", "Trenton");
    statesAndCapitals.put("New Mexico", "Santa Fe");
    statesAndCapitals.put("New York", "Albany");
    statesAndCapitals.put("North Carolina", "Raleigh");
    statesAndCapitals.put("North Dakota", "Bismarck");
    statesAndCapitals.put("Ohio", "Columbus");
    statesAndCapitals.put("Oklahoma", "Oklahoma City");
    statesAndCapitals.put("Oregon", "Salem");
    statesAndCapitals.put("Pennsylvania", "Harrisburg");
    statesAndCapitals.put("Rhode Island", "Providence");
    statesAndCapitals.put("South Carolina", "Columbia");
    statesAndCapitals.put("South Dakota", "Pierre");
    statesAndCapitals.put("Tennessee", "Nashville");
    statesAndCapitals.put("Texas", "Austin");
    statesAndCapitals.put("Utah", "Salt Lake City");
    statesAndCapitals.put("Vermont", "Montpelier");
    statesAndCapitals.put("Virginia", "Richmond");
    statesAndCapitals.put("Washington", "Olympia");
    statesAndCapitals.put("West Virginia", "Charleston");
    statesAndCapitals.put("Wisconsin", "Madison");
    statesAndCapitals.put("Wyoming", "Cheyenne");
  };

  public static void bubbleSort(String[][] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j][1].compareTo(array[j + 1][1]) > 0) {
          String[] temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  public static boolean checkReadiness(Scanner scanner) {
    boolean continueInitialization = true;
    while (continueInitialization) {
      System.out.println("Ready to be tested on state capitals? Enter 'Y' or 'N'");
      String readiness = scanner.nextLine();
      if (readiness.equalsIgnoreCase("n")) {
        return false;
      } else if (readiness.equalsIgnoreCase("y")) {
        continueInitialization = false;
      }
    }
    return true;
  }

  public static void playGame(Scanner scanner) {
    boolean ready = checkReadiness(scanner);
    if (!ready)
      return;
    int score = 0;
    for (String[] capital : statesAndCapitals) {
      String curCapital = capital[1];
      String curState = capital[0];
      System.out.println("\nWhat is the capital of " + curState + "?");
      String answerInput = scanner.nextLine();
      if (answerInput.equalsIgnoreCase(curCapital)) {
        score += 1;
        System.out.println("\nYou are correct! " + curCapital + " is the capital of " + curState);
      } else {
        System.out.println("Oh, bummer! That isn't right. " + curCapital + " is the capital of " + curState);
      }
    }
    System.out.println("\nYou did it!  All states complete. Your score out of 50 is " + score + "\n");
  }

  public static void main(String[] args) {
    setupCapitals();
    Scanner scanner = new Scanner(System.in);
    System.out.println("States & Capitals sorted by State name:");
    System.out.println(Arrays.deepToString(statesAndCapitals));
    System.out.println("Now sorting by capital using Bubble Sort...");
    bubbleSort(statesAndCapitals);
    System.out.println("Done!");
    System.out.println("New array sorted by capitals:");
    System.out.println(Arrays.deepToString(statesAndCapitals));
    playGame(scanner);
    scanner.close();
  }

}