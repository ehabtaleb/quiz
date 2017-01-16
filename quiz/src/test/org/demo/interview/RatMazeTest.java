package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ehabtaleb on 14/01/17.
 */
public class RatMazeTest {

  @Test
  public void shortestPathToCheese(){

    int maze[][] = {{1, 0, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 9, 0, 1, 1},
                    {1, 1, 1, 0, 1, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1}
    };

    Assert.assertThat(shortestPath(maze, 0, 0, 3, 4), Is.is(18));
  }

  private int shortestPath(int[][] maze, int row, int col, int endRow, int endCol) {
    if(!isValid(maze, row, col)){
      return 1000000;
    }

    if(maze[row][col] == 9) {
      return 1;
    }

    maze[row][col] = -2;
    int min = shortestPath(maze, row -1, col, endRow, endCol);
    min = Math.min(min, shortestPath(maze, row, col-1, endRow, endCol));
    min = Math.min(min, shortestPath(maze, row+1, col, endRow, endCol));
    min = Math.min(min, shortestPath(maze, row, col+1, endRow, endCol));
    maze[row][col] = 1;
    return min+1;
  }

  private boolean isValid(int[][] maze, int row, int col) {
    if(row < 0 || col < 0 || row >= maze.length || col >= maze[row].length || maze[row][col] <= 0) {
      return false;
    }
    return true;
  }

}
