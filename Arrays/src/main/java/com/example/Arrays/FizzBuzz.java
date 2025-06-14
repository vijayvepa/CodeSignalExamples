package com.example.Arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class FizzBuzz {
  public void fizzBuzzMain() {
    fizzBuzzExample1();
    fizzBuzzExample2();
    fizzBuzzExample3();
  }

  public void fizzBuzzExample1() {
    System.out.println("Input: 3");
    String[] fizzBuzz3 = fizzBuzzStreams(3);
    String[] expected = {"1", "2", "Fizz"};
    assertEquals(Arrays.toString(expected), Arrays.toString(fizzBuzz3));
  }

  public void fizzBuzzExample2() {
    System.out.println("Input: 5");
    String[] fizzBuzz5 = fizzBuzz(5);
    String[] expected = {"1", "2", "Fizz", "4", "Buzz"};
    assertEquals(Arrays.toString(expected), Arrays.toString(fizzBuzz5));
  }

  public void fizzBuzzExample3() {
    System.out.println("Input: 15");
    String[] fizzBuzz5 = fizzBuzz(15);
    String[] expected = {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"};
    assertEquals(Arrays.toString(expected), Arrays.toString(fizzBuzz5));

  }

  public void assertEquals(String expected, String actual) {
    System.out.println("Expected: " + expected + ", actual: " + actual);
    if (!Objects.equals(expected, actual)) {
      System.out.println("Failed, Expected: " + expected + ", actual: " + actual);
      System.out.println("---");
      return;
    }
    System.out.println("Passed");
    System.out.println("---");
  }

  public String[] fizzBuzz(int size) {
    String[] result = new String[size];
    for (int i = 0; i < size; i++) {
      result[i] = fizzBuzzMapper(i);

    }
    return result;
  }

  public String fizzBuzzMapper(int index) {
    int number = index + 1;
    boolean fizz = number % 3 == 0;
    boolean buzz = number % 5 == 0;

    StringBuilder output = new StringBuilder();

    if (fizz) {
      output.append("Fizz");
    }

    if (buzz) {
      output.append("Buzz");
    }

    if (output.isEmpty()) {
      output.append(number);
    }

    return output.toString();
  }

  public String[] fizzBuzzStreams(int size) {
    return IntStream.range(0, size).mapToObj(this::fizzBuzzMapper)
        .toList().toArray(new String[0]);
  }

  public static void main(String[] args) {
    new FizzBuzz().fizzBuzzMain();
  }
}
