package com.example.LinkedLists;

import java.util.List;
import java.util.stream.Stream;

public class ListNode {
  private int value;
  private ListNode nextNode;

  public int getValue() {
    return value;
  }

  public ListNode getNextNode() {
    return nextNode;
  }

  public ListNode() {
  }

  public ListNode(int value) {
    this.value = value;
  }

  public ListNode(int value, ListNode nextNode) {
    this.value = value;
    this.nextNode = nextNode;
  }

  public ListNode(List<Integer> values) {

    this.value = values.get(0);
    final List<Integer> list = values.stream().skip(1).toList();

    if(!list.isEmpty()) {
      this.nextNode = new ListNode(list);
    }
  }

  public List<Integer> toList() {
    if (nextNode == null) {
      return List.of(value);
    }

    return Stream.concat(Stream.of(value), nextNode.toList().stream()).toList();
  }

  public void setValue(int value){
    this.value = value;
  }

  public void setNextNode(ListNode listNode) {
    this.nextNode = listNode;
  }

  @Override
  public String toString() {
    return toList().toString();
  }
}
