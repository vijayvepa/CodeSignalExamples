package com.example.LinkedLists;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * See <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">LeetCode Link</a>
 */
public class MergeKLinkedLists {

  public ListNode mergeKLists(ListNode[] lists) {

    ListNode result = new ListNode();

    ListNode resultCurr = result;
    ListNode[] currentNodes = new ListNode[lists.length];

    System.arraycopy(lists, 0, currentNodes, 0, lists.length);

    while (currentNodes.length > 0) {
      currentNodes = sortNodes(currentNodes);

      for (int i = 0; i < currentNodes.length; i++) {

        System.out.println("Index: " + i);

        if (currentNodes[i] == null) {
          continue;
        }

        if (resultCurr.getValue() == 0) {
          resultCurr.setValue(currentNodes[i].getValue());
          currentNodes[i] = currentNodes[i].getNextNode();
          continue;
        }

        if (resultCurr.getValue() == currentNodes[i].getValue()) {
          resultCurr.setNextNode(new ListNode(currentNodes[i].getValue()));
          resultCurr = resultCurr.getNextNode();
          currentNodes[i] = currentNodes[i].getNextNode();
          continue;
        }

        if (resultCurr.getValue() <= currentNodes[i].getValue()) {
          resultCurr.setNextNode(new ListNode(currentNodes[i].getValue()));
          resultCurr = resultCurr.getNextNode();
          currentNodes[i] = currentNodes[i].getNextNode();
        } else {
          resultCurr.setNextNode(new ListNode(resultCurr.getValue(), resultCurr.getNextNode()));
          resultCurr.setValue(currentNodes[i].getValue());

          resultCurr = resultCurr.getNextNode();
          currentNodes[i] = currentNodes[i].getNextNode();
        }
      }
    }


    return result;
  }

  public static void main(String[] args) {
    new MergeKLinkedLists().run();
  }

  //TODO: manually sort
  public ListNode[] sortNodes(ListNode[] nodes) {
    Map<Integer, List<ListNode>> listNodeMap = Arrays.stream(nodes)
        .filter(x -> x != null)
        .collect(Collectors.toMap(
            ListNode::getValue, node -> Stream.of(node).toList(), (x, y) ->
                Stream.concat(x.stream(), y.stream()).toList()));
    final List<Integer> list = listNodeMap.keySet().stream().sorted().toList();

    return list.stream().map(listNodeMap::get).flatMap(Collection::stream).toList().toArray(new ListNode[0]);
  }

  public void run() {
    test(this::mergeKLists);
  }


  void test(Function<ListNode[], ListNode> solution) {

    example1(solution);
    example2(solution);

  }

  void example1(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[]{
        new ListNode(List.of(1, 4, 5)),
        new ListNode(List.of(1, 3, 4)),
        new ListNode(List.of(2, 6))
    };
    ListNode expected = new ListNode(List.of(
        1, 1, 2, 3, 4, 4, 5, 6
    ));

    testParams(input, expected, this::mergeKLists);
  }

  void example2(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[]{};
    ListNode expected = new ListNode();

    testParams(input, expected, this::mergeKLists);
  }

  void testParams(ListNode[] input, ListNode expected, Function<ListNode[], ListNode> solution) {
    System.out.println("Input: " + Arrays.toString(input));

    String expectedText = expected.toString();
    ListNode actual = solution.apply(input);
    String actualText = actual.toString();

    if (Objects.equals(expectedText, actualText)) {
      System.out.println("Passed: " + expectedText + "==" + actualText);
    } else {
      System.out.println("Failed: " + expectedText + "!=" + actualText);
    }
    System.out.println("---");
  }


}
