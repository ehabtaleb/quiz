package org.demo.interview;

import static java.lang.Math.*;

public class Matrix {

  public static int nPath(int[][] maze , int startRow, int startCol){
    if(!validSquare(maze, startRow, startCol)){
      return 0;
    }
   /* if(atTarget(maze, startRow, startCol)){
      return 1;
    }*/

    int sum =  nPath(maze, startRow+1, startCol)+ nPath(maze, startRow, startCol+1) + 1;
    System.out.println("sum = " + sum);
    return sum;
  }

  private static boolean atTarget(int[][] maze, int row, int col, int endRow, int endCol) {
    if(row == endRow && col == endCol){
      return true;
    }
    return false;
  }

  private static boolean validSquare(int[][] maze, int row, int col) {
    if(row < 0 || col < 0 || row >= maze.length || col >= maze[row].length || maze[row][col] < 1){
      return false;
    }
    return true;
  }

  public static int minPath(int[][] grid, int row, int col, int endRow, int endCol) {
    //System.out.println(String.format("row %d , col %d" , row, col));
    if (atTarget(grid, row, col, endRow, endCol)) {
      return 1;
    }

    if (!validSquare(grid, row, col)) {
      return 1000000;
    }


    grid[row][col] = -2;
    int allMin = 0;
     allMin = minPath(grid, row + 1, col, endRow, endCol)+1;
    System.out.println("allMin = " + allMin);
    int min = minPath(grid, row - 1, col, endRow, endCol)+1;
    if(min < allMin){
      allMin = min;
    }
    System.out.println("allMin = " + allMin);
    min = minPath(grid, row, col + 1, endRow, endCol)+1;
    if(min < allMin){
      allMin = min;
    }
    System.out.println("allMin = " + allMin);
    min =  minPath(grid, row, col - 1, endRow, endCol)+1;
    if(min < allMin){
      allMin = min;
    }
    System.out.println("allMin = " + allMin);
    grid[row][col] = 1;
    return allMin;
  }

  public static int minSteps(int[][] maze, int row, int col, int endRow,
      int endCol) {
    if(!isValidSquare(maze, row, col,  endRow, endCol)){
      return 1000000000;
    }
    if(maze[row][col] == 9){
      return 1;
    }

    maze[row][col] = -2;
    int minSteps = minSteps(maze, row+1, col, endRow, endCol);
    minSteps = Math.min(minSteps, minSteps(maze, row-1, col, endRow, endCol));
    minSteps = Math.min(minSteps, minSteps(maze, row, col-1, endRow, endCol));
    minSteps = Math.min(minSteps, minSteps(maze, row, col+1 , endRow, endCol));
    maze[row][col] = 1;
    return minSteps+1;
  }

  private static boolean isValidSquare(int[][] maze, int row, int col, int endRow,
      int endCol) {
    if(row < 0 || col < 0 || row > endRow || col > endCol || maze[row][col] < 1){
      return false;
    }
    return true;
  }
}
