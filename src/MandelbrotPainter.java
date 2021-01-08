import math.ComplexNumber;
import math.MandelbrotSet;
import utils.CartesianPlane;
import utils.CoordinatesConverter;
import utils.Point;
import utils.ViewportPlane;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MandelbrotPainter extends JFrame {
  private static final int WIDTH = 640, HEIGHT = 640;

  public MandelbrotPainter() {
    super("Mandelbrot Set");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    add(new Canvas());
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          new MandelbrotPainter();
        }
      }
    );
  }

  static class Canvas extends JPanel {
    private static final int WIDTH = 640, HEIGHT = 640;
    private static final int black = 0x000000, white = 0xFFFFFF;

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private final CartesianPlane cartesianPlane = new CartesianPlane(2, -2, 2, -2);
    private final ViewportPlane viewportPlane = new ViewportPlane(WIDTH, HEIGHT);

    public Canvas() {
      super(true);
      setSize(WIDTH, HEIGHT);
      render();
    }

    @Override
    public void paint(Graphics g) {
      g.drawImage(image, 0, 0, null);
    }

    public void render() {
      for (int row = 0; row < HEIGHT; row++) {
        for (int col = 0; col < WIDTH; col++) {
          final Point viewportPoint = new Point(col, row);
          final Point cartesianPoint = CoordinatesConverter.viewportToCartesian(viewportPoint, cartesianPlane, viewportPlane);
          final float c_re = cartesianPoint.x;
          final float c_im = cartesianPoint.y;
          final ComplexNumber c = new ComplexNumber(c_re, c_im);

          if (MandelbrotSet.isInSet(c)) {
            image.setRGB(col, row, black);
          } else {
            image.setRGB(col, row, white);
          }

        }
      }
    }
  }

}
