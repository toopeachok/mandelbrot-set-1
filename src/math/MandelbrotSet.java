package math;

public class MandelbrotSet {

  public static boolean isInSet(ComplexNumber c) {
    ComplexNumber z = new ComplexNumber(0, 0);
    final int MAX_ITERATIONS = 1000;
    int i = 0;

    while (z.getRe() * z.getRe() + z.getIm() * z.getIm() < 4 && i < MAX_ITERATIONS) {
      z = ComplexNumber.multiply(z, z);
      z = ComplexNumber.sum(z, c);
      i++;
    }

    return !(i < MAX_ITERATIONS);
  }

}