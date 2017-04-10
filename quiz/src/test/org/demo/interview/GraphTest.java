package org.demo.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by ehabtaleb on 02/12/16.
 */
public class GraphTest{



  public GraphDFS.Node lca(GraphDFS.Node root, GraphDFS.Node p, GraphDFS.Node q){
    if(p == q) return p;
    List<GraphDFS.Node> path1 = findPath(root, p);
    List<GraphDFS.Node> path2 = findPath(root, q);
    GraphDFS.Node lastCommon = null;
    for (int i = 0; i < path1.size(); i++) {
      if(path1.get(i).id == path2.get(i).id){
        lastCommon = path1.get(i);
      }else{
        break;
      }
    }
    return lastCommon;
  }

  private List<GraphDFS.Node> findPath(GraphDFS.Node root, GraphDFS.Node p) {
    List<GraphDFS.Node> path = new ArrayList<>();
    List<GraphDFS.Node> localPath = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    findPath(root, p, localPath ,path, visited);
    return path;
  }

  private boolean findPath(GraphDFS.Node src, GraphDFS.Node p,
      List<GraphDFS.Node> localPath , List<GraphDFS.Node> path, HashSet<Integer> visited) {
    if(visited.contains(src)){
      return false;
    }
    localPath.add(src);
    visited.add(src.id);
    if(src == p){
      path.addAll(localPath);
      return true;
    }
    for (GraphDFS.Node child : src.adjacencyList){
      if(findPath(child, p,localPath, path, visited)){
        return true;
      }
    }
    return false;
  }

  public List<GraphDFS.Node> findShortestPathBFS(GraphDFS.Node src, GraphDFS.Node p){
    java.util.LinkedList<GraphDFS.Node> queue = new LinkedList<>();
    HashMap<GraphDFS.Node, GraphDFS.Node> parents = new HashMap<>();
    queue.add(src);
    parents.put(src, null);
    while(!queue.isEmpty()){
      GraphDFS.Node n = queue.remove();
      if(n == p) break;
      for (GraphDFS.Node child : n.adjacencyList){
        queue.add(child);
        parents.put(child, n);
      }
    }
    if(parents.get(p) == null) return null;
    LinkedList<GraphDFS.Node> result = new LinkedList<>();
    GraphDFS.Node node = parents.get(p);
    result.add(p);
    while(node != null){
      result.add(node);
      node = parents.get(node);
    }
    return result;
  }

  public Stack<GraphDFS.Node> findPathDFS(GraphDFS.Node root, GraphDFS.Node n){
    if(n == null) return null;

  }
}