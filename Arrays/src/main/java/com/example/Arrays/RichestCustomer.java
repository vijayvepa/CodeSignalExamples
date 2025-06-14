package com.example.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RichestCustomer {
  void richestCustomerMain() {
    int[][] accounts = {
        {7, 1, 3}, {2, 8, 7}, {1, 9, 5}
    };
    int expectedMostCustomerWealth = 17;
    int actualWealth = mostWealth(accounts);

    System.out.println("Actual wealth: " + actualWealth + ", expected: " + expectedMostCustomerWealth);

    int listWealth = mostCustomerWealthJavaList(accounts);
    System.out.println("List Wealth: " + listWealth);
  }

  int mostWealth(int[][] customerBanks) {
    int maxWealth = 0;
    for (int[] banks : customerBanks) {
      int wealth = 0;
      for (int i : banks) {
        wealth += i;
      }
      if (maxWealth <= wealth) {
        maxWealth = wealth;
      }
    }
    return maxWealth;
  }

  int mostCustomerWealthJavaList(int[][] customerBanks) {
    return Arrays.stream(customerBanks).map(banks ->
        Arrays.stream(banks).reduce(Integer::sum).orElse(0)
    ).max(Comparator.comparing(x -> x)).orElse(0);
  }

  public static void main(String[] args) {
    new RichestCustomer().richestCustomerMain();
  }
}
