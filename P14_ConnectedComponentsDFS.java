// 3. Fractional Knapsack Problem using Greedy Method
import java.util.*;
public class P03_FractionalKnapsack {
    record Item(int weight, int profit) {}

    public static void main(String[] args) {
        Item[] items = { new Item(18, 25), new Item(15, 24), new Item(10, 15) };
        int capacity = 20;
        Arrays.sort(items, (a, b) -> Double.compare((double) b.profit() / b.weight(), (double) a.profit() / a.weight()));
        double maxProfit = 0;
        for (Item it : items) {
            if (capacity >= it.weight()) {
                capacity -= it.weight();
                maxProfit += it.profit();
            } else {
                maxProfit += (double) it.profit() / it.weight() * capacity;
                break;
            }
        }
        System.out.println("Maximum Profit = " + maxProfit);
    }
}
