package kgeorgia.school21.AirCraft;

import kgeorgia.school21.Tower.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    String introduce();
}
