package kgeorgia.school21.AirCraft;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = Math.max(height, 0);
        this.height = Math.min(this.height, 100);
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}
