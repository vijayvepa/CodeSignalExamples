package com.example.Arrays;

import org.apache.logging.log4j.util.TriConsumer;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class DimensionalArrays {

  public static <T> void loop(T[][] array, TriConsumer<Integer, Integer, T> action) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        action.accept(i, j, array[i][j]);
      }
    }
  }

  public static Integer[][] withNewRow(Integer[][] array, Integer[] row) {
    Integer[][] newArray = new Integer[array.length + 1][array[0].length];

    for (int i = 0; i < array.length; i++) {
      newArray[i] = Arrays.copyOf(array[i], array[i].length);
    }
    newArray[array.length] = row;

    return newArray;
  }

  public static Integer[][] withRowRemoved(Integer[][] array, int rowNumber) {
    Integer[][] newArray = new Integer[array.length - 1][array[0].length];

    for (int i = 0; i < array.length; i++) {
      if (i != rowNumber) {
        newArray[i] = Arrays.copyOf(array[i], array[i].length);
      }
    }

    return newArray;
  }

  public static int[] zigZagTraversal(int[][] matrix) {

    int[] zigZagMatrix = new int[matrix.length * matrix[0].length];
    int rows = matrix.length;
    int cols = matrix[0].length;

    String direction = "up";
    int index = 0;
    for (int col = 0; col < cols; col++) {
      for (int row = 0; row < rows; row++) {
        int x = direction.equals("down") ? row : matrix.length - row - 1;
        int y = matrix[0].length - col - 1;

        zigZagMatrix[index + row] = matrix[x][y];
      }
      index += matrix.length;
      direction = direction.equals("up") ? "down" : "up";
    }

    return zigZagMatrix;
  }

  public static int[] zigZagLambda(int[][] matrix) {

    int[] zigZagMatrix = new int[matrix.length * matrix[0].length];
    int rows = matrix.length;
    int cols = matrix[0].length;

    final AtomicBoolean up = new AtomicBoolean(true);
    IntStream.range(0, cols).forEach(col -> {
      IntStream.range(0, rows).forEach(row -> {

        int x = up.get() ? matrix.length - row - 1 : row;
        int y = matrix[0].length - col - 1;
        zigZagMatrix[(matrix.length * col) + row] = matrix[x][y];
      });

      up.set(!up.get());

    });

    return zigZagMatrix;
  }

  public static int[] zigZagLearn(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    String direction = "up";

    //start at bottom right
    int row = rows - 1;
    int col = cols - 1;

    //keep track of visits
    int[] output = new int[rows * cols];
    int index = 0;

    while(index < rows * cols) {
      output[index++] = matrix[row][col];

      if(direction.equals("up")) {
        if(row - 1 < 0){
          direction = "down";
          col -= 1;
        } else {
          row -= 1;
        }
      }else {
        if(row + 1 == rows){
          direction = "up";
          cols -= 1;
        } else {
          row += 1;
        }
      }
    }

    return output;

  }

  class Solution {
    public static int[] columnTraverse(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int row = rows - 1;
      int col = cols - 1;
      String direction = "up";
      int[] output = new int[rows * cols];
      int index = 0;


      while (index < rows * cols) {


        System.out.println("row " + row + " col " + col + ": " + matrix[row][col]);
        output[index++] = matrix[row][col];

        if(direction.equals("up")) {
          row--;

          if(row == 0){
            direction = "left";
          }

        } else if (direction.equals("left")) {
          col --;
          direction = row == 0 ? "down" : "up";
        }
        else if (direction.equals("down")){
          row ++;

          if(row == rows - 1) {
            direction = "left";
          }
        }


      }

      return output;
    }

    public static void main(String[] args) {
      int[][] matrix = {
          {1, 2, 3, 4},
          {5, 6, 7, 8},
          {9, 10, 11, 12}
      };

      int[] result = columnTraverse(matrix);
      for (int value : result) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }

}
