package cgg.a01;

import cgtools.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColoredDiscs {
    private List<DiscModel> discs;
    private Color backgroundColor;

    // Constructor to initialize the collection of random discs and background color
    public ColoredDiscs(int numDiscs, Color backgroundColor) {
        this.discs = new ArrayList<>();
        this.backgroundColor = backgroundColor;
        Random rand = new Random();

        // Generate random discs
        for (int i = 0; i < numDiscs; i++) {
            double centerX = rand.nextDouble() * 2 - 1; // Random x in range [-1, 1]
            double centerY = rand.nextDouble() * 2 - 1; // Random y in range [-1, 1]
            double radius = rand.nextDouble() * 0.5;    // Random radius in range [0, 0.5]
            Color color = new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()); // Random color

            discs.add(new DiscModel(centerX, centerY, radius, color));
        }
    }

    // Method to get the color of the disc covering the point (x, y)
    public Color getColor(double x, double y) {
        DiscModel smallestDisc = null;

        // Check all discs and find the smallest one that covers the point (x, y)
        for (DiscModel disc : discs) {
            if (disc.coversPoint(x, y)) {
                if (smallestDisc == null || disc.getRadius() < smallestDisc.getRadius()) {
                    smallestDisc = disc;
                }
            }
        }

        // If a disc covers the point, return its color; otherwise, return the background color
        return smallestDisc != null ? smallestDisc.getColor() : backgroundColor;
    }
}
