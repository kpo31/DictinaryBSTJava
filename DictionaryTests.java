
public class DictionaryTests {
  
  /**
   * tests the addWord method
   * @return - true if passed false otherwise
   */
  public static boolean testAddWord() {
    
    DictionaryBST BST = new DictionaryBST();
    BST.addWord("dogs", "dogs are man's best friend");
    BST.addWord("cats", "cats are the devil incarnate");
    BST.addWord("fish", "atleast they taste good");//makes a new BST and adds word to them
    
    if(BST.isEmpty()) {//tests isEmpty Method too
      System.out.println("ERROR: testAddWord() failed");
      return false;
    }
    System.out.println("testAddWord() passed");
    return true;
  }
  /**
   * tests the setLeftChildMethod
   * @return - true if passed false otherwise
   */
  public static boolean testSetLeftChild() {
     DictionaryWord word = new DictionaryWord("dogs", "dogs are man's best friend");
     DictionaryWord word2 = new DictionaryWord("cats", "cats are the devil incarnate");
     DictionaryWord word3 = new DictionaryWord("fish", "atleast they taste good");//3 new words to test on
     
     word.setLeftChild(word2);
     word.setRightChild(word3);
     if(word.getLeftChild().getWord().equals("cats")) {//tests the getWord() method too
       System.out.println("testSetLeftChild() passed");
       return true;
     }
     System.out.println("ERROR: testSetLeftChild() failed");
    return false;
  }
  /**
   * tests the setRightChild() method
   * @return - return true if correct false otherwise
   */
  public static boolean testSetRightChild() {
    DictionaryWord word = new DictionaryWord("dogs", "dogs are man's best friend");
    DictionaryWord word2 = new DictionaryWord("cats", "cats are the devil incarnate");
    DictionaryWord word3 = new DictionaryWord("fish", "atleast they taste good");//new word to test with
    
    word.setLeftChild(word2);
    word.setRightChild(word3);//set the right and left child
    if(word.getRightChild().getWord().equals("fish")) {//tests the getRightChild and getWord method too
      System.out.println("testSetRightChild() passed");
      return true;
    }
    System.out.println("ERROR: testSetRightChild() failed");
   return false;
 }
  /**
   * tests the height method
   * @return
   */
  public static boolean testHeight() {
    DictionaryBST BST = new DictionaryBST();//makes the BST and add the words to it
    BST.addWord("dogs", "dogs are man's best friend");
    BST.addWord("cats", "cats are the devil incarnate");
    BST.addWord("fish", "atleast they taste good");
    
    if(BST.height() == 2) {//adding 3 words sets the height to 2
      System.out.println("testHeight() passed");
      return true;
    }
    System.out.println("ERROR: testHeight() passed:");
    return false;
  }
  /**
   * tests the toString() method
   * @return - true if correct false otherwise
   */
  public static boolean testToString() {
    DictionaryWord word = new DictionaryWord("dogs", "dogs are man's best friend");//word to test on
    if(word.toString().equals("dogs: dogs are man's best friend")) {//meaning and the word are tested
      System.out.println("testToString() Passed");
      return true;
    }
    System.out.println("ERROR: testToString() failed");
    return false;
  }
  // TODO: need 5 test methods in total
/**
 * main method to implement the tests
 * @param args - unused
 */
  public static void main(String[] args) {
    testAddWord();
    testSetLeftChild();
    testSetRightChild();
    testHeight();
    testToString();
    // TODO Auto-generated method stub

  }

}
