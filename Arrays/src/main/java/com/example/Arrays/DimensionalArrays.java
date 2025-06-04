package com.example.Arrays;

import org.apache.logging.log4j.util.TriConsumer;

public class DimensionalArrays {

  public static <T> void loop(T[][] array, TriConsumer<Integer, Integer, T> action) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        action.accept(i, j, array[i][j]);
      }
    }
  }

}
