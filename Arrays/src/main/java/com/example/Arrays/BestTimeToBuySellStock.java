package com.example.Arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public class BestTimeToBuySellStock {

  static class ProfitPlan {
    public int buyOn = -1;
    public int sellOn = -1;
    public int profit = 0;

    public ProfitPlan() {

    }

    public ProfitPlan(int buyOn, int sellOn, int profit) {
      this.buyOn = buyOn;
      this.sellOn = sellOn;
      this.profit = profit;
    }

    @Override
    public String toString() {
      return "BuyOn: " + buyOn + ", sellOn: " + sellOn + ", profit: " + profit;
    }
  }

  public ProfitPlan maxProfit(int[] prices) {

    int buyOn = -1;
    int sellOn = -1;


    for (int i = 0; i < prices.length; i++) {

      int candidateBuyOn = buyOn >= 0 ? buyOn : i;

      if (prices[i] <= prices[candidateBuyOn]) {
        candidateBuyOn = i;
      }

      if (buyOn == -1 ||  prices[candidateBuyOn] <= prices[buyOn]) {
        buyOn = candidateBuyOn;
      }

    }

    if(buyOn == prices.length - 1){
      return new ProfitPlan();
    }

    for (int i = buyOn; i < prices.length; i++) {

      int candidateSellOn = sellOn >= 0 ? sellOn : i;

      if(prices[i] > prices[candidateSellOn]) {
        candidateSellOn = i;
      }

      if(sellOn == -1 || prices[candidateSellOn] > prices[sellOn]) {
        sellOn = candidateSellOn;
      }


    }

    if(sellOn == buyOn){
      return new ProfitPlan();
    }

    int profit = prices[sellOn] - prices[buyOn];

    //make it 1-based
    return new ProfitPlan(buyOn + 1, sellOn + 1, profit);
  }

  void test(int[] input, ProfitPlan expected, Function<int[], ProfitPlan> solution) {
    String inputText = Arrays.toString(input);
    String expectedText = expected.toString();

    ProfitPlan actual = solution.apply(input);

    String actualText = actual.toString();

    System.out.println("Input: " + inputText);
    if (Objects.equals(expectedText, actualText)) {
      System.out.println(" -- Passed : " + expectedText + " == " + actualText);
    } else {
      System.out.println(" -- Failed " + expectedText + " != " + actualText);
    }
  }

  void runSolution(Function<int[], ProfitPlan> solution) {
    test(new int[]{7, 1, 5, 3, 6, 4}, new ProfitPlan(2, 5, 5), solution);
    test(new int[]{7, 6, 4, 3, 1}, new ProfitPlan(), solution);
  }

  void runAll() {
    runSolution(this::maxProfit);
  }

  public static void main(String[] args) {
    new BestTimeToBuySellStock().runAll();
  }

}
