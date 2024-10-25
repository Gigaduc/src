/** @author hartmut.schirmacher@bht-berlin.de &&& henrik.tramberend@bht-berlin.de */
package cgg.a01;

import cgtools.*;

public class Image {
  private int width;
  private int height;
  private Color[][] pixels;
// Constructor that initializes the image with the given width and height

  public Image(int width, int height) {
    this.width = width;
    this.height = height;
    pixels = new Color[width][height];  // Array to store pixel colors

  }

  public void setPixel(int i, int j, Color color) {
    if (i < 0 || i >= width || j < 0 || j >= height){
      System.err.println("Pixel coordinates out of bounds");
      return;
    }
    pixels[i][j] = color;

  }

  public void write(String filename) {
   double[] imageArray = new double[width * height * 3];
   
   int index = 0;
   for (int j = 0; j < height; j++){
    for (int i = 0; i < width; i++){
      Color color = pixels [i][j];
      imageArray[index++] = color.r();
      imageArray[index++] = color.g();
      imageArray[index++] = color.b();
    }
   }

   ImageWriter.write(filename, imageArray, width, height);
  }

}
