package utils;

public class CoordinatesConverter {
  public static Point cartesianToViewport(Point point, CartesianPlane cartesianPlane, ViewportPlane viewportPlane) {
    final float x = viewportPlane.width / (cartesianPlane.xMax - cartesianPlane.xMin) * (point.x - cartesianPlane.xMin);
    final float y = viewportPlane.height - viewportPlane.height / (cartesianPlane.yMax - cartesianPlane.yMin) * (point.y - cartesianPlane.yMin);

    return new Point(x, y);
  }

  public static Point viewportToCartesian(Point point, CartesianPlane cartesianPlane, ViewportPlane viewportPlane) {
    final float x = cartesianPlane.xMin + (cartesianPlane.xMax - cartesianPlane.xMin) / viewportPlane.width * point.x;
    final float y = cartesianPlane.yMax - (cartesianPlane.yMax - cartesianPlane.yMin) / viewportPlane.height * point.y;

    return new Point(x, y);
  }

}
