package classes.assessment.db;

import java.util.TreeMap;

public class MyClass {

    public class Algorithm {
        public TreeMap<Long, Double> timeStamps = new TreeMap<>(); // Keep TreeMap for sorted order

        public void add(Long timestampMs, double rate) {
            timeStamps.put(timestampMs, rate);
        }

        public double getRate(Long timestampMs) {
            // Retrieve first and last keys efficiently
            Long firstKey = timeStamps.firstKey();
            Long lastKey = timeStamps.lastKey();

            // If exact timestamp exists, return the rate directly
            if (timeStamps.containsKey(timestampMs)) {
                return timeStamps.get(timestampMs);
            }

            // Check if the timestamp is out of bounds (before first or after last)
            if (timestampMs <= firstKey) {
                return timeStamps.firstEntry().getValue();
            } else if (timestampMs >= lastKey) {
                return timeStamps.lastEntry().getValue();
            }

            // Otherwise, find the closest timestamps for interpolation
            Long lowerKey = timeStamps.floorKey(timestampMs);
            Long upperKey = timeStamps.ceilingKey(timestampMs);

            // If no exact or surrounding timestamps exist, return a default value
            if (lowerKey == null || upperKey == null) {
                return 0.0; // Handle missing values appropriately
            }

            // Linear interpolation
            double lowerRate = timeStamps.get(lowerKey);
            double upperRate = timeStamps.get(upperKey);
            return linearInterpolate(lowerKey, upperKey, lowerRate, upperRate, timestampMs);
        }

        // Linear interpolation formula
        private double linearInterpolate(long x0, long x1, double y0, double y1, long x) {
            return y0 + ((y1 - y0) * (double) (x - x0)) / (double) (x1 - x0);
        }
    }

    public void run() {
        Algorithm algorithm = new Algorithm();
        algorithm.add(1000L, 1.102);
        algorithm.add(1010L, 1.104);
        algorithm.add(1020L, 1.095);

        // Test with exact and non-exact timestamp
        double exactResult = algorithm.getRate(1000L);
        double lowestResult = algorithm.getRate(100L);   // Below the first timestamp
        double highestResult = algorithm.getRate(1030L); // Above the last timestamp
        double interpolatedResult = algorithm.getRate(1004L); // Should interpolate between 1000L and 1010L

        System.out.println("Exact rate at 1000L: " + exactResult);
        System.out.println("Interpolated rate at 1004L: " + interpolatedResult);
        System.out.println("Lowest value (before first): " + lowestResult);
        System.out.println("Highest value (after last): " + highestResult);
    }

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.run();
    }
}


