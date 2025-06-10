package com.example.Arrays;

import java.util.Arrays;

public class ZigZagTraverse {
  public static int[] zigzagTraverse(int[][] grid) {
    // TODO: Determine the number of rows and columns in 'grid'
    int rows = grid.length;
    int cols = grid[0].length;

    System.out.println("rows " + rows + " cols " + cols);

    int[] traversalPath = new int[rows * cols];

    String direction = "up";
    int row = rows - 1;
    int col = cols - 1;


    for (int i = 0; i < rows * cols; i++) {

      System.out.println("col " + col + " row " + row + " " + grid[row][col]);
      traversalPath[i] = grid[row][col];


      switch (direction) {
        case "up":
          row--;

          if (row == 0) {
            direction = "left";
          }
          break;
        case "left":
          col--;

          if (row == 0) {
            direction = "down";
          } else if (row == rows - 1) {
            direction = "up";
          }
          break;
        case "down":
          row++;

          if (row == rows - 1) {
            direction = "left";
          }
          break;
      }

    }

    return traversalPath;
  }

  public static void main(String[] args) {
    int[][] grid = {
        {101, 102, 103, 104},
        {201, 202, 203, 204}
    };

    int[] traverse = zigzagTraverse(grid);

    System.out.println(Arrays.toString(traverse));

  }
}
