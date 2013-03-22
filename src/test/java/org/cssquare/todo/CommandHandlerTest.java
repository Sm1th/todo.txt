package org.cssquare.todo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

import org.cssquare.todo.CommandHandler;
import org.cssquare.todo.CommandResult;
import org.cssquare.todo.Task;

public class CommandHandlerTest extends TestCase {

  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public CommandHandlerTest( String testName )
  {
    super( testName );
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
    return new TestSuite( CommandHandlerTest.class );
  }

  public void testAddingNewTask() {
    String[] arguments = new String[] { "add", "Sleep" };
    ArrayList<Task> emptyTaskList = new ArrayList<Task>();

     CommandResult result =
       CommandHandler.dispatch(arguments, emptyTaskList);

     assertEquals(result.getTaskList().size(), 1);
  }

  public void testAddingBlankTask() {
    String[] arguments = new String[] { "add" };
    ArrayList<Task> emptyTaskList = new ArrayList<Task>();

    try {
      CommandResult result =
        CommandHandler.dispatch(arguments, emptyTaskList);
    }
    catch (Exception e) {
      assertTrue(e.getMessage(), true);
    }
    fail();
  }

}
