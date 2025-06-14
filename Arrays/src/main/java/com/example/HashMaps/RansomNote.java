package com.example.HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *Each letter in magazine can only be used once in ransomNote.
 *
 * See <a href="https://leetcode.com/problems/ransom-note/description/">Ransom Note</a>
 */
public class RansomNote {
  public Boolean canConstruct(String ransomNote, String magazine) {

    Map<Integer, Integer> ransomNoteOccurrences = occurrences(ransomNote);
    Map<Integer, Integer> magazineOccurrences=  occurrences(magazine);


    System.out.println(ransomNoteOccurrences);
    System.out.println(magazineOccurrences);

    final Set<Integer> magazineKeys = magazineOccurrences.keySet();
    final Set<Integer> ransomNoteKeys = ransomNoteOccurrences.keySet();

    for(Integer key: ransomNoteKeys) {
      if(!magazineKeys.contains(key)) {
        System.out.println("Key \"" + Character.toString(key) + "\" not found in magazines");
        return false;
      }
      final Integer keyOccurrencesInMagazine = magazineOccurrences.get(key);
      final Integer keyOccurrencesInRansomNote = ransomNoteOccurrences.get(key);

      if(keyOccurrencesInMagazine < ransomNoteOccurrences.get(key)) {
        System.out.println("Key \"" + Character.toString(key) + "\" has "  +
            keyOccurrencesInMagazine + " (Magazine) < " + keyOccurrencesInRansomNote +" (RansomNote)");
        return false;
      }
    }

    return true;
  }

  Map<Integer, Integer> occurrences(String item) {
    Map<Integer, Integer> occurrenceMap = new HashMap<>();

    final int[] array = item.chars().toArray();

    for(int i =0; i< array.length; i++){
      occurrenceMap.put(array[i],
          occurrenceMap.getOrDefault(array[i], 0) + 1);
    }
    return occurrenceMap;
  }

  void assertEquals(Boolean expected, Boolean actual) {

    if(expected == actual) {
      System.out.println("Passed: " + expected + " == " + actual);
    } else {
      System.out.println("Failed: " + expected + " <> " + actual);
    }
    System.out.println("---");

  }

  public void test(
      String ransomNote, String magazine, Boolean expected,
      BiFunction<String, String, Boolean> canConstructFn
  ) {

    System.out.println("ransomNote: " + ransomNote + ", magazine: " + magazine);
    Boolean actual = canConstructFn.apply(ransomNote, magazine);
    assertEquals(expected, actual);

  }

  public void test1 (BiFunction<String, String, Boolean> canConstructFn){
    test("a", "b", false,  canConstructFn);
  }

  public void test2 (BiFunction<String, String, Boolean> canConstructFn){
    test("aa", "bb", false,  canConstructFn);
  }

  public void test3 (BiFunction<String, String, Boolean> canConstructFn){
    test("aa", "aab", true,  canConstructFn);
  }

  public void test4 (BiFunction<String, String, Boolean> canConstructFn){
    test("get me money", "get something. ", true,  canConstructFn);
  }

  public void ransomNoteMain(){
    test1(this::canConstruct);
    test2(this::canConstruct);
    test3(this::canConstruct);
    test4(this::canConstruct);
  }

  public static void main(String[] args) {
    new RansomNote().ransomNoteMain();
  }
}
