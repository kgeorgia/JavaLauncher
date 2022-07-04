package kgeorgia.school21.Tower;

import kgeorgia.school21.AirCraft.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static final WeatherProvider weatherProvider = new WeatherProvider();

    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int seed = new Random().nextInt(100);
        seed += coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        return weather[seed % 4];
    }
}
