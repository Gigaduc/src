package cgg.a01;

import cgtools.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColoredDiscs {
    // Klassenattribute
    private List<DiscModel> discs;
    private Color backgroundColor;

    // Konstruktor zum Initialisieren der Sammlung zufälliger Scheiben und Hintergrundfarbe
    public ColoredDiscs(int numDiscs, Color backgroundColor) {
        this.discs = new ArrayList<>();
        this.backgroundColor = backgroundColor;
        Random rand = new Random();

        // Generiere zufällige Scheiben
        for (int i = 0; i < numDiscs; i++) {
            double centerX = rand.nextDouble() * 2 - 1;    // Zufälliges x im Bereich [-1, 1]
            double centerY = rand.nextDouble() * 2 - 1;    // Zufälliges y im Bereich [-1, 1]
            double radius = rand.nextDouble() * 0.3 + 0.1; // Radius zwischen 0.1 und 0.4
            
            // Erzeuge kräftige Farben mit Gamma-Korrektur
            Color color = new Color(
                Math.pow(rand.nextDouble(), 0.5),
                Math.pow(rand.nextDouble(), 0.5),
                Math.pow(rand.nextDouble(), 0.5)
            );

            discs.add(new DiscModel(centerX, centerY, radius, color));
        }
    }

    // Methode zum Ermitteln der Farbe der Scheibe, die den Punkt (x, y) überdeckt
    public Color getColor(double x, double y) {
        DiscModel visibleDisc = null;
        double minRadius = Double.MAX_VALUE;

        // Prüfe alle Scheiben und finde die kleinste, die den Punkt (x, y) überdeckt
        for (DiscModel disc : discs) {
            if (disc.coversPoint(x, y)) {
                if (disc.getRadius() < minRadius) {
                    minRadius = disc.getRadius();
                    visibleDisc = disc;
                }
            }
        }

        // Wenn eine Scheibe den Punkt überdeckt, gib ihre Farbe zurück,
        // ansonsten die Hintergrundfarbe
        return visibleDisc != null ? visibleDisc.getColor() : backgroundColor;
    }
}