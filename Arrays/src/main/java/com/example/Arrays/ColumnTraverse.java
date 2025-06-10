package com.example.Arrays;

public class ColumnTraverse {
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

      switch (direction) {
        case "up" -> {
          row--;

          if (row == 0) {
            direction = "left";
          }
        }
        case "left" -> {
          col--;
          direction = row == 0 ? "down" : "up";
        }
        case "down" -> {
          row++;

          if (row == rows - 1) {
            direction = "left";
          }
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