package com.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StepsToZero {
  public void stepsToZeroMain() {
    stepsToZeroExample1();
    stepsToZeroExample2();
    stepsToZeroExample3();
  }

  public int[] stepsToZero(int starting) {
    List<Integer> steps = new ArrayList<>();

    int next = starting;
    while (next != 0) {
      steps.add(next);
     // next = next % 2 == 0 ? next / 2 : next - 1;
      //- if last bit is 0, shift bits, otherwise decrement
      next = (next & 1) == 0 ? next >> 1 : next - 1;
    }
    return steps.stream().mapToInt(Integer::intValue).toArray();
  }

  public void stepsToZeroExample1(){
    System.out.println("Input: 14");
    System.out.println("Expected: 6");

    int[] steps = {14, 7, 6, 3, 2, 1};
    int[] actual = stepsToZero(14);

    assertEquals(steps, actual);
  }

  public void stepsToZeroExample2(){
    System.out.println("Input: 8");
    System.out.println("Expected: 4");

    int[] steps = {8, 4, 2, 1};
    int[] actual = stepsToZero(8);

    assertEquals(steps, actual);
  }

  public void stepsToZeroExample3() {
    System.out.println("Input: 123");
    System.out.println("Expected: 12");

    int[] steps = {123, 122, 61, 60, 30, 15, 14, 7, 6, 3, 2, 1};
    int[] actual = stepsToZero(123);

    assertEquals(steps,  actual);
  }

  public void assertEquals(int[] expected, int[] actual) {
    String expectedText = Arrays.toString(expected);
    String actualText = Arrays.toString(actual);

    if(!Objects.equals(expectedText, actualText)){
      System.out.println("Failed - " + expectedText + " <> " + actualText);
    }else {
      System.out.println("Passed - " + expectedText + "==" + actualText);
    }


  }

  public static void main(String[] args) {
    new StepsToZero().stepsToZeroMain();
  }
}
