package com.example.Arrays;

import org.apache.logging.log4j.util.TriConsumer;

import java.util.Arrays;

public class DimensionalArrays {

  public static <T> void loop(T[][] array, TriConsumer<Integer, Integer, T> action) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        action.accept(i, j, array[i][j]);
      }
    }
  }

  public static  Integer[][] withNewRow(Integer[][] array, Integer[] row) {
    Integer[][] newArray = new Integer[array.length+1][array[0].length];

    for(int i=0; i < array.length; i++) {
      newArray[i] = Arrays.copyOf(array[i], array[i].length);
    }
    newArray[array.length] = row;

    return newArray;
  }

  public static Integer[][] withRowRemoved(Integer[][] array, int rowNumber) {
    Integer[][] newArray  = new Integer[array.length - 1][array[0].length];

    for(int i=0;i<array.length; i++) {
      if(i != rowNumber){
        newArray[i] = Arrays.copyOf(array[i], array[i].length);
      }
    }

    return newArray;
  }
}
