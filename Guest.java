//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (Guest.java)
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
public class Guest {
   private int index;//the index of the guest
   private static int nextIndex = 1;//stores the next Index
   private String dietaryRestriction = "";//dietary restrictions if any
  /**
   * Resets the counting of newly constructed guest indexes, so that the next new Guest that is created
   * will be associated with the guest index of one.
   * 
   * Note: that this will be helpful when running several tests, or solving solving several 
   * dessert simulation problems.  And that this should never be called from ServingQueue.java
   */
  public static void resetNextGuestIndex() {
    nextIndex = 1;//sets the nextIndex back to 1
  }
 
  /**
   * Constructs a new guest with no dietary restrictions.  This guest should be associated with an
   * index that is one larger than the previously constructed guest (or 1, if no prior guest, or if 
   * resetNextGuestIndex() was called more recently).
   */
  public Guest() {//sets the index and increments the nextIndex
    index = nextIndex;
    nextIndex++;
  }
  
  /**
   * Constructs a new guest with the specified dietary restrictions.  This guest should be 
   * associated with an index that is one larger than the previously constructed guest (or 1, if 
   * no prior guest, or if resetNextGuestIndex() was called more recently).
   * @param dietaryRestriction describes requirements for what this guest can and cannot eat
   */
  public Guest(String dietaryRestriction) {//sets the index and increments the nextIndex and the dietary restriction
    index = nextIndex;
    this.dietaryRestriction = dietaryRestriction;
    nextIndex++;
  }
  
  /**
   * Access whether this guest has any dietary restrictions or not
   * @return true for guests constructed using new Guest(String), false otherwise
   */
  public boolean hasDietaryRestriction() {//if there is a dietary restriction returns true false otherwise
    if(dietaryRestriction.equals("")) {
    return false;
    }
    return true;
  }
  
  /**
   * The string representation of a Guest should be formatted as, for examples:
   * #3(no dairy)
   * for a guest with a guest index of 3 and the dietary restriction of "no dairy", or: 
   * #4
   * for a guest with a guest index of 4 and no dietary restriction
   * @return string representing the guest index and any dietary restriction they might have
   * @see java.lang.Object#toString()
   */
  public String toString() {//converts the guest to string format #3(no fish)
    String retValue;
    if(hasDietaryRestriction()) {
    retValue = "#" + index + "(" + dietaryRestriction + ")";//sets the return value to the wanted format
    }
    else {
      retValue = "#" + index;//if  no restrictions then just the index
    }
    return retValue;
  }
}

