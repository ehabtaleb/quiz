package org.demo.interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  static void displayPathtoPrincess(int n, String[] arr) {
    int botStartRow = n / 2;
    int botStartCol = n / 2;
    String[][] maze = createMaze(n, arr);
    show(maze, n);
    List<String> minPath = new ArrayList<String>();
    findShortestPath( maze, botStartRow, botStartCol, minPath );
    show(minPath, n);
  }

  private static String[][] createMaze(int n, String[] grid) {
    String[][] maze = new String[n][n];
    for (int i = 0; i < grid.length; i++) {
      int row = i / n;
      int col = i % n;
      maze[row][col] = grid[i];
    }
    return maze;
  }

  private static boolean findShortestPath(  String[][] grid, int row, int col, List<String> sol){

    if(!valid(grid, row, col)){
      return false;// no path
    }
    if("p".equals(grid[row][col])){// found princess
      return true;
    }
    String org = grid[row][col];
    grid[row][col] = "x";

    if(findShortestPath(grid, row + 1, col, sol)){
      sol.add("DOWN");
      return true;
    }

    if(findShortestPath( grid, row -1, col, sol )) {
      sol.add("UP");
      return true;
    }

    if(findShortestPath( grid, row, col+1 , sol )) {
      sol.add("RIGHT");
      return true;
    }

    if(findShortestPath( grid, row, col-1 , sol )) {
      sol.add("LEFT");
      return true;
    }
    grid[row][col] = org;
    return false;
  }
  private static boolean valid(String[][] grid, int row, int col){
    if(row >= grid.length || row < 0 || col >= grid[row].length || col < 0 ){
      return false;
    }
    if(grid[row][col].equals("x")){
      return false;
    }
    return true;
  }

  private static void show(List<String> path, int n){
    if(path != null){
      for (int i = 0; i < path.size(); i++){
          System.out.print(path.get(i) + " ");
      }
      System.out.println();
    }
  }

  private static void show(String[][] path, int n){
    if(path != null){
      for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++) {
          System.out.print(path[i][j] + " ");
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m;
    m = in.nextInt();
    String grid[] = new String[m];
    for(int i = 0; i < m; i++) {
      grid[i] = in.next();
    }

    displayPathtoPrincess(m,grid);
  }
}
