package kgeorgia.school21.AirCraft;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable result;
        switch (type.toLowerCase()) {
            case ("jetplane"):
                result = new JetPlane(name, coordinates);
                break;
            case ("helicopter"):
                result = new Helicopter(name, coordinates);
                break;
            case ("baloon"):
                result = new Baloon(name, coordinates);
                break;
            default:
                System.out.println("unknown type Aircraft");
                return null;
        }
        System.out.println(type + " " + name + " was created!");

        return result;
    }

}
