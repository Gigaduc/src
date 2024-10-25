package cgg.a01;

import cgtools.Color;

public class Main {

  public static void main(String[] args) {
    final int width = 512;
    final int height = 256;

    // Create a ColoredDiscs object with 10 random discs and a manually defined black background
    Color black = new Color(0, 0, 0);  // Define black color
    ColoredDiscs content = new ColoredDiscs(10, black);

    // Creates an image and iterates over all pixel positions inside the image
    Image image = new Image(width, height);
    for (int i = 0; i != width; i++) {
      for (int j = 0; j != height; j++) {
        // Normalize pixel coordinates to range [-1, 1]
        double normX = 2.0 * i / width - 1;
        double normY = 2.0 * j / height - 1;

        // Sets the color for one particular pixel based on the discs
        image.setPixel(i, j, content.getColor(normX, normY));
      }
    }

    // Write the image to disk
    final String filename = "doc/a01-discs.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}
