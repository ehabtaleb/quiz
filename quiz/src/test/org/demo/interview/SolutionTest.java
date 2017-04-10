package org.demo.interview;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 03/02/17.
 */
public class SolutionTest {

  @Test public void testDisplayPathtoPrincess() throws Exception {

    String[] grid = new String[]{"p","-","-","-","m","-","-","-","-"};

    Solution.displayPathtoPrincess(3, grid);
  }
}