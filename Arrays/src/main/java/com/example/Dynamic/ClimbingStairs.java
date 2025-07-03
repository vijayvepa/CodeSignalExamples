package com.example.Dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">LeetCode.</a>
 */
public class ClimbingStairs {

  public List<List<Integer>> climbStairs(Integer n) {

    List<List<Integer>> waysToClimb = new ArrayList<>();

    final List<Integer> singles = IntStream.range(0, n).mapToObj(x-> 1).toList();
    waysToClimb.add(singles);

    final List<Integer> doubles = IntStream.range(0, n / 2).mapToObj(x -> 2).toList();
    if(n%2 == 0) {
      waysToClimb.add(doubles);
    }else {
      waysToClimb.add(Stream.concat(doubles.stream(), Stream.of(1)).toList());
    }

    return waysToClimb;
  }

  void run(){
    test(2,  List.of( List.of(1,1), List.of(2)), this::climbStairs);
    test(3,  List.of(List.of(1,1, 1), List.of(1, 2), List.of(2,1)), this::climbStairs);
  }

  void test(Integer input, List<List<Integer>> expected,  Function<Integer, List<List<Integer>>> solution){
    List<List<Integer>> actual = solution.apply(input);

    final String expectedString = expected.toString();
    final String actualString = actual.toString();

    if(Objects.equals(expectedString, actualString)) {
      System.out.println("Passed: " + expectedString + " == " + actualString);
    }else {
      System.out.println("Failed: " + expectedString + " != " + actualString);
    }
  }

  public static void main(String[] args) {
    new ClimbingStairs().run();
  }



}
