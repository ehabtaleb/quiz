package org.demo.interview;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 01/11/16.
 */
public class StringProblemsTest {

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testLongestCommon(){
    assertThat(StringProblems.longestCommon("ABCD", "AC"), is(2));
    assertThat(StringProblems.longestCommon("ABCD", "ACD"), is(3));
    assertThat(StringProblems.longestCommon("ABCD", "ABCD"), is(2));
  }

  @Test public void testIsBalanced() throws Exception {
    assertThat(StringProblems.isBalanced(""), is(1));
    assertThat(StringProblems.isBalanced("("), is(0));
    assertThat(StringProblems.isBalanced("(9)"), is(1));
      assertThat(StringProblems.isBalanced("{(9)}"), is(1));
      assertThat(StringProblems.isBalanced("(9)<<{123}>><{[iuyr]}>"), is(1));
      assertThat(StringProblems.isBalanced("(9)<}"), is(0));
      assertThat(StringProblems.isBalanced("(9){<}>"), is(0));
  }

  @Test
  public void testFrequencyTest(){
    //assertThat(StringProblems.sortFrequency("trhreee"), AnyOf.anyOf(
    //    is("eeerrth"), is("eeerrht")));

    assertThat(StringProblems.frequencySort("trhreee"),
        AnyOf.anyOf(is("eeerrth"), is("eeerrht")));
    assertThat(StringProblems.frequencySort("ccc"),
        AnyOf.anyOf(is("ccc"), is("ccc")));
    assertThat(StringProblems.frequencySort("cccaaa"), AnyOf.anyOf(is("aaaccc"),
        is("cccaaa")));


  }

  @Test
  public void testIsStringPermutation(){
    assertThat(StringProblems.isStringPermutation("ABCD", "ACDB"), is(true));
    assertThat(StringProblems.isStringPermutation("ABCD", "ACDC"), is(false));
  }

  @Test public void testStringPermutation() throws Exception {
    assertThat(StringProblems.stringPermutation("AB"), is(new String[] { "AB", "BA" }));
    Sorting.printArray(stringPermutation("ABC"));
    Sorting.printArray(stringPermutation("ABCD"));
    assertThat(StringProblems.stringPermutation("ABC"),
        is(new String[] { "ABC", "ACB", "BAC", "BCA", "CAB", "CBA" }));
  }

  private String[] stringPermutation(String str) {
    if(str == null){
      return null;
    }
    if(str.length() == 1){
      return new String[]{str};
    }
    if(str.length() == 2){
      return new String[]{str, str.substring(1)+str.substring(0, 1)};
    }
    List<String> permutationList = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      String sub  = str.substring(0,i)+ str.substring(i+1,str.length());
      String[] subPermutation = stringPermutation(sub);
      for (int j = 0; j < subPermutation.length; j++) {
        permutationList.add(String.valueOf(c)+subPermutation[j]);
      }
    }
    return permutationList.toArray(new String[permutationList.size()]);
  }

  @Test public void testIsUniqueString() throws Exception {
    assertThat(isUnique("ABCD"), is(true));
    assertThat(isUnique("ABCC"), is(false));
    assertThat(isUnique("aabb"), is(false));
    assertThat(isUnique("aTTb"), is(false));
  }

  private boolean isUnique(String str) {
    char[] buckets = new char[256];
    String lower = str.toLowerCase();
    for (int i = 0; i < lower.length(); i++) {
      char c = lower.charAt(i);
      int id = c - 'a';
      buckets[id] += 1;
    }
    for (int i = 0; i < buckets.length; i++) {
      if(buckets[i] > 1){
        return false;
      }
    }
    return true;
  }

  @Test
  public void testIsPandolum() throws Exception {
    //assertThat(isPandolum("ABCD"), is(false));
    assertThat(isPandolum("ABtBA"), is(true));
    //assertThat(isPandolum("ABA"), is(true));
  }

  private boolean isPandolum(String string) {
    String str = string.toLowerCase();
    int len = str.length();
    int mid = len/2;
    for (int i = 0, j = len - 1 ; i < mid && i < j ; i++, j--) {
      if(str.charAt(i) != str.charAt(j)){
        return false;
      }
    }
    return true;
  }



  @Test
  public void testIsanagram() throws Exception {
    assertThat(isAnagram("ABCD", "DCAB"), is(true));
    assertThat(isAnagram("ABCDT", "DCAB"), is(false));
  }

  private boolean isAnagram(String s, String t) {
    if(s.length() != t.length()){
      return false;
    }
    char[] sortedS = s.toCharArray();
    Arrays.sort(sortedS);
    char[] sortedT = t.toCharArray();
    Arrays.sort(sortedT);

    return  Arrays.equals(sortedS, sortedT);
  }


  @Test
  public void testReplaceFun() {
    assertThat(replaceFun("AAA"), is("AAA"));
    assertThat(replaceFun("A A"), is("A%20A"));
    assertThat(replaceFun(" "), is("%20"));
    assertThat(replaceFun(""), is(""));
    assertThat(replaceFun(" A A"), is("%20A%20A"));

  }
  
  public static String replaceFun(String str) {
    if(str == null) return str;
    int len = str.length();
    int countSpace = 0;
    for (int i = 0; i < len; i++) {
      if(str.charAt(i) == ' '){
        countSpace++;
      }
    }
    int newLen = len + countSpace * 2;
    char[] newStr = new char[newLen];
    int next = 0;
    for (int i = 0; i < len; i++) {
      if(str.charAt(i) == ' '){
        newStr[next] = '%';
        newStr[next+1] = '2';
        newStr[next+2] = '0';
        next = next +3;
      }else{
        newStr[next] = str.charAt(i);
        next = next +1;
      }
    }
    return String.valueOf(newStr);
  }
  
}