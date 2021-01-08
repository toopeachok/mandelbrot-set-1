import math.ComplexNumber;
import math.MandelbrotSet;
import utils.CartesianPlane;
import utils.CoordinatesConverter;
import utils.Point;
import utils.ViewportPlane;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class MandelbrotPainter {
  public static void main(String[] args) throws Exception {
    CartesianPlane cartesianPlane = new CartesianPlane(2, -2, 2, -2);

    final int width = 640, height = 640;

    ViewportPlane viewportPlane = new ViewportPlane(width, height);

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    final int black = 0x000000, white = 0xFFFFFF;

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        Point viewportPoint = new Point(col, row);
        Point cartesianPoint = CoordinatesConverter.viewportToCartesian(viewportPoint, cartesianPlane, viewportPlane);
        float c_re = cartesianPoint.x;
        float c_im = cartesianPoint.y;
        ComplexNumber c = new ComplexNumber(c_re, c_im);

        if (MandelbrotSet.isInSet(c)) {
          image.setRGB(col, row, black);
        } else {
          image.setRGB(col, row, white);
        }

      }
    }

    ImageIO.write(image, "png", new File("mandelbrot.png"));
  }
}
