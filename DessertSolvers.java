//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (DessertSolvers.java)
// Files: (Guest.java, ServingQueue.java, DessertSolvers.java, QueueTests.java)
// Course: (Spring 2019)
//
// Author: (Mihir Khatri)
// Email: (mkhatri@wisc.edu)
// Lecturer's Name: (Mouna Kacem)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class DessertSolvers {

  /**
   * adds guests to the queue and skips them according to the input of the user
   * 
   * @param numberOfGuests - the number of guests to add
   * @param guestsSkipped  - number of guests to be skipped
   * @return - the last guest served
   */
  public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped) {
    int count = 0;
    Guest retValue = null;
    ServingQueue queue = new ServingQueue(numberOfGuests);
    if (numberOfGuests <= 0) {// checks for the given conditions
      throw new IllegalArgumentException("ERROR: Number of guests cannot be less than zero");
    }
    if (guestsSkipped < 0) {
      throw new IllegalArgumentException("ERROR: Guests skipped cannot be less than zero");
    }
    for (int i = 0; i < numberOfGuests; i++) {// adds guests for the required number
      queue.add(new Guest());
      count++;
    }

    for (int i = 0; i < numberOfGuests; i++) {// removes the guest once served
      retValue = queue.remove();
      for (int j = 0; j < guestsSkipped; j++) {// if the guest is to be skipped removed and then
                                               // added again after checking for isEmpty
        if (queue.isEmpty()) {
          break;
        }
        queue.add(queue.remove());

      }
    }

    return retValue;
  }

  /**
   * adds guests to queue and serves them for wanted number of courses in the pattern wanted
   * 
   * @param numberOfGuests - number of guests to add
   * @param coursesServed  - the number of guests served
   * @return - reference to the guest that is served last in the second to last course
   */
  public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed) {
    Guest.resetNextGuestIndex();//to clear any confusion with previous indices
    if (numberOfGuests <= 0) {// checks for the required conditions
      throw new IllegalArgumentException("ERROR: number of guests must be positive");
    }
    if (coursesServed <= 0) {
      throw new IllegalArgumentException("ERROR: courses served has to be positive");
    }
    Guest retValue[] = new Guest[numberOfGuests];// for the guest to be returned
    ServingQueue queue = new ServingQueue(numberOfGuests);// need two queues to add and remove
                                                          // according to the courses served
    ServingQueue queue2 = new ServingQueue(numberOfGuests);

    for (int i = 0; i < numberOfGuests; i++) {
      retValue[i] = new Guest();// makes new guest
    }
    while (coursesServed > 0) {// if we want to serve positive courses
      try {

        for (int j = 0; j < numberOfGuests; j++) {
          queue2.add(retValue[j]);// adds to the second queue
        }

        for (int k = 0; k < numberOfGuests; k++) {
          queue.add(queue2.remove());// adds the person removed from the second queue back to the
                                     // first queue
          if (queue2.isEmpty()) {
            break;// if empty break
          }
          queue2.add(queue2.remove());// skip one
        }
        for (int i = 0; i < numberOfGuests; i++) {
          retValue[(i + 1) % numberOfGuests] = queue.remove();// adds with last person at front
        }
        coursesServed--;
      } catch (IndexOutOfBoundsException e) {
        System.out.println("IllegalStateException");
      }
    }
    return retValue[1];// wanted return value
  }
}
