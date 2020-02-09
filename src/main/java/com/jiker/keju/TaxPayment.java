package com.jiker.keju;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaxPayment {

    public static final int BASE_PRICE = 6;

    public String calculate() throws IOException, URISyntaxException {
        URI uri = getClass().getClassLoader().getResource("testData.txt").toURI();
        Stream<String> lines = Files.lines(Paths.get(uri));
        lines.map(line -> {
            System.out.println("line = " + line);
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            String group = matcher.group();
            matcher.find();
            String group1 = matcher.group();
            System.out.println("group = " + group);
            System.out.println("group = " + group1);
            return new int[] { Integer.parseInt(group), Integer.parseInt(group1)};
        }).collect(Collectors.toList());
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
