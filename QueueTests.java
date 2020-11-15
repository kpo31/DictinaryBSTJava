//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (QueueTests.java)
// Files:           (Guest.java, ServingQueue.java, DessertSolvers.java, QueueTests.java)
// Course:          (Spring 2019)
//
// Author:          (Mihir Khatri)
// Email:           (mkhatri@wisc.edu)
// Lecturer's Name: (Mouna Kacem)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    ((name of your pair programming partner)
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
public class QueueTests {
/**
 * test the add method
 * @return - true if passed false otherwise
 */
  public static boolean testAdd() {
    Guest guest1 = new Guest();
    Guest guest2 = new Guest("no fish");
    Guest guest3 = new Guest("no meat");
    Guest guest4 = new Guest();
    Guest guest5 = new Guest();//make new guests to add 
    ServingQueue queue = new ServingQueue(5);//make queue to add guests into
    queue.add(guest1);
    queue.add(guest2);
    queue.add(guest3);
    queue.add(guest4);
    queue.add(guest5);//adds guests to queue


    if (queue.toString().equals("[#1, #2(no fish), #3(no meat), #4, #5]")) {//expected output
      System.out.println("Test Add Passed");
      return true;
    }
    return false;
  }
/**
 * checks the remove method
 * @return - true if passed false otherwise
 */
  public static boolean testRemove() {
    Guest guest1 = new Guest();
    Guest guest2 = new Guest("no fish");
    Guest guest3 = new Guest("no meat");
    Guest guest4 = new Guest();
    Guest guest5 = new Guest();//make new guests to add 
    ServingQueue queue = new ServingQueue(5);//make queue to add guests into
    queue.add(guest1);
    queue.add(guest2);
    queue.add(guest3);
    queue.add(guest4);
    queue.add(guest5);
    queue.remove();
    queue.remove();
    queue.remove();
    queue.remove();
    queue.remove();//remove all the guests

    if (queue.toString().equals("[]")) {//expected output
      System.out.println("test Remove passed");
      return true;
    }
    return false;
  }
  /**
   * tests the isEmpty method
   * @return - true if passed false otherwise
   */
  public static boolean testIsEmpty() {
    Guest guest1 = new Guest();
    Guest guest2 = new Guest("no fish");
    Guest guest3 = new Guest("no meat");
    Guest guest4 = new Guest();
    Guest guest5 = new Guest();//make new guests to add 
    ServingQueue queue = new ServingQueue(5);//make queue to add guests into
    queue.add(guest1);
    queue.add(guest2);
    queue.add(guest3);
    queue.add(guest4);
    queue.add(guest5);
    queue.remove();
    queue.remove();
    queue.remove();
    queue.remove();
    queue.remove();//remove all the guests
    
    if(queue.isEmpty()) {//expected output is empty list
      System.out.println("test isEmpty passed");
      return true;
    }
    return false;
  }
/**
 * main method for the queueTests class
 * @param args
 */
  public static void main(String[] args) {
    testAdd();
    testRemove();
    testIsEmpty();
  }
}
