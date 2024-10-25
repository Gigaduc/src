package cgg.a01;

import cgtools.Color;

public class Main {
    public static void main(String[] args) {
        final int width = 1920;   // HD width
        final int height = 1080;  // HD height

        // Dunklerer Hintergrund für besseren Kontrast
        Color background = new Color(0.05, 0.05, 0.05);
        ColoredDiscs content = new ColoredDiscs(12, background);

        Image image = new Image(width, height);
        
        // Berechne Aspekt-Ratio für korrekte Kreis-Form
        double aspectRatio = (double) width / height;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Normalisierte Koordinaten mit Aspekt-Ratio-Korrektur
                double normX = (2.0 * i / width - 1) * aspectRatio;
                double normY = 2.0 * j / height - 1;
                
                image.setPixel(i, j, content.getColor(normX, normY));
            }
        }

        final String filename = "doc/a01-sharp-discs-hd.png";
        image.write(filename);
        System.out.println("Wrote sharp HD image: " + filename);
    }
}