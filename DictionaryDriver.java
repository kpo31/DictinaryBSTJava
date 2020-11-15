import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryDriver {
  private static DictionaryBST dictionary = new DictionaryBST();// the dictionary to perform actions
                                                                // on

  /**
   * prints out the menu in the format wanted
   */
  public static void printMenu() {
    System.out.println("=========================== Dictionary ============================\n"
        + "Enter one of the following options:\n"
        + "[A <word> <meaning>] to add a new word and its definition in the dictionary\n"
        + "[L <word>] to search a word in the dictionary and display its definition\n"
        + "[G] to print all the words in the dictionary in sorted order\n"
        + "[S] to get the count of all words in the dictionary\n"
        + "[H] to get the height of this dictionary implemented as a binary search tree\n"
        + "[Q] to quit the program\n"
        + "======================================================================");
  }

  /**
   * processes the commands of the user
   * 
   * @param sc2 - input
   */
  public static void processCommand(Scanner sc2) {
    System.out.println("Please enter your command: ");
    String[] input = sc2.nextLine().toUpperCase().trim().split(" ");// for all input cases
    while (!input[0].equals("Q")) {
      switch (input[0]) {
        case "A":// if a add
          dictionary.addWord(input[1], input[2]);
          break;
        case "L":// if l lookup
          System.out.println(dictionary.lookup(input[1]));
          break;
        case "G":// if g print
          ArrayList<String> answer = dictionary.getAllWords();
          for(int i = 0; i < answer.size(); i++) {// prints out the words in order needed
            System.out.print(answer.get(i) + ", ");
          }

        case "S":// get size
          System.out.println(dictionary.size());
          break;
        case "H":// get height
          System.out.println(dictionary.height());
          break;
      }
      printMenu();// print menu and get input again
      System.out.println("Please enter your command: ");
      input = sc2.nextLine().toUpperCase().trim().split(" ");
    }

  }

  /**
   * main
   * 
   * @param args - unused
   */
  public static void main(String[] args) {
    printMenu();// print out the menu
    Scanner sc = new Scanner(System.in);// take the in out
    processCommand(sc);// read the command
    System.out.println("============================== END ===================================");// end
                                                                                                 // message
    sc.close();// always close your scanners
  }

}
