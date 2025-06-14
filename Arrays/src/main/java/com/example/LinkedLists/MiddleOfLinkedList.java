package com.example.LinkedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class MiddleOfLinkedList {

  public void linkedListExample() {

    System.out.println("Middle Of - Time 2N, Space 1");
    test1(this::middleOf);
    test2(this::middleOf);

    System.out.println("Middle Of - Time N, Space N");
    test1(this::middleNodeArray);
    test2(this::middleNodeArray);

    System.out.println("Middle Of Pointers - Time N, Space 1");
    test1(this::middleNodePointers);
    test2(this::middleNodePointers);

  }

  public ListNode middleOf(ListNode input) {

    int size = 0;
    ListNode curr = input;
    while (curr.getNextNode() != null) {
      size++;
      curr = curr.getNextNode();
    }

    System.out.println("Size: " + size);
    int middleIndex = size % 2 == 1 ? size / 2 + 1 : size / 2;
    System.out.println("Middle Index: " + middleIndex);

    int index = 0;
    ListNode middleNode = input;
    while (index != middleIndex) {
      index++;
      middleNode = middleNode.getNextNode();
    }

    return middleNode;
  }

  public ListNode middleNodeArray(ListNode input){
    List<ListNode> nodes = new ArrayList<>();
    ListNode curr = input;

    while (curr.getNextNode() != null){
      nodes.add(curr);
      curr = curr.getNextNode();
    }

    int size = nodes.size();
    int middle = size % 2 == 1 ? size/2 + 1: size/2;

    return nodes.get(middle);
  }

  public ListNode middleNodePointers(ListNode input) {
    ListNode middle = input;
    ListNode end = input;

    while (end != null && end.getNextNode() != null) {
      middle = middle.getNextNode();
      end = end.getNextNode().getNextNode(); //move by 2
    }

    return middle;

  }

  public void test1(Function<ListNode, ListNode> example) {

    ListNode input = new ListNode(List.of(1, 2, 3, 4, 5));
    System.out.println("Input : " + input);
    ListNode expected = new ListNode(List.of(3, 4, 5));
    ListNode actual = example.apply(input);
    assertEquals(expected, actual);
  }

  public void test2(Function<ListNode, ListNode> example) {

    ListNode input = new ListNode(List.of(1, 2, 3, 4, 5, 6));
    System.out.println("Input : " + input);
    ListNode expected = new ListNode(List.of(4, 5, 6));
    ListNode actual = example.apply(input);
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
