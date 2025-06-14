package com.example.Arrays;

import java.util.Arrays;

public class RunningSum {

  public int[] runningSum(int[] array) {
    int[] result = new int[array.length];

    for(int i=0; i< array.length; i++){
      if(i == 0) {
        result[i] = array[i];
        continue;
      }
      result[i] = array[i] + result[i - 1];
    }
    return result;
  }

  public int[] runningSumNoNewArray(int[] array) {
    for(int i=1; i< array.length; i++){
      array[i] += array[i-1];
    }
    return  array;
  }

  public void runningSumMain() {
    int[] array = {1,2,3,4,5};
    int[] runningSum = runningSum(array);
    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(runningSum));

    int[] runningSum2 = runningSumNoNewArray(array);


    System.out.println(Arrays.toString(runningSum2));
    System.out.println(Arrays.toString(array));
  }


  public static void main(String[] args) {
    new RunningSum().runningSumMain();
  }
}
