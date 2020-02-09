package com.jiker.keju;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String result = calculate();
        System.out.println(result);
    }

    public static String calculate() throws IOException, URISyntaxException {
        URI uri = TaxPayment.class.getClassLoader().getResource("testData.txt").toURI();
        return Files.lines(Paths.get(uri))
                .map(App::extractDistanceAndTime)
                .map(array -> new TaxPayment().calc(array[0], array[1]))
                .map(amount -> String.format("收费%d元", amount))
                .collect(Collectors.joining("\n"));
    }

    private static int[] extractDistanceAndTime(String line) {
        Matcher matcher = Pattern.compile("\\d+").matcher(line);
        matcher.find();
        String distance = matcher.group();
        matcher.find();
        String time = matcher.group();
        return new int[]{Integer.parseInt(distance), Integer.parseInt(time)};
    }
}
