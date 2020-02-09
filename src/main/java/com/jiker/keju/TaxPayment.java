package com.jiker.keju;

public class TaxPayment {
    private static final int BASE_PRICE = 6;

    public long calc(int distance, int waitTimeInMinutes) {
        return Math.round(distanceAmount(distance) + waitTimeAmount(waitTimeInMinutes));
    }

    private double waitTimeAmount(int waitTimeInMinutes) {
        return waitTimeInMinutes * 0.25;
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
