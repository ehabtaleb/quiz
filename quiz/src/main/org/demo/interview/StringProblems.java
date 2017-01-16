package org.demo.interview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


/**
 * Created by ehabtaleb on 01/11/16.
 */
public class StringProblems {

  public static boolean isStringPermutation(String str1, String str2){
    if(str1 == null || str2 == null){
      return false;
    }
    if(str1.length()!= str2.length()){
      return false;
    }
    char[] char1 = str1.toCharArray();
    char[] char2 = str2.toCharArray();
    Arrays.sort(char1);
    Arrays.sort(char2);
    for (int i = 0; i < char1.length; i++) {
      if(char1[i] != char2[i]){
        return false;
      }
    }
    return true;
  }

  public static String[] stringPermutation(String str ) {
    if(str == null || str.isEmpty()){
      return new String[]{""};
    }
    if(str.length() == 1){
      return new String[]{str};
    }
    if(str.length() == 2){
      return new String[]{str, str.substring(1)+str.substring(0,1)};
    }

    ArrayList<String> result = new ArrayList();
    for (int j = 0; j < str.length(); j++) {
      char c = str.charAt(j);
      String sub = str.substring(0,j) + str.substring(j + 1, str.length());
      String[] subResult = stringPermutation(sub);
      for (int i = 0; i < subResult.length; i++) {
        result.add(c+subResult[i]);
      }
    }
    return result.toArray(new String[result.size()]);
  }


  public static int isBalanced(String str) {
    final String startPar = "({[<";
    final String endPar = ")}]>";
    Stack stack = new Stack();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (startPar.indexOf(c) > -1) {
        stack.push(Character.valueOf(c));
        continue;
      }
      int endIdx = endPar.indexOf(c);
      if (endIdx > -1) {
        char startCandidate = ((Character) stack.pop()).charValue();
        if (startPar.indexOf(startCandidate) != endIdx) {
          stack.push(new Character(startCandidate));
          stack.push(new Character(c));
        }
      }
    }
    if (stack.empty()) {
      return 1;
    }
    return 0;
  }

  /**
   * Sort frequency
   * 
   */

  public static String sortFrequency(String input) {
    /**
     * FreqArray index is char ASCII value
     *            value is frequency
     */
    int[] freqArray = new int[128];
    int maxFreq = 0;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      freqArray[c]++;
      maxFreq = Math.max(maxFreq, freqArray[c]);
    }
    // bucket Array
    // index is the frequency
    // value is char array whom has the same frequency
    String[] buckets = new String[maxFreq + 1];
    for (int i = 0; i < freqArray.length; i++) {
      if (freqArray[i] == 0) {
        continue;
      }
      if (buckets[freqArray[i]] == null || buckets[freqArray[i]].isEmpty()) {
        buckets[freqArray[i]] = (char) i + "";
      } else {
        buckets[freqArray[i]] = buckets[freqArray[i]].concat((char) i + "");
      }
    }
    Sorting.printArray(buckets);
    StringBuilder out = new StringBuilder();
    for (int i = buckets.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        out.append(buckets[i]);
      }
    }
    return out.toString();
  }


  public static String frequencySort(String s) {
    // 1 byte for char
    int[] charArray = new int[128];
    int max = 0;
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      int count = charArray[c] + 1;
      charArray[c] = count;
      max = Math.max(max, count);
    }
    String[] buckets = new String[max+1];
    for(int i = 0; i < charArray.length; i++){
      if(charArray[i] != 0){
        if(buckets[charArray[i]] == null || buckets[charArray[i]].isEmpty()){
          buckets[charArray[i]] = ""+(char)i;
        }else{
          String str = buckets[charArray[i]].concat((char)i+"");
          buckets[charArray[i]] = str;
        }
      }
    }
    StringBuilder buff = new StringBuilder();
    for(int i = buckets.length -1 ; i >= 0; i--){
      if(buckets[i] != null && !buckets[i].isEmpty()) {
        String repString = buckets[i];
        for (int k = 0; k < repString.length(); k++) {
          char c = repString.charAt(k);
          for(int j = 0; j < i; j++) {
            buff.append(c);
          }
        }
      }
    }
    return buff.toString();
  }
}
