import java.util.Arrays;
import java.util.Scanner;

public class fiftyStates {
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

  public static void playGame() {
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("States & Capitals sorted by State name:");
    System.out.println(Arrays.deepToString(statesAndCapitals));
    System.out.println("Now sorting by capital using Bubble Sort...");
    bubbleSort(statesAndCapitals);
    System.out.println("Done!");
    System.out.println("New array sorted by capitals:");
    System.out.println(Arrays.deepToString(statesAndCapitals));
  }

}