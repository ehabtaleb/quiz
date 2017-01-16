package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by ehabtaleb on 15/01/17.
 */
public class ScoreGathering {

  @Test
  public void testScoreGathering() {
    int[] score = new int[] { 4, 2, 5, 5, 6, 1, 4 };
    Assert.assertThat(gatherScore(score), Is.is("4:2,2:1,5:2,1:1,,,6:1"));
  }

  private String gatherScore(int[] score) {
    if (score == null || score.length < 1) {
      return "";
    }
    Tree<ScoreGathering.Node> bst = new EmptyTree<>();
    for (int i = 0; i < score.length; i++) {

      Node node = new Node(score[i]);
      bst = bst.add(node);

    }
    return bst.serialize();
  }

  public class Node {
    public int score;
    public int freq;

    public Node(int data) {
      this.score = data;
      this.freq = 1;
    }

    public Node(int data, int f) {
      this.score = data;
      this.freq = f;
    }

    @Override
    public String toString() {
      if (score == 0) {
        return "";
      }
      return score + ":" + freq;
    }
  }

  interface Tree<D extends Node> {

    BST<D> add(D node);

    String serialize();

    boolean isEmpty();

    D root();

    Node[] getChilds(D node);
  }

  class EmptyTree<Node> implements Tree<ScoreGathering.Node> {

    @Override
    public BST add(ScoreGathering.Node node) {
      return new BST<>(node, new EmptyTree<>(), new EmptyTree<>());
    }

    @Override
    public String serialize() {
      return "";
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public ScoreGathering.Node root() {
      return null;
    }

    @Override
    public ScoreGathering.Node[] getChilds(ScoreGathering.Node node) {
      return null;
    }
  }

  class BST<Node> implements Tree {
    ScoreGathering.Node root;
    Tree<ScoreGathering.Node> leftTree;
    Tree<ScoreGathering.Node> rightTree;

    public BST(ScoreGathering.Node node, Tree left, Tree right) {
      this.root = node;
      this.leftTree = left;
      this.rightTree = right;
    }

    @Override
    public BST add(ScoreGathering.Node node) {
      if (root.score == node.score) {
        root.freq += 1;
        return this;
      }
      if (root.score > node.score) {
        leftTree = leftTree.add(node);
        return this;
      }
      rightTree = rightTree.add(node);
      return this;
    }

    // BFS traverse serialize
    @Override
    public String serialize() {
      if (this.root == null) {
        return "";
      }
      LinkedList<ScoreGathering.Node> queue = new LinkedList<>();
      LinkedList<ScoreGathering.Node> visited = new LinkedList<>();

      queue.add(root);
      StringBuilder buff = new StringBuilder("");
      while (!queue.isEmpty()) {
        ScoreGathering.Node node = queue.poll();
        if (visited.contains(node)) {
          continue;
        }
        buff.append(node.toString()).append(",");
        visited.add(node);
        ScoreGathering.Node[] childs = this.getChilds(node);
        if (childs != null) {
          queue.add(childs[0]);
          queue.add(childs[1]);
        }
      }
      buff.deleteCharAt(buff.length() - 1);
      return buff.toString();
    }

    public ScoreGathering.Node EMPTYNode = new ScoreGathering.Node(0, 0);

    public ScoreGathering.Node[] getChilds(ScoreGathering.Node node) {
      if (leftTree.isEmpty() && rightTree.isEmpty()) {
        return null;
      }
      ScoreGathering.Node[] childs = new ScoreGathering.Node[2];
      if (root.score == node.score) {
        if (leftTree.isEmpty()) {
          childs[0] = EMPTYNode;
        } else {
          childs[0] = leftTree.root();
        }
        if (rightTree.isEmpty()) {
          childs[1] = EMPTYNode;
        } else {
          childs[1] = rightTree.root();
        }
        return childs;
      }
      if (root.score > node.score) {
        return leftTree.getChilds(node);
      }
      return rightTree.getChilds(node);
    }

    @Override
    public boolean isEmpty() {
      return this.root == null;
    }

    @Override
    public ScoreGathering.Node root() {
      return this.root;
    }
  }
}
