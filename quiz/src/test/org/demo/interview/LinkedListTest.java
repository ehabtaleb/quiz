package org.demo.interview;

import org.junit.Test;

/**
 * Created by ehabtaleb on 07/03/17.
 */
public class LinkedListTest {

  @Test
  public void testReverse(){
    LinkedList.Node head = new LinkedList.Node(1);
    head.add(new LinkedList.Node(2)).add(new LinkedList.Node(3)).add(new LinkedList.Node(4));

    LinkedList.Node reversed = LinkedList.reverse(head);
    LinkedList.print(reversed);
  }
}
