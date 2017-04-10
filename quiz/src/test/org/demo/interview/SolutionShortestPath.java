package org.demo.interview;

/**
 * Created by ehabtaleb on 25/02/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionShortestPath {
  public static class Graph {

    public static class Node{
      int id;
      Set<Node> adjacencyList = new HashSet<>();
      public Node(int i){
        this.id = i;
      }

      @Override public String toString() {
        StringBuilder sb = new StringBuilder(id+"-->");
        for (Node n : adjacencyList) {
          sb.append(n.id).append(",");
        }
          sb.append("\n");
        return sb.toString();
      }
    }

    private Node[] nodes;

    public Graph(int size) {
      nodes = new Node[size];
    }
    private Node getNode(int idx){
      if(nodes[idx] == null){
        nodes[idx] = new Node(idx);
      }
      return nodes[idx];
    }
    public void addEdge(int first, int second) {
      Node u = getNode(first);
      Node v = getNode(second);
      u.adjacencyList.add(v);
    }

    public int[] shortestReach(int startId) { // 0 indexed
      int[] dist = new int[nodes.length];
      Arrays.fill(dist, -1);
      Sorting.printArray(nodes);
      LinkedList<Node> queue = new LinkedList();
      Node start = getNode(startId);
      dist[startId] = 0;
      queue.add(start);
      while(!queue.isEmpty()){
        Node n = queue.remove();
          for(Node c: n.adjacencyList){
            if(dist[c.id] == -1){
              dist[c.id] = dist[n.id] + 6;
              //Sorting.printArray(dist);
              queue.add(c);
            }
        }
      }
      return dist;
    }
  }
  public static void main(String[] args) {
    String input = "1\n" + "70 1988\n" + "30 32\n" + "50 9\n" + "7 58\n"
        + "50 66\n" + "38 13\n" + "31 67\n" + "2 30\n" + "14 46\n" + "54 34\n"
        + "10 7\n" + "25 66\n" + "20 18\n" + "1 21\n" + "49 63\n" + "39 20\n"
        + "55 5\n" + "3 66\n" + "58 34\n" + "19 12\n" + "43 62\n" + "16 1\n"
        + "10 11\n" + "16 70\n" + "11 35\n" + "22 13\n" + "16 2\n" + "59 41\n"
        + "29 45\n" + "53 47\n" + "43 59\n" + "46 32\n" + "64 65\n" + "70 11\n"
        + "4 11\n" + "69 10\n" + "21 41\n" + "17 56\n" + "49 63\n" + "27 50\n"
        + "30 23\n" + "49 19\n" + "45 46\n" + "1 64\n" + "67 58\n" + "37 38\n"
        + "33 68\n" + "55 67\n" + "35 5\n" + "70 44\n" + "14 26\n" + "50 17\n"
        + "4 10\n" + "43 7\n" + "15 44\n" + "2 50\n" + "64 28\n" + "8 19\n"
        + "7 31\n" + "30 3\n" + "36 59\n" + "36 57\n" + "27 60\n" + "54 28\n"
        + "26 69\n" + "57 54\n" + "49 20\n" + "66 9\n" + "44 41\n" + "22 5\n"
        + "46 10\n" + "54 19\n" + "13 3\n" + "13 2\n" + "49 1\n" + "34 29\n"
        + "68 50\n" + "3 27\n" + "3 2\n" + "57 60\n" + "3 59\n" + "42 55\n"
        + "66 55\n" + "24 7\n" + "2 48\n" + "14 62\n" + "48 38\n" + "22 10\n"
        + "12 19\n" + "1 46\n" + "49 48\n" + "31 56\n" + "5 15\n" + "45 67\n"
        + "35 43\n" + "66 47\n" + "63 20\n" + "38 57\n" + "70 32\n" + "20 25\n"
        + "46 16\n" + "32 15\n" + "39 24\n" + "5 10\n" + "1 64\n" + "59 52\n"
        + "45 33\n" + "43 21\n" + "61 50\n" + "31 10\n" + "69 63\n" + "49 26\n"
        + "3 21\n" + "43 44\n" + "8 68\n" + "68 51\n" + "54 30\n" + "46 70\n"
        + "7 9\n" + "42 51\n" + "63 39\n" + "52 59\n" + "2 23\n" + "37 12\n"
        + "46 38\n" + "55 15\n" + "48 39\n" + "1 8\n" + "40 20\n" + "24 69\n"
        + "10 40\n" + "1 3\n" + "24 45\n" + "23 43\n" + "31 7\n" + "55 28\n"
        + "4 46\n" + "18 12\n" + "63 6\n" + "65 10\n" + "32 1\n" + "16 36\n"
        + "1 28\n" + "54 62\n" + "70 46\n" + "26 20\n" + "57 29\n" + "7 69\n"
        + "37 69\n" + "29 24\n" + "66 23\n" + "15 17\n" + "13 35\n" + "19 8\n"
        + "35 14\n" + "53 13\n" + "37 69\n" + "33 51\n" + "49 62\n" + "50 36\n"
        + "70 45\n" + "51 67\n" + "22 42\n" + "17 69\n" + "64 11\n" + "61 23\n"
        + "55 59\n" + "28 12\n" + "46 13\n" + "53 26\n" + "39 11\n" + "35 48\n"
        + "35 23\n" + "63 64\n" + "21 28\n" + "11 51\n" + "18 10\n" + "55 68\n"
        + "34 49\n" + "28 69\n" + "55 9\n" + "63 52\n" + "41 19\n" + "23 5\n"
        + "10 42\n" + "70 1\n" + "57 1\n" + "1 17\n" + "66 42\n" + "4 28\n"
        + "46 5\n" + "14 54\n" + "34 70\n" + "32 27\n" + "27 28\n" + "53 28\n"
        + "58 7\n" + "24 70\n" + "16 13\n" + "6 40\n" + "19 24\n" + "55 24\n"
        + "3 60\n" + "34 56\n" + "12 10\n" + "7 64\n" + "54 55\n" + "69 15\n"
        + "36 58\n" + "39 59\n" + "31 5\n" + "43 52\n" + "29 44\n" + "44 66\n"
        + "13 65\n" + "46 70\n" + "46 9\n" + "38 64\n" + "2 26\n" + "47 28\n"
        + "28 8\n" + "33 27\n" + "6 14\n" + "70 55\n" + "2 63\n" + "19 64\n"
        + "19 68\n" + "64 63\n" + "60 46\n" + "1 43\n" + "40 50\n" + "15 47\n"
        + "31 11\n" + "23 53\n" + "55 18\n" + "41 1\n" + "34 58\n" + "2 5\n"
        + "51 11\n" + "19 46\n" + "36 50\n" + "59 67\n" + "38 14\n" + "32 6\n"
        + "69 16\n" + "28 42\n" + "60 33\n" + "7 35\n" + "40 44\n" + "70 9\n"
        + "3 65\n" + "60 8\n" + "1 63\n" + "14 51\n" + "57 61\n" + "43 25\n"
        + "51 13\n" + "56 18\n" + "34 28\n" + "43 60\n" + "6 4\n" + "25 41\n"
        + "21 1\n" + "50 38\n" + "57 23\n" + "1 45\n" + "61 49\n" + "27 7\n"
        + "32 68\n" + "52 1\n" + "70 34\n" + "54 34\n" + "48 5\n" + "51 39\n"
        + "16 20\n" + "65 5\n" + "46 50\n" + "4 44\n" + "39 62\n" + "1 12\n"
        + "50 17\n" + "21 10\n" + "54 38\n" + "44 28\n" + "2 47\n" + "23 19\n"
        + "2 10\n" + "67 18\n" + "60 20\n" + "4 65\n" + "12 23\n" + "39 58\n"
        + "9 40\n" + "18 8\n" + "63 43\n" + "22 23\n" + "36 65\n" + "53 63\n"
        + "66 26\n" + "59 63\n" + "22 5\n" + "11 5\n" + "47 42\n" + "14 69\n"
        + "28 1\n" + "3 57\n" + "15 61\n" + "62 45\n" + "59 61\n" + "50 58\n"
        + "45 22\n" + "33 57\n" + "49 40\n" + "27 28\n" + "26 53\n" + "62 44\n"
        + "46 36\n" + "3 19\n" + "24 32\n" + "44 34\n" + "57 63\n" + "22 55\n"
        + "21 1\n" + "12 16\n" + "22 34\n" + "42 43\n" + "1 9\n" + "8 70\n"
        + "8 46\n" + "60 31\n" + "46 22\n" + "26 1\n" + "50 51\n" + "9 64\n"
        + "51 17\n" + "10 43\n" + "61 50\n" + "37 64\n" + "56 32\n" + "44 54\n"
        + "62 24\n" + "62 67\n" + "33 54\n" + "67 53\n" + "2 68\n" + "36 21\n"
        + "66 22\n" + "70 58\n" + "70 34\n" + "41 43\n" + "57 7\n" + "37 54\n"
        + "52 39\n" + "58 26\n" + "45 5\n" + "17 40\n" + "38 1\n" + "38 17\n"
        + "34 3\n" + "50 61\n" + "38 28\n" + "64 14\n" + "7 62\n" + "22 13\n"
        + "39 22\n" + "25 70\n" + "67 15\n" + "8 36\n" + "59 9\n" + "59 63\n"
        + "20 28\n" + "29 26\n" + "44 65\n" + "9 47\n" + "5 24\n" + "64 48\n"
        + "30 49\n" + "53 11\n" + "23 63\n" + "43 30\n" + "42 38\n" + "36 23\n"
        + "16 33\n" + "2 68\n" + "24 4\n" + "31 21\n" + "54 52\n" + "68 22\n"
        + "59 26\n" + "53 25\n" + "16 6\n" + "34 66\n" + "13 7\n" + "33 9\n"
        + "35 10\n" + "62 16\n" + "13 23\n" + "47 66\n" + "44 32\n" + "64 15\n"
        + "47 44\n" + "5 68\n" + "48 13\n" + "22 47\n" + "8 31\n" + "32 68\n"
        + "69 10\n" + "10 18\n" + "16 13\n" + "42 35\n" + "1 15\n" + "19 37\n"
        + "48 49\n" + "59 38\n" + "10 51\n" + "19 1\n" + "48 66\n" + "47 29\n"
        + "15 57\n" + "51 66\n" + "18 63\n" + "11 17\n" + "22 41\n" + "51 12\n"
        + "47 49\n" + "31 1\n" + "48 29\n" + "38 52\n" + "59 30\n" + "65 17\n"
        + "65 49\n" + "13 70\n" + "19 7\n" + "49 31\n" + "48 21\n" + "57 18\n"
        + "58 44\n" + "46 39\n" + "3 6\n" + "68 3\n" + "37 60\n" + "68 48\n"
        + "5 63\n" + "61 31\n" + "1 69\n" + "53 24\n" + "3 19\n" + "33 45\n"
        + "1 64\n" + "14 15\n" + "24 15\n" + "7 62\n" + "15 63\n" + "3 13\n"
        + "23 18\n" + "69 62\n" + "1 4\n" + "48 59\n" + "50 56\n" + "8 36\n"
        + "43 64\n" + "18 33\n" + "30 46\n" + "42 22\n" + "65 61\n" + "34 15\n"
        + "41 6\n" + "41 33\n" + "44 8\n" + "1 10\n" + "30 27\n" + "55 46\n"
        + "20 64\n" + "63 4\n" + "48 54\n" + "21 20\n" + "69 32\n" + "39 38\n"
        + "55 36\n" + "14 54\n" + "64 35\n" + "17 26\n" + "37 64\n" + "19 45\n"
        + "38 29\n" + "35 32\n" + "8 45\n" + "48 5\n" + "35 68\n" + "1 32\n"
        + "47 37\n" + "12 18\n" + "46 33\n" + "38 1\n" + "66 26\n" + "41 16\n"
        + "54 60\n" + "3 45\n" + "12 2\n" + "68 69\n" + "21 55\n" + "3 46\n"
        + "48 4\n" + "3 47\n" + "20 3\n" + "37 14\n" + "11 29\n" + "11 23\n"
        + "12 68\n" + "15 30\n" + "21 40\n" + "61 19\n" + "66 21\n" + "67 41\n"
        + "35 67\n" + "68 53\n" + "23 68\n" + "1 21\n" + "8 24\n" + "54 59\n"
        + "39 22\n" + "58 60\n" + "37 47\n" + "26 51\n" + "27 37\n" + "15 44\n"
        + "18 32\n" + "33 31\n" + "65 29\n" + "61 58\n" + "36 37\n" + "1 67\n"
        + "41 26\n" + "67 51\n" + "61 9\n" + "67 51\n" + "13 25\n" + "58 28\n"
        + "35 34\n" + "36 62\n" + "58 41\n" + "57 65\n" + "59 67\n" + "29 65\n"
        + "60 4\n" + "14 40\n" + "62 10\n" + "7 40\n" + "7 37\n" + "33 3\n"
        + "61 67\n" + "31 15\n" + "17 66\n" + "12 68\n" + "70 42\n" + "8 39\n"
        + "18 33\n" + "26 49\n" + "62 59\n" + "33 3\n" + "16 39\n" + "16 69\n"
        + "1 4\n" + "22 20\n" + "66 43\n" + "65 15\n" + "17 54\n" + "17 19\n"
        + "38 27\n" + "11 5\n" + "68 55\n" + "6 65\n" + "44 21\n" + "15 1\n"
        + "35 57\n" + "33 44\n" + "3 24\n" + "66 62\n" + "17 30\n" + "36 48\n"
        + "19 35\n" + "14 4\n" + "34 60\n" + "34 24\n" + "9 62\n" + "11 39\n"
        + "13 30\n" + "60 39\n" + "27 66\n" + "10 60\n" + "60 28\n" + "43 37\n"
        + "68 28\n" + "61 11\n" + "6 8\n" + "10 64\n" + "6 16\n" + "28 65\n"
        + "18 67\n" + "63 6\n" + "27 31\n" + "24 47\n" + "44 69\n" + "57 66\n"
        + "39 12\n" + "9 52\n" + "47 48\n" + "65 8\n" + "19 55\n" + "19 15\n"
        + "69 58\n" + "68 35\n" + "47 18\n" + "65 35\n" + "20 54\n" + "56 29\n"
        + "36 66\n" + "42 44\n" + "14 28\n" + "52 24\n" + "48 38\n" + "12 34\n"
        + "51 54\n" + "34 6\n" + "46 10\n" + "69 45\n" + "1 7\n" + "5 63\n"
        + "9 6\n" + "57 37\n" + "28 56\n" + "57 48\n" + "46 68\n" + "31 34\n"
        + "8 46\n" + "55 3\n" + "66 15\n" + "9 17\n" + "10 43\n" + "43 30\n"
        + "6 3\n" + "69 19\n" + "41 16\n" + "46 29\n" + "5 59\n" + "58 41\n"
        + "17 22\n" + "21 35\n" + "40 62\n" + "68 11\n" + "1 40\n" + "59 55\n"
        + "34 39\n" + "36 20\n" + "12 62\n" + "57 19\n" + "62 61\n" + "9 31\n"
        + "33 30\n" + "6 16\n" + "12 55\n" + "20 7\n" + "46 28\n" + "28 48\n"
        + "28 14\n" + "29 5\n" + "4 48\n" + "11 30\n" + "52 24\n" + "4 33\n"
        + "44 1\n" + "19 22\n" + "44 51\n" + "23 45\n" + "42 44\n" + "31 69\n"
        + "34 45\n" + "65 55\n" + "25 64\n" + "42 44\n" + "42 57\n" + "16 1\n"
        + "32 22\n" + "11 36\n" + "1 38\n" + "45 54\n" + "69 35\n" + "56 18\n"
        + "1 45\n" + "6 61\n" + "27 40\n" + "4 59\n" + "59 13\n" + "12 2\n"
        + "30 48\n" + "58 44\n" + "22 50\n" + "12 61\n" + "66 43\n" + "15 32\n"
        + "47 48\n" + "24 36\n" + "20 28\n" + "37 38\n" + "9 32\n" + "7 4\n"
        + "64 60\n" + "53 51\n" + "21 57\n" + "2 22\n" + "20 13\n" + "16 57\n"
        + "44 31\n" + "40 68\n" + "15 47\n" + "5 18\n" + "66 5\n" + "65 27\n"
        + "68 38\n" + "5 37\n" + "57 48\n" + "50 62\n" + "14 68\n" + "53 39\n"
        + "66 68\n" + "21 29\n" + "28 56\n" + "56 14\n" + "48 44\n" + "37 6\n"
        + "52 8\n" + "17 11\n" + "22 2\n" + "9 20\n" + "42 55\n" + "29 9\n"
        + "14 62\n" + "40 11\n" + "63 70\n" + "58 10\n" + "52 45\n" + "17 32\n"
        + "57 50\n" + "50 27\n" + "45 46\n" + "51 9\n" + "48 57\n" + "31 51\n"
        + "21 43\n" + "70 48\n" + "15 50\n" + "7 20\n" + "22 13\n" + "42 65\n"
        + "45 1\n" + "67 43\n" + "60 68\n" + "11 60\n" + "42 62\n" + "16 1\n"
        + "30 41\n" + "11 22\n" + "2 8\n" + "20 57\n" + "1 47\n" + "38 1\n"
        + "63 48\n" + "33 54\n" + "60 43\n" + "19 38\n" + "15 61\n" + "55 33\n"
        + "3 33\n" + "4 32\n" + "30 6\n" + "20 14\n" + "58 31\n" + "12 22\n"
        + "9 10\n" + "22 48\n" + "65 53\n" + "26 14\n" + "62 61\n" + "14 70\n"
        + "41 4\n" + "55 66\n" + "64 17\n" + "18 52\n" + "6 61\n" + "25 17\n"
        + "60 61\n" + "66 31\n" + "64 59\n" + "2 65\n" + "3 69\n" + "24 52\n"
        + "55 29\n" + "40 41\n" + "28 21\n" + "3 25\n" + "26 16\n" + "23 1\n"
        + "29 37\n" + "6 33\n" + "15 32\n" + "62 49\n" + "43 54\n" + "27 40\n"
        + "22 38\n" + "68 26\n" + "19 42\n" + "12 61\n" + "6 57\n" + "27 44\n"
        + "51 58\n" + "3 70\n" + "70 49\n" + "60 5\n" + "67 68\n" + "50 9\n"
        + "41 33\n" + "16 22\n" + "2 69\n" + "36 27\n" + "20 56\n" + "31 19\n"
        + "35 45\n" + "31 7\n" + "52 18\n" + "45 6\n" + "38 3\n" + "21 58\n"
        + "60 33\n" + "31 4\n" + "26 54\n" + "45 34\n" + "46 58\n" + "69 26\n"
        + "1 33\n" + "67 31\n" + "10 65\n" + "46 22\n" + "70 38\n" + "54 64\n"
        + "32 35\n" + "17 19\n" + "8 27\n" + "52 42\n" + "57 70\n" + "70 46\n"
        + "14 54\n" + "42 39\n" + "58 30\n" + "5 64\n" + "36 12\n" + "32 19\n"
        + "10 58\n" + "35 55\n" + "70 39\n" + "14 7\n" + "5 18\n" + "4 35\n"
        + "49 16\n" + "8 57\n" + "30 62\n" + "62 26\n" + "55 47\n" + "42 65\n"
        + "18 67\n" + "47 53\n" + "35 47\n" + "12 64\n" + "54 32\n" + "9 4\n"
        + "16 4\n" + "18 42\n" + "34 13\n" + "41 54\n" + "27 30\n" + "56 7\n"
        + "2 16\n" + "24 60\n" + "11 70\n" + "50 10\n" + "36 54\n" + "65 54\n"
        + "1 34\n" + "48 53\n" + "13 21\n" + "19 65\n" + "34 51\n" + "35 1\n"
        + "41 32\n" + "34 1\n" + "52 2\n" + "24 30\n" + "57 15\n" + "51 57\n"
        + "26 3\n" + "49 24\n" + "15 2\n" + "1 12\n" + "67 68\n" + "27 14\n"
        + "36 65\n" + "19 28\n" + "2 33\n" + "50 51\n" + "19 28\n" + "27 46\n"
        + "24 51\n" + "33 68\n" + "22 30\n" + "60 41\n" + "45 7\n" + "63 55\n"
        + "27 64\n" + "64 44\n" + "30 6\n" + "4 22\n" + "43 40\n" + "13 70\n"
        + "52 44\n" + "18 63\n" + "54 60\n" + "59 30\n" + "53 64\n" + "12 31\n"
        + "25 63\n" + "1 56\n" + "21 68\n" + "39 15\n" + "19 16\n" + "43 62\n"
        + "31 59\n" + "28 21\n" + "4 27\n" + "46 27\n" + "7 57\n" + "9 63\n"
        + "36 45\n" + "52 31\n" + "6 2\n" + "36 31\n" + "30 57\n" + "62 12\n"
        + "36 39\n" + "11 34\n" + "31 58\n" + "59 20\n" + "40 70\n" + "20 49\n"
        + "68 8\n" + "11 37\n" + "1 2\n" + "69 18\n" + "51 30\n" + "65 3\n"
        + "32 12\n" + "54 36\n" + "61 55\n" + "38 3\n" + "43 26\n" + "32 68\n"
        + "21 66\n" + "54 22\n" + "40 69\n" + "54 29\n" + "69 40\n" + "59 61\n"
        + "40 25\n" + "30 61\n" + "60 32\n" + "17 50\n" + "53 23\n" + "67 1\n"
        + "50 25\n" + "43 54\n" + "26 55\n" + "57 13\n" + "24 5\n" + "1 48\n"
        + "7 12\n" + "60 31\n" + "15 16\n" + "37 62\n" + "58 44\n" + "62 5\n"
        + "13 9\n" + "63 48\n" + "49 4\n" + "49 50\n" + "5 18\n" + "1 19\n"
        + "10 7\n" + "12 11\n" + "47 25\n" + "39 40\n" + "45 65\n" + "27 34\n"
        + "45 30\n" + "12 47\n" + "69 21\n" + "49 27\n" + "52 21\n" + "5 70\n"
        + "8 16\n" + "59 58\n" + "11 31\n" + "18 44\n" + "17 14\n" + "29 67\n"
        + "55 49\n" + "69 27\n" + "37 61\n" + "52 16\n" + "26 18\n" + "69 31\n"
        + "15 69\n" + "49 43\n" + "29 69\n" + "61 26\n" + "30 1\n" + "30 59\n"
        + "33 2\n" + "27 5\n" + "1 10\n" + "53 8\n" + "66 53\n" + "1 70\n"
        + "49 12\n" + "51 53\n" + "32 52\n" + "5 59\n" + "10 57\n" + "4 5\n"
        + "31 59\n" + "20 53\n" + "1 48\n" + "30 27\n" + "25 5\n" + "60 47\n"
        + "18 22\n" + "18 45\n" + "56 13\n" + "58 21\n" + "25 5\n" + "4 37\n"
        + "1 44\n" + "33 48\n" + "67 64\n" + "35 14\n" + "31 3\n" + "21 22\n"
        + "24 18\n" + "60 46\n" + "67 62\n" + "15 19\n" + "49 27\n" + "52 33\n"
        + "44 25\n" + "34 59\n" + "9 18\n" + "70 13\n" + "2 36\n" + "41 16\n"
        + "60 6\n" + "38 62\n" + "51 16\n" + "25 47\n" + "25 31\n" + "33 69\n"
        + "48 22\n" + "15 16\n" + "25 40\n" + "48 14\n" + "33 25\n" + "24 16\n"
        + "38 57\n" + "41 67\n" + "17 58\n" + "54 1\n" + "52 9\n" + "50 4\n"
        + "26 23\n" + "33 31\n" + "11 4\n" + "8 5\n" + "21 25\n" + "53 23\n"
        + "4 61\n" + "1 41\n" + "48 22\n" + "21 34\n" + "48 64\n" + "68 1\n"
        + "66 45\n" + "61 55\n" + "10 30\n" + "68 21\n" + "49 20\n" + "41 4\n"
        + "59 24\n" + "70 64\n" + "61 16\n" + "10 29\n" + "26 22\n" + "69 52\n"
        + "16 1\n" + "31 62\n" + "21 19\n" + "56 13\n" + "66 3\n" + "36 49\n"
        + "8 17\n" + "1 21\n" + "28 56\n" + "42 63\n" + "46 51\n" + "8 65\n"
        + "19 70\n" + "46 67\n" + "68 35\n" + "59 2\n" + "66 6\n" + "50 8\n"
        + "8 41\n" + "1 16\n" + "65 58\n" + "9 22\n" + "8 63\n" + "51 12\n"
        + "35 32\n" + "47 45\n" + "49 18\n" + "3 45\n" + "69 19\n" + "6 37\n"
        + "39 69\n" + "61 9\n" + "60 2\n" + "38 11\n" + "63 29\n" + "10 53\n"
        + "67 52\n" + "50 19\n" + "8 70\n" + "5 13\n" + "60 32\n" + "13 38\n"
        + "44 56\n" + "11 3\n" + "35 38\n" + "70 64\n" + "47 13\n" + "11 13\n"
        + "67 62\n" + "10 5\n" + "62 68\n" + "41 1\n" + "50 16\n" + "28 58\n"
        + "52 44\n" + "24 11\n" + "6 4\n" + "47 61\n" + "15 68\n" + "63 26\n"
        + "42 14\n" + "48 33\n" + "35 13\n" + "34 30\n" + "64 65\n" + "60 51\n"
        + "59 17\n" + "69 19\n" + "67 22\n" + "5 15\n" + "2 11\n" + "29 69\n"
        + "1 22\n" + "55 35\n" + "26 25\n" + "36 27\n" + "62 35\n" + "3 50\n"
        + "7 64\n" + "48 34\n" + "55 59\n" + "38 46\n" + "2 28\n" + "20 34\n"
        + "69 30\n" + "45 11\n" + "50 65\n" + "21 66\n" + "60 59\n" + "59 23\n"
        + "7 19\n" + "19 44\n" + "2 29\n" + "26 34\n" + "59 16\n" + "61 34\n"
        + "23 37\n" + "7 24\n" + "60 1\n" + "31 20\n" + "1 13\n" + "65 51\n"
        + "36 13\n" + "65 58\n" + "2 23\n" + "23 59\n" + "66 58\n" + "18 42\n"
        + "47 48\n" + "58 5\n" + "16 43\n" + "10 42\n" + "21 19\n" + "55 9\n"
        + "12 44\n" + "9 45\n" + "48 27\n" + "50 24\n" + "49 69\n" + "7 27\n"
        + "68 7\n" + "27 37\n" + "62 70\n" + "15 44\n" + "44 67\n" + "2 62\n"
        + "61 38\n" + "21 28\n" + "5 44\n" + "47 63\n" + "38 39\n" + "23 34\n"
        + "52 45\n" + "8 32\n" + "11 1\n" + "36 1\n" + "42 39\n" + "32 37\n"
        + "27 29\n" + "3 47\n" + "48 33\n" + "69 56\n" + "47 15\n" + "61 54\n"
        + "62 34\n" + "68 55\n" + "32 7\n" + "11 40\n" + "57 10\n" + "25 8\n"
        + "17 67\n" + "55 15\n" + "57 40\n" + "1 70\n" + "6 64\n" + "55 53\n"
        + "59 60\n" + "29 53\n" + "64 44\n" + "41 4\n" + "60 69\n" + "35 14\n"
        + "38 9\n" + "67 32\n" + "63 7\n" + "14 45\n" + "33 13\n" + "54 56\n"
        + "12 2\n" + "19 37\n" + "37 42\n" + "19 28\n" + "23 56\n" + "47 21\n"
        + "15 44\n" + "2 45\n" + "43 51\n" + "25 60\n" + "65 36\n" + "11 26\n"
        + "38 28\n" + "15 39\n" + "23 69\n" + "32 1\n" + "51 41\n" + "13 17\n"
        + "67 62\n" + "48 26\n" + "55 18\n" + "60 7\n" + "34 63\n" + "44 30\n"
        + "65 24\n" + "8 65\n" + "54 55\n" + "50 55\n" + "26 59\n" + "42 56\n"
        + "52 27\n" + "20 19\n" + "41 48\n" + "44 8\n" + "41 44\n" + "58 51\n"
        + "3 4\n" + "50 25\n" + "35 63\n" + "47 42\n" + "34 10\n" + "20 47\n"
        + "30 26\n" + "67 25\n" + "17 9\n" + "7 36\n" + "24 25\n" + "70 36\n"
        + "28 50\n" + "64 62\n" + "49 53\n" + "14 59\n" + "21 33\n" + "17 24\n"
        + "38 56\n" + "21 37\n" + "15 31\n" + "61 64\n" + "49 32\n" + "10 5\n"
        + "56 35\n" + "20 14\n" + "43 32\n" + "30 54\n" + "37 40\n" + "66 10\n"
        + "31 52\n" + "65 27\n" + "44 59\n" + "67 44\n" + "6 57\n" + "24 6\n"
        + "69 4\n" + "7 36\n" + "28 13\n" + "38 22\n" + "24 10\n" + "62 53\n"
        + "62 14\n" + "53 38\n" + "39 23\n" + "60 21\n" + "11 23\n" + "64 32\n"
        + "14 30\n" + "17 31\n" + "69 54\n" + "31 26\n" + "33 1\n" + "68 67\n"
        + "39 29\n" + "58 61\n" + "42 10\n" + "22 27\n" + "16 70\n" + "7 35\n"
        + "4 51\n" + "25 53\n" + "6 33\n" + "27 20\n" + "19 1\n" + "41 63\n"
        + "21 32\n" + "43 49\n" + "60 54\n" + "41 50\n" + "65 48\n" + "47 41\n"
        + "63 22\n" + "9 35\n" + "61 55\n" + "4 56\n" + "18 10\n" + "13 17\n"
        + "19 22\n" + "55 37\n" + "34 23\n" + "42 47\n" + "3 16\n" + "54 56\n"
        + "26 53\n" + "47 52\n" + "9 35\n" + "41 56\n" + "1 27\n" + "58 54\n"
        + "39 40\n" + "30 46\n" + "52 1\n" + "33 63\n" + "18 55\n" + "42 20\n"
        + "11 1\n" + "49 40\n" + "17 46\n" + "52 57\n" + "30 32\n" + "6 34\n"
        + "2 15\n" + "3 4\n" + "38 47\n" + "35 26\n" + "8 16\n" + "47 66\n"
        + "17 36\n" + "69 4\n" + "50 46\n" + "43 35\n" + "18 25\n" + "61 1\n"
        + "68 52\n" + "62 65\n" + "63 49\n" + "25 18\n" + "62 63\n" + "21 31\n"
        + "56 33\n" + "54 45\n" + "40 6\n" + "66 34\n" + "59 38\n" + "8 40\n"
        + "45 18\n" + "53 10\n" + "46 38\n" + "23 33\n" + "27 32\n" + "36 67\n"
        + "44 26\n" + "44 9\n" + "47 38\n" + "7 69\n" + "30 62\n" + "34 28\n"
        + "24 48\n" + "3 49\n" + "24 1\n" + "11 30\n" + "45 7\n" + "43 51\n"
        + "59 42\n" + "24 58\n" + "47 40\n" + "51 49\n" + "51 17\n" + "31 4\n"
        + "36 54\n" + "14 26\n" + "66 61\n" + "32 36\n" + "65 7\n" + "3 14\n"
        + "42 25\n" + "18 66\n" + "62 16\n" + "1 49\n" + "5 21\n" + "18 22\n"
        + "10 52\n" + "3 38\n" + "70 64\n" + "38 62\n" + "12 5\n" + "55 32\n"
        + "8 1\n" + "24 36\n" + "58 33\n" + "67 62\n" + "14 9\n" + "40 53\n"
        + "2 35\n" + "62 36\n" + "1 12\n" + "20 15\n" + "4 21\n" + "37 1\n"
        + "48 31\n" + "48 11\n" + "17 66\n" + "22 25\n" + "34 62\n" + "21 56\n"
        + "48 32\n" + "48 1\n" + "5 29\n" + "52 62\n" + "63 64\n" + "28 1\n"
        + "12 48\n" + "53 39\n" + "21 29\n" + "41 70\n" + "9 7\n" + "66 11\n"
        + "7 32\n" + "8 37\n" + "37 59\n" + "19 38\n" + "45 43\n" + "1 7\n"
        + "58 21\n" + "64 48\n" + "15 50\n" + "28 11\n" + "57 14\n" + "48 27\n"
        + "61 19\n" + "38 57\n" + "43 59\n" + "56 11\n" + "7 48\n" + "1 52\n"
        + "59 67\n" + "21 62\n" + "51 39\n" + "24 11\n" + "58 51\n" + "15 43\n"
        + "29 42\n" + "66 44\n" + "63 43\n" + "63 3\n" + "13 39\n" + "55 67\n"
        + "21 27\n" + "5 10\n" + "7 15\n" + "31 18\n" + "37 20\n" + "15 31\n"
        + "54 31\n" + "24 16\n" + "54 9\n" + "49 46\n" + "28 36\n" + "68 8\n"
        + "22 55\n" + "11 23\n" + "58 63\n" + "31 19\n" + "39 23\n" + "11 68\n"
        + "5 66\n" + "2 22\n" + "46 29\n" + "67 10\n" + "2 31\n" + "50 59\n"
        + "8 14\n" + "54 70\n" + "14 38\n" + "35 46\n" + "47 35\n" + "13 21\n"
        + "14 62\n" + "2 56\n" + "34 64\n" + "20 9\n" + "2 1\n" + "40 56\n"
        + "51 12\n" + "48 7\n" + "64 12\n" + "64 58\n" + "13 3\n" + "51 18\n"
        + "20 51\n" + "55 46\n" + "27 11\n" + "12 26\n" + "24 57\n" + "51 7\n"
        + "69 29\n" + "13 20\n" + "2 61\n" + "3 46\n" + "1 52\n" + "44 68\n"
        + "46 39\n" + "42 19\n" + "9 1\n" + "46 14\n" + "59 27\n" + "50 59\n"
        + "53 9\n" + "67 10\n" + "21 42\n" + "54 67\n" + "49 69\n" + "32 34\n"
        + "17 24\n" + "47 16\n" + "53 21\n" + "65 38\n" + "13 59\n" + "9 48\n"
        + "57 48\n" + "63 70\n" + "33 4\n" + "29 11\n" + "20 27\n" + "9 40\n"
        + "61 14\n" + "48 32\n" + "54 15\n" + "45 69\n" + "24 32\n" + "55 19\n"
        + "53 10\n" + "47 64\n" + "23 46\n" + "32 55\n" + "70 66\n" + "2 11\n"
        + "65 7\n" + "70 1\n" + "63 69\n" + "26 8\n" + "61 32\n" + "48 70\n"
        + "49 57\n" + "4 21\n" + "25 58\n" + "50 48\n" + "32 56\n" + "42 35\n"
        + "49 59\n" + "46 36\n" + "49 26\n" + "21 35\n" + "52 34\n" + "65 66\n"
        + "39 40\n" + "12 19\n" + "45 57\n" + "29 17\n" + "16 14\n" + "16 49\n"
        + "46 60\n" + "43 54\n" + "22 1\n" + "54 14\n" + "56 28\n" + "61 28\n"
        + "17 18\n" + "34 70\n" + "13 9\n" + "46 69\n" + "18 52\n" + "5 62\n"
        + "34 31\n" + "69 22\n" + "19 48\n" + "48 6\n" + "29 64\n" + "44 15\n"
        + "55 24\n" + "51 1\n" + "50 12\n" + "37 6\n" + "8 55\n" + "1 15\n"
        + "64 54\n" + "39 24\n" + "21 57\n" + "17 22\n" + "57 53\n" + "26 36\n"
        + "2 25\n" + "24 25\n" + "1 4\n" + "29 60\n" + "32 2\n" + "62 32\n"
        + "2 43\n" + "25 39\n" + "45 57\n" + "1 55\n" + "28 53\n" + "30 51\n"
        + "15 1\n" + "7 11\n" + "70 37\n" + "41 27\n" + "40 65\n" + "12 6\n"
        + "24 18\n" + "33 69\n" + "56 66\n" + "14 68\n" + "33 4\n" + "21 10\n"
        + "26 15\n" + "56 46\n" + "65 41\n" + "37 58\n" + "21 25\n" + "12 7\n"
        + "65 46\n" + "30 8\n" + "50 12\n" + "65 45\n" + "11 16\n" + "13 69\n"
        + "1 12\n" + "54 55\n" + "16 57\n" + "14 26\n" + "29 40\n" + "28 24\n"
        + "69 26\n" + "33 63\n" + "6 39\n" + "54 36\n" + "47 48\n" + "22 52\n"
        + "4 47\n" + "25 35\n" + "68 25\n" + "34 69\n" + "42 26\n" + "63 18\n"
        + "7 55\n" + "57 16\n" + "29 24\n" + "29 27\n" + "31 5\n" + "28 42\n"
        + "63 18\n" + "15 55\n" + "19 67\n" + "40 5\n" + "65 43\n" + "46 30\n"
        + "15 16\n" + "13 65\n" + "64 4\n" + "38 61\n" + "32 55\n" + "44 3\n"
        + "44 48\n" + "20 64\n" + "70 21\n" + "58 39\n" + "6 61\n" + "51 52\n"
        + "25 49\n" + "67 61\n" + "3 9\n" + "33 45\n" + "30 65\n" + "7 27\n"
        + "62 37\n" + "65 52\n" + "11 40\n" + "31 15\n" + "22 43\n" + "46 69\n"
        + "62 55\n" + "16 3\n" + "5 44\n" + "69 31\n" + "68 4\n" + "36 27\n"
        + "58 21\n" + "56 32\n" + "53 24\n" + "23 7\n" + "63 70\n" + "57 7\n"
        + "3 19\n" + "52 60\n" + "58 66\n" + "55 30\n" + "50 51\n" + "67 30\n"
        + "27 44\n" + "64 28\n" + "12 48\n" + "48 9\n" + "44 52\n" + "12 52\n"
        + "17 28\n" + "51 15\n" + "68 24\n" + "54 33\n" + "10 28\n" + "51 62\n"
        + "40 38\n" + "2 3\n" + "36 39\n" + "52 38\n" + "35 49\n" + "66 18\n"
        + "57 28\n" + "61 67\n" + "32 4\n" + "51 38\n" + "15 41\n" + "62 7\n"
        + "12 21\n" + "70 50\n" + "70 60\n" + "38 67\n" + "20 41\n" + "24 66\n"
        + "25 10\n" + "57 31\n" + "35 29\n" + "52 9\n" + "8 36\n" + "26 10\n"
        + "22 45\n" + "34 12\n" + "62 26\n" + "33 49\n" + "65 41\n" + "28 16\n"
        + "16 46\n" + "9 61\n" + "6 37\n" + "35 57\n" + "41 17\n" + "47 30\n"
        + "6 27\n" + "60 27\n" + "10 31\n" + "2 66\n" + "69 45\n" + "27 28\n"
        + "39 67\n" + "31 56\n" + "59 40\n" + "1 19\n" + "39 26\n" + "37 41\n"
        + "18 31\n" + "55 41\n" + "30 45\n" + "67 24\n" + "53 68\n" + "37 47\n"
        + "5 10\n" + "69 11\n" + "4 5\n" + "20 12\n" + "10 28\n" + "63 55\n"
        + "17 21\n" + "43 61\n" + "38 31\n" + "67 57\n" + "32 20\n" + "23 9\n"
        + "27 54\n" + "8 1\n" + "8 5\n" + "3 4\n" + "24 44\n" + "60 1\n"
        + "52 58\n" + "1 64\n" + "42 36\n" + "3 31\n" + "22 70\n" + "46 10\n"
        + "62 24\n" + "60 8\n" + "40 50\n" + "55 18\n" + "54 55\n" + "61 67\n"
        + "14 58\n" + "28 50\n" + "25 35\n" + "47 61\n" + "44 27\n" + "42 12\n"
        + "47 2\n" + "8 51\n" + "32 18\n" + "4 32\n" + "16 1\n" + "57 39\n"
        + "13 14\n" + "44 28\n" + "38 52\n" + "38 55\n" + "62 52\n" + "9 24\n"
        + "7 30\n" + "68 30\n" + "41 17\n" + "54 57\n" + "37 29\n" + "43 61\n"
        + "43 65\n" + "44 51\n" + "70 36\n" + "60 40\n" + "26 10\n" + "27 1\n"
        + "23 46\n" + "56 20\n" + "61 41\n" + "36 49\n" + "54 39\n" + "45 46\n"
        + "12 51\n" + "65 12\n" + "34 63\n" + "66 36\n" + "52 26\n" + "16 58\n"
        + "47 34\n" + "21 50\n" + "1 47\n" + "64 15\n" + "51 13\n" + "56 68\n"
        + "51 43\n" + "14 25\n" + "62 10\n" + "63 69\n" + "34 57\n" + "46 65\n"
        + "56 47\n" + "28 39\n" + "55 56\n" + "67 27\n" + "8 37\n" + "70 17\n"
        + "62 59\n" + "42 66\n" + "57 58\n" + "1 8\n" + "40 70\n" + "53 43\n"
        + "49 14\n" + "36 70\n" + "16 28\n" + "46 51\n" + "37 45\n" + "54 14\n"
        + "65 32\n" + "39 70\n" + "55 6\n" + "64 12\n" + "17 28\n" + "46 6\n"
        + "45 60\n" + "1 53\n" + "46 47\n" + "50 29\n" + "59 28\n" + "36 49\n"
        + "69 6\n" + "33 66\n" + "51 25\n" + "55 9\n" + "36 4\n" + "22 45\n"
        + "9 19\n" + "16 21\n" + "18 66\n" + "26 4\n" + "27 28\n" + "46 13\n"
        + "12 37\n" + "41 65\n" + "7 28\n" + "40 27\n" + "9 45\n" + "16";
    Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

    int queries = scanner.nextInt();

    for (int t = 0; t < queries; t++) {

      // Create a graph of size n where each edge weight is 6:
      Graph graph = new Graph(scanner.nextInt());
      int m = scanner.nextInt();

      // read and set edges
      for (int i = 0; i < m; i++) {
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;

        // add each edge to the graph
        graph.addEdge(u, v);
      }

      // Find shortest reach from node s
      int startId = scanner.nextInt() - 1;
      int[] distances = graph.shortestReach(startId);

      for (int i = 0; i < distances.length; i++) {
        if (i != startId) {
          System.out.print(distances[i]);
          System.out.print(" ");
        }
      }
      System.out.println();
    }

    scanner.close();
  }
}
