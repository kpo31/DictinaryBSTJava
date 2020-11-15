import java.util.*;

public class DictionaryBST implements Dictionary {
  private DictionaryWord root;

  // This should be the only constructor of this class.
  // Creates an empty dictionaryBST.
  public DictionaryBST() {
    root = null;
  }

  // Methods defined in the Dictionary interface
  public boolean isEmpty() {
    return root == null;
  }

  // NO DUPLICATES
  public boolean addWord(String word, String meaning) {
    if (word == null) {
      throw new IllegalArgumentException("ERROR: word cannot be null");
    }
    if (word.equals("")) {
      throw new IllegalArgumentException("ERROR: word cannot be blank");
    }
    if (meaning == null) {
      throw new IllegalArgumentException("ERROR: Invalid Input for meaning");
    }
    if (meaning.equals("")) {
      throw new IllegalArgumentException("ERROR: Invalid Input for meaning");
    }
    if (isEmpty()) {
      root = new DictionaryWord(word, meaning);
      return true;
    } else {// if the word is not null
      DictionaryWord newNode = new DictionaryWord(word, meaning);
      return (addWordHelper(newNode, root));
    }
  }

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where newWord
   *                    will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newNode, DictionaryWord current) {
    if (newNode.equals(current))
      return false;
    if (newNode.getWord().compareToIgnoreCase(current.getWord()) < 0) {
      if (current.getLeftChild() == null) {
        current.setLeftChild(newNode);
        return true;
      } else {
        return addWordHelper(newNode, current.getLeftChild());
      }
    } else if (newNode.getWord().compareToIgnoreCase(current.getWord()) > 0) {
      if (current.getRightChild() == null) {
        current.setRightChild(newNode);
        return true;
      } else {
        return addWordHelper(newNode, current.getRightChild());
      }
    }
    return true;

  }

  public String lookup(String s) {
    if (s.compareToIgnoreCase(root.getWord()) == 0) {
      return root.getMeaning();
    }
    return lookupHelper(s, root);
  }

  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord curr) {
    if (curr == null)
      throw new NoSuchElementException("Word is not in BST Dictionary");
    else if (s.equals(curr.getWord())) { // if the word is found, return meaning
      return curr.getMeaning();
    } else if (s.compareToIgnoreCase(curr.getWord()) < 0) {// left side
      return lookupHelper(s, curr.getLeftChild());
    } else {
      return lookupHelper(s, curr.getRightChild()); // right side
    }
  }

  public int size() {
    return sizeHelper(root);
  }

  /**
   * Recursive helper method that returns the number of dictionary words stored in the subtree
   * rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    if (current == null) {
      return 0;
    } else {
      return 1 + sizeHelper(current.getLeftChild()) + sizeHelper(current.getRightChild());
    }
  }

  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from root to the
   * deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord nodes
   *         from the current node to the deepest leaf in the subtree rooted at current
   */
  // TODO: make this work
  private static int heightHelper(DictionaryWord current) {
    int leftTreeHeight = 0;
    int rightTreeHeight = 0;
    if (current == null)
      return 0;

    rightTreeHeight = 1 + heightHelper(current.getRightChild());
    leftTreeHeight = 1 + heightHelper(current.getLeftChild());

    if (leftTreeHeight < rightTreeHeight) {
      return rightTreeHeight;
    } else {
      return leftTreeHeight;
    }
  }


  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the ascendant
   *         order
   */
  public ArrayList<String> getAllWords() {
    ArrayList<String> arr = new ArrayList<String>();
    arr = getAllWordsHelper(root);
    return arr;
  }

  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree rooted at
   * current
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord curr) {
    ArrayList<String> ret = new ArrayList<String>();
    if (curr == null) {
      return ret;
    }
    getAllWordsHelper(curr, ret);
    return ret;
  }

  /**
   * Private helper for getAllWords() method
   * 
   * @param curr - current DictionaryWord
   * @param arr  - current ArrayList
   */
  private static void getAllWordsHelper(DictionaryWord curr, ArrayList<String> arr) {

    if (curr.getLeftChild() != null)
      getAllWordsHelper(curr.getLeftChild(), arr);
    arr.add(curr.getWord());
    if (curr.getRightChild() != null)
      getAllWordsHelper(curr.getRightChild(), arr);

  }


}
