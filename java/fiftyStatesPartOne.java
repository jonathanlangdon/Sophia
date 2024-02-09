import java.util.Arrays;
import java.util.Scanner;

public class fiftyStatesPartOne {
  static String[][] statesAndCapitals = {
      { "Alabama", "Montgomery" },
      { "Alaska", "Juneau" },
      { "Arizona", "Phoenix" },
      { "Arkansas", "Little Rock" },
      { "California", "Sacramento" },
      { "Colorado", "Denver" },
      { "Connecticut", "Hartford" },
      { "Delaware", "Dover" },
      { "Florida", "Tallahassee" },
      { "Georgia", "Atlanta" },
      { "Hawaii", "Honolulu" },
      { "Idaho", "Boise" },
      { "Illinois", "Springfield" },
      { "Indiana", "Indianapolis" },
      { "Iowa", "Des Moines" },
      { "Kansas", "Topeka" },
      { "Kentucky", "Frankfort" },
      { "Louisiana", "Baton Rouge" },
      { "Maine", "Augusta" },
      { "Maryland", "Annapolis" },
      { "Massachusetts", "Boston" },
      { "Michigan", "Lansing" },
      { "Minnesota", "Saint Paul" },
      { "Mississippi", "Jackson" },
      { "Missouri", "Jefferson City" },
      { "Montana", "Helena" },
      { "Nebraska", "Lincoln" },
      { "Nevada", "Carson City" },
      { "New Hampshire", "Concord" },
      { "New Jersey", "Trenton" },
      { "New Mexico", "Santa Fe" },
      { "New York", "Albany" },
      { "North Carolina", "Raleigh" },
      { "North Dakota", "Bismarck" },
      { "Ohio", "Columbus" },
      { "Oklahoma", "Oklahoma City" },
      { "Oregon", "Salem" },
      { "Pennsylvania", "Harrisburg" },
      { "Rhode Island", "Providence" },
      { "South Carolina", "Columbia" },
      { "South Dakota", "Pierre" },
      { "Tennessee", "Nashville" },
      { "Texas", "Austin" },
      { "Utah", "Salt Lake City" },
      { "Vermont", "Montpelier" },
      { "Virginia", "Richmond" },
      { "Washington", "Olympia" },
      { "West Virginia", "Charleston" },
      { "Wisconsin", "Madison" },
      { "Wyoming", "Cheyenne" }
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