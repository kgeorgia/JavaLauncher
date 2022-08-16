package kgeorgia.school21.Aircraft;

import kgeorgia.school21.Tower.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    String introduce();
}
