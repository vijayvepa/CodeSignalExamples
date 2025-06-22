package com.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * <a href="https://www.geeksforgeeks.org/dsa/print-all-possible-permutations-of-an-array-vector-without-duplicates-using-backtracking/">Geeks for Geeks -> Permutations</a>
 */
public class Permutations {


  public List<List<Integer>> permute(int[] array) {

    List<List<Integer>> result = new ArrayList<>();

    recurse(result, array, 0);


    return result;
  }

  private void recurse(List<List<Integer>> result, int[] array, int index) {

    if(index == array.length - 1) {
      final List<Integer> list = toList(array);
      if(!result.contains(list))
        result.add(list);
      return;
    }

    for(int i=index; i< array.length; i++) {
      swapElements(array, index, i);
      recurse(result, array, index+1);
      //backtrack
      swapElements(array, i, index);
    }

  }

  private static List<Integer> toList(int[] array) {
    List<Integer> item = new ArrayList<>();
    Arrays.stream(array).forEach(item::add);
    return item;
  }

  private void swapElements(int[] array, int i, int j) {
    int previousArrayI = array[i];
    array[i] = array[j];
    array[j] = previousArrayI;
  }

  void test(int[] input, List<List<Integer>> expected, Function<int[], List<List<Integer>>> option) {
    List<List<Integer>> actual = option.apply(input);

    String expectedString = toString(expected);
    String actualString = toString(actual);

    if(Objects.equals(expectedString, actualString)) {
      System.out.println("Passed: " + expectedString + " == " + actualString);
    }else {
      System.out.println("Failed: " + expectedString + " != " + actualString);
    }
  }

  private String toString(List<List<Integer>> expected) {
    return Arrays.deepToString(expected.stream().map(List::toArray).toArray());
  }

  void run() {

    test(new int[]{1}, List.of(List.of(1)), this::permute);
    test(new int[]{1,2}, List.of(List.of(1, 2), List.of(2,1)), this::permute);
    test(new int[]{1,1,2}, List.of(List.of(1, 1, 2), List.of(1,2,1), List.of(2, 1, 1)), this::permute);
    test(new int[]{1,2,3}, List.of(List.of(1, 2, 3), List.of(1,3,2), List.of(2, 1, 3), List.of(2,3,1), List.of(3, 2, 1), List.of(3,1,2)), this::permute);
  }

  public static void main(String[] args) {
    new Permutations().run();
  }

}
