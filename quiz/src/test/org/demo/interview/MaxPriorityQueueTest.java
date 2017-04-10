package org.demo.interview;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 02/02/17.
 */
public class MaxPriorityQueueTest {

  @Test public void testDeleteMax() throws Exception {

    MaxPriorityQueue<Integer> maxQueue = new MaxPriorityQueue<>(10);

    maxQueue.insert(1);
    maxQueue.insert(3);
    maxQueue.insert(5);
    maxQueue.insert(15);
    maxQueue.insert(11);
    maxQueue.insert(7);
    maxQueue.insert(8);
    maxQueue.insert(10);
    maxQueue.insert(2);
    maxQueue.show();
    maxQueue.deleteMax();
    maxQueue.show();

  }
}