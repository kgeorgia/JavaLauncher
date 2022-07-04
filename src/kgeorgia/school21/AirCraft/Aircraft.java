package kgeorgia.school21.AirCraft;

import java.util.HashMap;
import java.util.Map;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Map<String, int[]> changes;
    protected Map<String, String> msg = new HashMap<String, String>() {
        private static final long serialVersionUID = -3843273024432499579L;
        {
            put("SUN", "this is hot.");
            put("RAIN", "it's raining. Better watch out for lighting.");
            put("FOG", "it's foggy now.");
            put("SNOW", "OMG! Winter is coming!");
        }
    };


    static private long id_Counter = 0;

    Aircraft(String name, Coordinates coordinates) {
        this.id = Aircraft.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private static long nextId() { return (Aircraft.id_Counter++); }

    protected void changeCoordinates(String weather) {
        if (this.changes == null) {
            return;
        }
        int[] change = this.changes.get(weather);

        if (change != null) {
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + change[0],
                    this.coordinates.getLatitude() + change[1],
                    this.coordinates.getHeight() + change[2]
            );
        }
    }

    public String getName() { return this.name; }

    public String getIdStr() { return Long.toString(this.id); }

}
