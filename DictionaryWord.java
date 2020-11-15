/*
 * Class DictionaryWord contains the word, and its definition
 */
public class DictionaryWord {
  private final String word; // word that represents the search key for this dictionary word
  private final String meaning; // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild; // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

  /*
   * Constructor
   * 
   * @param - word
   * 
   * @param - meaning
   * 
   * @throws - IllegalArgumentException if word/meaning
   */
  public DictionaryWord(String word, String meaning) {
    if (word == null) {
      throw new IllegalArgumentException("ERROR: word cannot be null");
    }
    if (word.equals("")) {
      throw new IllegalArgumentException("ERROR: word cannot be null");
    }
    if (meaning == null) {
      throw new IllegalArgumentException("ERROR: Invalid Input for meaning");
    }
    if (meaning.equals("")) {
      throw new IllegalArgumentException("ERROR: Invalid Input for meaning");
    }
    this.word = word;
    this.meaning = meaning;
    leftChild = null;
    rightChild = null;
  }


  /*
   * Returns left child of root
   * 
   * @return leftChild
   */
  public DictionaryWord getLeftChild() {
    return leftChild;
  }

  /*
   * Sets the left child of the root
   * 
   * @param - leftChild
   */
  public void setLeftChild(DictionaryWord leftChild) {
    this.leftChild = leftChild;
  }

  /*
   * Returns right child of root
   * 
   * @return rightChild
   */
  public DictionaryWord getRightChild() {
    return rightChild;
  }

  /*
   * Sets the right child of root
   * 
   * @param - rightChild
   */
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild;
  }


  /*
   * Getter for the word of this dictionary word
   * 
   * @return - word in DictionaryWord
   */
  public String getWord() {
    return word;
  }

  /*
   * getter for the meaning of DictionaryWord
   * 
   * @return - meaning
   */
  public String getMeaning() {
    return meaning;
  }

  /*
   * Returns a String representation of this DictionaryWord.
   */
  public String toString() {
    return word + ": " + meaning;
  }

}
