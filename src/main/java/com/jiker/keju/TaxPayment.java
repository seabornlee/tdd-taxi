package com.jiker.keju;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TaxPayment {

    public static final int BASE_PRICE = 6;

    public String calculate() {
        int[][] input = new int[][] {
                {1, 0},
                {3, 0},
                {10, 0},
                {2, 3}
        };
        return Arrays.asList(input).stream()
                .map(array -> calc(array[0], array[1]))
                .map(amount -> String.format("收费%d元", amount))
                .collect(Collectors.joining("\n"));
    }

    public int calc(int distance, int waitTimeInMinutes) {
        return (int) (distanceAmount(distance) + waitTimeInMinutes * 0.25);
    }

    private double distanceAmount(int distance) {
        if (distance <= 2) {
            return BASE_PRICE;
        }

        if (distance <= 8) {
            return BASE_PRICE + (distance - 2) * 0.8;
        }
        
        return (int) (distanceAmount(8) + (distance - 8) * 0.8 * 1.5);
    }
}
