package kgeorgia.school21.Aircraft;

import kgeorgia.school21.Tower.WeatherTower;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.changes = new HashMap<String, int[]>() {
          private static final long serialVersionUID = -5571445132215817865L;
            {
                put("SUN", new int[]{10, 0, 2});
                put("RAIN", new int[]{5, 0, 0});
                put("FOG", new int[]{1, 0, 0});
                put("SNOW", new int[]{0, 0, -12});
            }
        };
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        this.changeCoordinates(weather);
        System.out.println(this.introduce() + ": I'am Helicopter, "
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

    public String introduce() { return "Helicopter#" + this.getName() + "(" + this.getIdStr() + ")"; }
}
