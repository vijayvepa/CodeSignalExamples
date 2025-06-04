package com.example.Arrays;

import org.apache.logging.log4j.util.TriConsumer;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class DimensionalArrays {

  public static int[][] createExample() {
    return new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
  }

  public static void print(int[][] array) {
    System.out.println(Arrays.deepToString(array));
  }

  public static void loop(int[][] array, TriConsumer<Integer, Integer, Integer> action) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        action.accept(i, j, array[i][j]);
      }
    }
  }
}
