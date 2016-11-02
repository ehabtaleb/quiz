package org.demo.interview;

import java.util.Map;
import java.util.Stack;

/**
 * Created by ehabtaleb on 01/11/16.
 */
public class StringProblems {

  /**
   *
   * @param str
   * @return 1 if str is parentathes balanced
   * @return 0 if not balanced
   */
  public static int isBalanced(String str){

    int balance = 0;
    final String startPar = "({[<";
    final String endPar = ")}]>";
    char[] lastOpenArray = new char[str.length()];
    int lastOpenIdx = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if(startPar.indexOf(c) > -1){
        balance++;
        lastOpenArray[lastOpenIdx] = c;
        lastOpenIdx++;
        continue;
      }
      int endIdx = endPar.indexOf(c);
      if(endIdx > -1) {
        char lastOpen = lastOpenArray[lastOpenIdx-1];
        int matchIdx = startPar.indexOf(lastOpen);
        if (endIdx == matchIdx) {
          balance--;
          lastOpenIdx--;
        }else{
          balance++;
        }
      }
    }
    if(balance == 0){
      return 1;
    }
    return 0;
  }

  public static int isBalancedStack(String str){
    final String startPar = "({[<";
    final String endPar = ")}]>";
    Stack stack = new Stack();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if(startPar.indexOf(c) > -1){
        stack.push(new Character(c));
        continue;
      }
      int endIdx = endPar.indexOf(c);
      if(endIdx > -1){
        char startCandidate = ((Character) stack.pop()).charValue();
        if(startPar.indexOf(startCandidate) == endIdx) {
        }else{
          stack.push(new Character(startCandidate));
          stack.push(new Character(c));
        }
      }
    }
    if(stack.empty()){
      return 1;
    }
    return 0;
  }
}
