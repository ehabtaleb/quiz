package org.demo.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ehabtaleb on 07/11/16.
 */
public class Maze {


    public static boolean isPath(int[][] matrix, int ROWS, int COLS, int row, int col) {
      if(matrix[row][col] == 9){
        return true;
      }

      // visit this path
      matrix[row][col] = 2;
      boolean exist = false;

      // right
      if(!exist && col+ 1 < COLS && (matrix[row][col+1] == 1 || matrix[row][col+1] == 9)) {
        exist = isPath(matrix, ROWS, COLS, row, col+1);
      }


      // down
      if(!exist && row+1 < ROWS && (matrix[row+1][col] == 1 || matrix[row+1][col] == 9)) {
        exist = isPath(matrix, ROWS, COLS, row+1, col);
      }


      // left
      if(!exist && col-1 >=0 && (matrix[row][col-1] == 1 || matrix[row][col-1] == 9)) {
        exist = isPath(matrix, ROWS, COLS, row, col-1);
      }

      // top
      if(!exist && row-1 >=0 && (matrix[row-1][col] == 1 || matrix[row-1][col] == 9)) {
        exist = isPath(matrix, ROWS, COLS, row-1, col);
      }

      // un-visit this path
      matrix[row][col] = 1;
      return exist;
    }

    public static void main(String[] args) {
      Maze mcr = new Maze();

      int matrix[][] = {{1, 0, 1, 1, 1, 0, 0, 1},
          {1, 0, 0, 0, 1, 1, 1, 1},
          {1, 0, 0, 0, 0, 0, 0, 0},
          {1, 0, 1, 0, 9, 0, 1, 1},
          {1, 1, 1, 0, 1, 0, 0, 1},
          {1, 0, 1, 0, 1, 1, 0, 1},
          {1, 0, 0, 0, 0, 1, 0, 1},
          {1, 1, 1, 1, 1, 1, 1, 1}};


      System.out.println(mcr.isPath(matrix, matrix.length, matrix[0].length, 0, 0));
    }


  public static List<String> listAllPath(int[][] grid) {
    ArrayList<String> paths = new ArrayList<>();
    int len = grid.length - 1;
    findPaths(grid, len, 0, 0, "", "", paths);
    return paths;
  }

  private static void findPaths(int[][] grid, int len, int row, int col,
     String step , String path, ArrayList<String> paths) {

    if (row < 0 || col < 0 || row > len || col > len) {
      // bad path
      return;
    }
    path += step+", ";
    if (row == len && col == len) { // found a path add it to list
      paths.add(path);
      return;
    }

    findPaths(grid, len, row + 1, col, "Right", path , paths);
    findPaths(grid, len, row, col + 1, "Down", path, paths);
  }
}
