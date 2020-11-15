//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (ServingQueue.java)
// Files:           (Guest.java, ServingQueue.java, DessertSolvers.java, QueueTests.java)
// Course:          (Spring 2019)
//
// Author:          (Mihir Khatri)
// Email:           (mkhatri@wisc.edu)
// Lecturer's Name: (Mouna Kacem)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class ServingQueue {
  private Guest[] array;//the array is the queue
  private int size;//size of the array
  private int seatsAtTable;//number of seats at the table
  private int front;//front of the circular array
  private int back;//back of the circular array


  /**
   * Creates a new array based queue with a capacity of "seatsAtTable" guests. This queue should be
   * initialized to be empty.
   * 
   * @param seatsAtTable the size of the array holding this queue data
   */
  public ServingQueue(int seatsAtTable) {
    array = new Guest[seatsAtTable];//initializes the array and the seats, also initializes back and front
    this.seatsAtTable = seatsAtTable;
    front = -1;
    back = -1;
  }

  /**
   * Checks whether there are any guests in this serving queue.
   * 
   * @return true when this queue contains zero guests, and false otherwise.
   */
  public boolean isEmpty() {//checks whether empty
    return size == 0;
  }

  /**
   * Adds a single new guest to this queue (to be served after the others that were previously added
   * to the queue).
   * 
   * @param newGuest is the guest that is being added to this queue.
   * @throws IllegalStateException when called on a ServingQueue with an array that is full
   */
  public void add(Guest newGuest) {
    if (size == seatsAtTable) {//see if there is a seat available
      throw new IllegalStateException();
    } else if (size == 0) {//if this guest is the first one
      array[size] = newGuest;
      size++;//size increases
      front = 0;//back and front are both the same
      back = 0;
    } else {//if the array is already populated
      back = (back + 1) % seatsAtTable;//changes the back of the array
      array[back] = newGuest;
      size++;
    }

  }

  /**
   * Accessor for the guest that has been in this queue for the longest. This method does not add or
   * remove any guests.
   * 
   * @return a reference to the guest that has been in this queue the longest.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest peek() {//the person in the front of the queue has been in the queue longest
    return array[front];
  }

  /**
   * Removes the guest that has been in this queue for the longest.
   * 
   * @return a reference to the specific guest that is being removed.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest remove() {
    Guest retValue = array[0];
    if (size == 0) {//can't remove from an empty queue
      throw new IllegalStateException();
    } else {//if we remove the value of the front would change instead of the back ass seen ina dd
      retValue = array[front];
      front = (front + 1) % seatsAtTable;
      size--;//reduce the size
    }

    return retValue;
  }

  /**
   * The string representation of the guests in this queue should display each of the guests in this
   * queue (using their toString() implementation), and should display them in a comma separated
   * list that is surrounded by a set of square brackets. (this is similar to the formatting of
   * java.util.ArrayList.toString()). The order that these guests are presented in should be (from
   * left to right) the guest that has been in this queue the longest, to the guest that has been in
   * this queue the shortest. When called on an empty ServingQueue, returns "[]".
   * 
   * @return string representation of the ordered guests in this queue
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {//prints out the queue in string type
    String retValue = "[";//brackets added because of the format of the queue required
    int count = front;
    int i = 0;
    
    if (size == 0) {
      return "[]";//if empty return empty braces
    }
      while (i < size - 1) {//not till size because then comma would print after the last person
        retValue += array[count % array.length] + ", ";
        count++;
        i++;
      }
      retValue += array[count];//add the last person to the queue without comma after him/her
    retValue += "]";
    return retValue;
  }
}
