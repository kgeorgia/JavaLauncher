package kgeorgia.school21.Simulation;

import kgeorgia.school21.AirCraft.AircraftFactory;
import kgeorgia.school21.AirCraft.Flyable;
import kgeorgia.school21.Tower.WeatherTower;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {

    private static Integer SimulationCycles;
    private static WeatherTower tower;

    public static class SimulationException extends Exception {
        private static final long serialVersionUID = -3512663813315852859L;

        public SimulationException() { super(); }
        public SimulationException(String str) { super(str); }
        public SimulationException(Throwable throwable) { super(throwable); }
    }

    private static void ParseFile(File file) throws SimulationException {
        try {
            String line;
            Flyable aircraft;
            tower = new WeatherTower();
            BufferedReader buf = new BufferedReader(new FileReader(file));

            Simulation.SimulationCycles = Integer.parseInt(buf.readLine());

            while ((line = buf.readLine()) != null) {
                String[] record = line.split("\\s+");
                aircraft = AircraftFactory.newAircraft(record[0], record[1],
                        Integer.parseInt(record[2]), Integer.parseInt(record[3]),
                        Integer.parseInt(record[4]));
                if (aircraft != null) {
                    aircraft.registerTower(tower);
                }
            }
            
        } catch (NullPointerException | IOException e) {
            throw new SimulationException(e);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong numbers of arguments!");
            return;
        }

        try {
            Simulation.ParseFile(new File(args[0]));
            while (SimulationCycles-- > 0) {
                    tower.weatherChanged();
            }
        } catch (SimulationException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
