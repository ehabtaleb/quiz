package org.demo.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by ehabtaleb on 11/02/17.
 * Non binary tree Depth first search
 * in a binary tree there is no adjacency list since there are only 2 children
 * so return hasPath(leftChild) || hasPath(rightChild)
 *
 */
public class GraphDFS {

  private static final int EDGE_DIST = 6;
  private Node[] nodes;

   public static class Node {
    int id;
    LinkedList<Node> adjacencyList = new LinkedList();
    int rate;
  }

  /**
   * BFS shortest path
   * 
   * @param src stat Node
   * @param n number of nodes in graph
   * @return int[] distances
   */
  public static int[] shortestPath(Node src, int n) {
    int[] distances = new int[n];
    Arrays.fill(distances, -1);
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(src);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      for (Node child : node.adjacencyList) {
        if (distances[child.id] == -1) {
          distances[child.id] = distances[node.id] + EDGE_DIST;
          queue.add(child);
        }
      }
    }
    return distances;
  }

  /**
   * DFS is a recursive algorithm but we need visited set
   *
   * @param src
   * @param dest
   * @return
   */
  public static boolean hasPathDFS(Node src, Node dest) {
    HashMap<Integer, Node> visited = new HashMap<>();
    return hasPathDFSRecursive(src, dest, visited);
  }

  /**
   * BFS we need a queue to add nodes in the same level first before checking children
   *
   * @param src
   * @param dest
   * @return
   */
  public static boolean hasPathBFS(Node src, Node dest){
    LinkedList<Node> queue = new LinkedList<>();
    HashMap<Integer, Node> visited = new HashMap<>();
    queue.add(src);

    while(!queue.isEmpty()){
      Node n = queue.remove();
      if(visited.containsKey(n.id)){
        continue;
      }
      visited.put(n.id, n);
      if(n == dest) return true;
      for (Node child : n.adjacencyList){
        queue.add(child);
      }
    }
    return false;
  }

  public static int minStepsDFS(Node src, Node dest) {
    HashMap<Integer, Node> visited = new HashMap<>();
    return minPathDFSRecursive(src, dest, visited);
  }

  private static int minPathDFSRecursive(Node src, Node dest, HashMap<Integer, Node> visited) {
    if (visited.containsKey(src.id)){
      return 10000000;
    }
    visited.put(src.id, src);
    if(src.equals(dest)){
      return 1;
    }
    int min = 1000000;
    for(Node t: src.adjacencyList){
      int minLocal = minPathDFSRecursive(t, dest, visited);
      if(minLocal < min){
        min = minLocal;
      }
    }
    return min+1;
  }

  private static boolean hasPathDFSRecursive(Node n, Node dest, HashMap<Integer, Node> visited) {
    if (visited.containsKey(n.id)) {
      return false;
    }
    visited.put(n.id, n);
    if (n == dest) {
      return true;
    }
    for (Node t : n.adjacencyList) {
      if (hasPathDFSRecursive(t, dest, visited)) {
        return true;
      }
    }
    return false;
  }


  /**
   * it is much faster to use a BFS search from Node p to Node q
   *
   * @param p
   * @param q
   * @return
   */
  public boolean pathExistsIterative(Node p, Node q) {
    LinkedList<Node> queue = new LinkedList<>();
    HashSet<Node> visited = new HashSet<>();
    queue.add(p);

    while (!queue.isEmpty()) {
      Node n = queue.remove();
      if (visited.contains(n)) continue;
      visited.add(n);
      if (n == q) return true;
      for (Node child : n.adjacencyList) {
        queue.add(child);
      }
    }
    return false;
  }

}
