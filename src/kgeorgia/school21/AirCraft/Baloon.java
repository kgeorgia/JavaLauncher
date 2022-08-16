package kgeorgia.school21.Aircraft;

import kgeorgia.school21.Tower.WeatherTower;

import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.changes = new HashMap<String, int[]>() {
            private static final long serialVersionUID = 5295911270253523350L;
            {
                put("SUN", new int[]{2, 0, 4});
                put("RAIN", new int[]{0, 0, -5});
                put("FOG", new int[]{0, 0, -3});
                put("SNOW", new int[]{0, 0, -15});
            }
        };
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        this.changeCoordinates(weather);
        System.out.println(this.introduce() + ": I'am Baloon, "
                + this.msg.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            System.out.println(this.introduce() + ": landing.");
            System.out.println("Current coordinates: Longitude: ["
                    + this.coordinates.getLongitude()
                    + "] Latitude: [" + this.coordinates.getLatitude()
                    + "] Height: [" + this.coordinates.getHeight() + "]");
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    public String introduce() {
        return "Baloon#" + this.getName() + "(" + this.getIdStr() + ")";
    }
}
