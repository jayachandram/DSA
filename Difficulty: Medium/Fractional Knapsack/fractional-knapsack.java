import java.util.*;

class Item {
    int value, weight;
    Item(int v, int w) {
        value = v;
        weight = w;
    }
}

class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        // Sort by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));
        
        double totalValue = 0.0;
        
        for (Item item : items) {
            if (W == 0) break;

            if (item.weight <= W) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                totalValue += (double)item.value * W / item.weight;
                W = 0;
            }
        }
        
        return totalValue;
    }
}
