package cgg.a01;

import cgtools.Color;

public class DiscModel {
    private double centerX;
    private double centerY;
    private double radius;
    private Color color;

    // Constructor to initialize center, radius, and color of the disc
    public DiscModel(double centerX, double centerY, double radius, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
    }

    // Check if a given point (x, y) is within this disc
    public boolean coversPoint(double x, double y) {
        double distanceSquared = Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2);
        return distanceSquared <= Math.pow(radius, 2); // Point is within the radius
    }

    // Get the radius of the disc
    public double getRadius() {
        return radius;
    }

    // Get the color of the disc
    public Color getColor() {
        return color;
    }
}
