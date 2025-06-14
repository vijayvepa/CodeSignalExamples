package com.example.LinkedLists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MiddleOfLinkedList {

  private static final Logger log = LoggerFactory.getLogger(MiddleOfLinkedList.class);

  public void linkedListExample() {

    middleOfExample1();
    middleOfExample2();
  }

  public ListNode middleOf(ListNode input) {

    return new ListNode();
  }

  public void middleOfExample1() {

    ListNode input = new ListNode(List.of(1, 2, 3, 4, 5));
    System.out.println("Input : " + input);
    ListNode expected = new ListNode(List.of(3, 4, 5));
    ListNode actual = middleOf(input);
    assertEquals(expected, actual);
  }

  public void middleOfExample2() {

    ListNode input = new ListNode(List.of(1, 2, 3, 4, 5, 6));
    System.out.println("Input : " + input);
    ListNode expected = new ListNode(List.of(4, 5, 6));
    ListNode actual = middleOf(input);
    assertEquals(expected, actual);
  }


  public void assertEquals(ListNode expected, ListNode actual) {
    String expectedText = expected.toString();
    String actualText = actual.toString();

    if (Objects.equals(expectedText, actualText)) {
      System.out.println("Passed: " + expectedText + " == " + actualText);
    } else {
      System.out.println("Failed: " + expectedText + " <> " + actualText);
    }
    System.out.println("---");
  }

  public static void main(String[] args) {
    new MiddleOfLinkedList().linkedListExample();
  }
}
