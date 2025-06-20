package com.example.LinkedLists;

import java.util.List;
import java.util.stream.Stream;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public ListNode(List<Integer> values) {

    this.val = values.get(0);
    final List<Integer> list = values.stream().skip(1).toList();

    if(!list.isEmpty()) {
      this.next = new ListNode(list);
    }
  }

  public List<Integer> toList() {
    if (next == null) {
      return List.of(val);
    }

    return Stream.concat(Stream.of(val), next.toList().stream()).toList();
  }

  @Override
  public String toString() {
    return toList().toString();
  }
}
