package com.example.Arrays;


import java.util.ArrayList;
import java.util.List;
public class VerticalTraverse  {
  public static List<Integer> verticalTraverse(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    List<Integer> result = new ArrayList<>();
    // TODO: Append each element's value to the result list by following the vertical pattern.

    int row = rows - 1;
    int col = cols - 1;

    String direction = "up";

    for(int i = 0; i< rows * cols; i++ ){
      System.out.println("Adding " + col + "-" + row + ":" + matrix[row][col]);
      result.add(matrix[row][col]);
      if(direction.equals("up")){
        row --;

        if(row == 0){
          direction = "left";
        }

      } else {
        col --;
        row = rows - 1;
        direction = "up";
      }

    }

    return result;
  }

  public static void main(String[] args) {
    int[][] data = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };

    List<Integer> traversal = verticalTraverse(data);
    for (int num : traversal) {
      System.out.print(num + " ");
    }
  }
}
