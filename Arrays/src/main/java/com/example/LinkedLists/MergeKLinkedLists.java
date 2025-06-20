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

    ListNode result = null;

    ListNode resultCurr = null;
    ListNode[] currentNodes = Arrays.stream(lists).filter(Objects::nonNull).toList().toArray(new ListNode[0]);

    if(currentNodes.length == 0) {
      return null;
    }

    while (currentNodes.length > 0) {
      currentNodes = sortHeads(currentNodes);

      //vertical traversal
      for (int i = 0; i < currentNodes.length; i++) {

        System.out.print("Index: " + i);
        System.out.print(", ResultCurr: " + resultCurr);
        System.out.print(", CurrentNodes[i]: " + currentNodes[i]);
        System.out.print(", Result: " + result);


        if (currentNodes[i] == null) {
          continue;
        }

        //initialize
        if (resultCurr == null) {
          result = resultCurr = new ListNode(currentNodes[i].val);
          currentNodes[i] = currentNodes[i].next;

          System.out.println("\n ResultCurr: " + resultCurr + " , Result: " + result);
          System.out.println("\n---");

          continue;
        }

        //vertical comparison
        if (resultCurr.val == currentNodes[i].val) {
          resultCurr.next = new ListNode(currentNodes[i].val);
        }
        else if (resultCurr.val <= currentNodes[i].val) {
          resultCurr.next = new ListNode(currentNodes[i].val);
        } else {
          resultCurr.next = new ListNode(resultCurr.val, resultCurr.next);
          resultCurr.val = currentNodes[i].val;

        }

        resultCurr = resultCurr.next;
        currentNodes[i] = currentNodes[i].next;

        System.out.println("\n ResultCurr: " + resultCurr + " , Result: " + result);
        System.out.println("\n---");

      }
    }




    return result;
  }



  //TODO: manually sort
  public ListNode[] sortHeads(ListNode[] nodes) {
    Map<Integer, List<ListNode>> listNodeMap = Arrays.stream(nodes)
        .filter(Objects::nonNull)
        .collect(Collectors.toMap(
            listNode -> listNode.val, node -> Stream.of(node).toList(), (x, y) ->
                Stream.concat(x.stream(), y.stream()).toList()));
    final List<Integer> list = listNodeMap.keySet().stream().sorted().toList();

    return list.stream().map(listNodeMap::get).flatMap(Collection::stream).toList().toArray(new ListNode[0]);
  }


  public static void main(String[] args) {
    new MergeKLinkedLists().run();
  }

  public void run() {
    test(this::mergeKLists);
  }


  void test(Function<ListNode[], ListNode> solution) {

    example1(solution);
    example2(solution);
    example3(solution);
    example4(solution);
    example6(solution);
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


  void example3(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[]{
        null,
        new ListNode(1),
    };
    ListNode expected = new ListNode(List.of(
        1
    ));

    testParams(input, expected, this::mergeKLists);
  }

  void example4(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[]{
        new ListNode(1),
        new ListNode(0),
    };
    ListNode expected = new ListNode(List.of(
        0,1
    ));

    testParams(input, expected, this::mergeKLists);
  }

  void example6(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[]{
        new ListNode(List.of(1,2,3)),
        new ListNode(List.of(4,5,6,7)),
    };
    ListNode expected = new ListNode(List.of(
        1,2,3,4,5,6,7
    ));

    testParams(input, expected, this::mergeKLists);
  }

  void example2(Function<ListNode[], ListNode> solution) {
    ListNode[] input = new ListNode[]{};
    ListNode expected = null;

    testParams(input, expected, this::mergeKLists);
  }

  void testParams(ListNode[] input, ListNode expected, Function<ListNode[], ListNode> solution) {
    System.out.println("Input: " + Arrays.toString(input));

    String expectedText = expected == null ? "[]" : expected.toString();
    ListNode actual = solution.apply(input);
    String actualText = actual == null ? "[]" : actual.toString();

    if (Objects.equals(expectedText, actualText)) {
      System.out.println("Passed: " + expectedText + "==" + actualText);
    } else {
      System.out.println("Failed: " + expectedText + "!=" + actualText);
    }
    System.out.println("---");
  }


}
