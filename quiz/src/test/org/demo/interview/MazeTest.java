package org.demo.interview;

import junit.framework.TestCase;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 07/11/16.
 */
public class MazeTest {

  public void testIsPath() throws Exception {
    int matrix[][] = {{1, 0, 1, 1, 1, 0, 0, 1},
                      {1, 0, 0, 0, 1, 1, 1, 1},
                      {1, 0, 0, 0, 0, 0, 0, 0},
                      {1, 0, 1, 0, 9, 0, 1, 1},
                      {1, 1, 1, 0, 1, 0, 0, 1},
                      {1, 0, 1, 0, 1, 1, 0, 1},
                      {1, 0, 0, 0, 0, 1, 0, 1},
                      {1, 1, 1, 1, 1, 1, 1, 1}};

    assertThat(Maze.isPath(matrix, matrix.length, matrix[0].length, 0, 0),
        Is.is(true));
  }


  @Test
  public void testShortestNSteps6(){
    int grid[][] = {{1, 0, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 0, 0, 1, 1},
                    {1, 1, 9, 0, 1, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1}};

    assertThat(Matrix.minSteps(grid, 0, 0, 4, 2), Is.is(7));
  }

  @Test
  public void testShortestPath(){
    int grid[][] = {{1, 0, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 0, 0, 1, 1},
                    {1, 1, 1, 0, 1, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 1},
                    {1, 9, 1, 1, 1, 1, 1, 1}};

    assertThat(Matrix.minSteps(grid, 0, 0, 7, 1), Is.is(9));
  }
}