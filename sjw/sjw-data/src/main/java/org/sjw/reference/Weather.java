package org.sjw.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Weather {
    Sunny,
    Hot,
    Cold,
    Rainy,
    Windy,
    Normal,
    Typhoon;

    private static List<Weather> drySeason = new ArrayList<>(Arrays.asList(Weather.values()));
    private static List<Weather> wetSeason = new ArrayList<>(Arrays.asList(Weather.values()));
    private static Random rngsus = new Random();

    static {
        drySeason.add(Sunny);
        drySeason.add(Sunny);
        drySeason.add(Hot);
        drySeason.add(Hot);
        drySeason.add(Windy);

        wetSeason.add(Cold);
        wetSeason.add(Cold);
        wetSeason.add(Rainy);
        wetSeason.add(Rainy);
        wetSeason.add(Typhoon);
        wetSeason.add(Typhoon);
    }

    public static Weather random(int monthOfYear) {
        if (monthOfYear > 4 && monthOfYear < 11) {
            return wetSeason.get(rngsus.nextInt(wetSeason.size() - 1));
        } else {
            return drySeason.get(rngsus.nextInt(wetSeason.size() - 1));
        }
    }
}
