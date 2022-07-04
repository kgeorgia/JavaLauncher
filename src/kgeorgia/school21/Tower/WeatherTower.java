package kgeorgia.school21.Tower;

import kgeorgia.school21.AirCraft.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }

    public void weatherChanged() {
        this.changeWeather();
    }
}
