package com.example.LinkedLists;

import org.yaml.snakeyaml.util.Tuple;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * See <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">LeetCode Link</a>
 */
public class MergeKLinkedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    return new ListNode();
  }

  public void run() {
    test(this::mergeKLists);
  }

  public static void main(String[] args) {
    new MergeKLinkedLists().run();
  }

  void test(Function<ListNode[], ListNode> solution) {

    example1(solution);
    example2(solution);

  }

  void example1(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[] {
        new ListNode(List.of(1,4,5)),
        new ListNode(List.of(1,3,4)),
        new ListNode(List.of(2,6))
    };
    ListNode expected = new ListNode(List.of(
        1,1,2,3,4,4,5,6
    ));

    testParams(input, expected, this::mergeKLists);
  }

  void example2(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[] {};
    ListNode expected = new ListNode();

    testParams(input, expected, this::mergeKLists);
  }

  void testParams(ListNode[] input, ListNode expected, Function<ListNode[], ListNode> solution) {
    System.out.println("Input: " + Arrays.toString(input));

    String expectedText = expected.toString();
    ListNode actual = solution.apply(input);
    String actualText = actual.toString();

    if(Objects.equals(expectedText, actualText)) {
      System.out.println("Passed: " + expectedText + "==" + actualText);
    }else {
      System.out.println("Failed: " + expectedText + "!=" + actualText);
    }
    System.out.println("---");
  }





}
