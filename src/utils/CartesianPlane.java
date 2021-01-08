package utils;

public class CartesianPlane {
  public final float xMin;
  public final float xMax;
  public final float yMin;
  public final float yMax;

  public CartesianPlane(float xMax, float xMin, float yMax, float yMin) {
    this.xMin = xMin;
    this.xMax = xMax;
    this.yMax = yMax;
    this.yMin = yMin;
  }

}
