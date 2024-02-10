import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class fiftyStatesPartTwo {
  public static Map<String, String> capitalsHashMap = new HashMap<>();
  public static Map<String, String> capitalsTreeMap = new TreeMap<>();

  public static void setupCapitals() {
    capitalsHashMap.put("Alabama", "Montgomery");
    capitalsHashMap.put("Alaska", "Juneau");
    capitalsHashMap.put("Arizona", "Phoenix");
    capitalsHashMap.put("Arkansas", "Little Rock");
    capitalsHashMap.put("California", "Sacramento");
    capitalsHashMap.put("Colorado", "Denver");
    capitalsHashMap.put("Connecticut", "Hartford");
    capitalsHashMap.put("Delaware", "Dover");
    capitalsHashMap.put("Florida", "Tallahassee");
    capitalsHashMap.put("Georgia", "Atlanta");
    capitalsHashMap.put("Hawaii", "Honolulu");
    capitalsHashMap.put("Idaho", "Boise");
    capitalsHashMap.put("Illinois", "Springfield");
    capitalsHashMap.put("Indiana", "Indianapolis");
    capitalsHashMap.put("Iowa", "Des Moines");
    capitalsHashMap.put("Kansas", "Topeka");
    capitalsHashMap.put("Kentucky", "Frankfort");
    capitalsHashMap.put("Louisiana", "Baton Rouge");
    capitalsHashMap.put("Maine", "Augusta");
    capitalsHashMap.put("Maryland", "Annapolis");
    capitalsHashMap.put("Massachusetts", "Boston");
    capitalsHashMap.put("Michigan", "Lansing");
    capitalsHashMap.put("Minnesota", "Saint Paul");
    capitalsHashMap.put("Mississippi", "Jackson");
    capitalsHashMap.put("Missouri", "Jefferson City");
    capitalsHashMap.put("Montana", "Helena");
    capitalsHashMap.put("Nebraska", "Lincoln");
    capitalsHashMap.put("Nevada", "Carson City");
    capitalsHashMap.put("New Hampshire", "Concord");
    capitalsHashMap.put("New Jersey", "Trenton");
    capitalsHashMap.put("New Mexico", "Santa Fe");
    capitalsHashMap.put("New York", "Albany");
    capitalsHashMap.put("North Carolina", "Raleigh");
    capitalsHashMap.put("North Dakota", "Bismarck");
    capitalsHashMap.put("Ohio", "Columbus");
    capitalsHashMap.put("Oklahoma", "Oklahoma City");
    capitalsHashMap.put("Oregon", "Salem");
    capitalsHashMap.put("Pennsylvania", "Harrisburg");
    capitalsHashMap.put("Rhode Island", "Providence");
    capitalsHashMap.put("South Carolina", "Columbia");
    capitalsHashMap.put("South Dakota", "Pierre");
    capitalsHashMap.put("Tennessee", "Nashville");
    capitalsHashMap.put("Texas", "Austin");
    capitalsHashMap.put("Utah", "Salt Lake City");
    capitalsHashMap.put("Vermont", "Montpelier");
    capitalsHashMap.put("Virginia", "Richmond");
    capitalsHashMap.put("Washington", "Olympia");
    capitalsHashMap.put("West Virginia", "Charleston");
    capitalsHashMap.put("Wisconsin", "Madison");
    capitalsHashMap.put("Wyoming", "Cheyenne");
  };

  public static void addToTreeMap(Map<String, String> sourceMap, Map<String, String> targetMap) {
    for (Map.Entry<String, String> entry : sourceMap.entrySet()) {
      targetMap.put(entry.getKey(), entry.getValue());
    }
  }

  public static void playGame(Scanner scanner) {
    boolean continueGame = true;
    while (continueGame) {
      System.out.println("\nPlease enter a state to find out it's capital or type 'exit' to quit");
      String state = scanner.nextLine();
      state = state.substring(0, 1).toUpperCase() + state.substring(1).toLowerCase();
      if (state.equalsIgnoreCase("Exit")) {
        return;
      } else {
        if (capitalsHashMap.containsKey(state)) {
          System.out.println("\nThe capital of " + state + " is " + capitalsHashMap.get(state));
        }
      }
    }
  }

  public static void main(String[] args) {
    setupCapitals();
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nStates & Capitals from Hashmap:");
    for (Map.Entry<String, String> entry : capitalsHashMap.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
    System.out.println("\nNow sorting by capital by adding to a Tree Map...");
    addToTreeMap(capitalsHashMap, capitalsTreeMap);
    System.out.println("\nDone!");
    System.out.println("\nNew Tree Map sorted by state name:");
    for (Map.Entry<String, String> entry : capitalsTreeMap.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
    playGame(scanner);
    scanner.close();
  }

}