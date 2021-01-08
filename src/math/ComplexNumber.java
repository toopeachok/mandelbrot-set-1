package math;

/**
 * <h1>Complex Numbers</h1>
 * The math.ComplexNumber program implements an application that
 * allows to calculate complex numbers
 **/

public class ComplexNumber {

  /**
   * Represents the real part of a complex number
   */
  private final double re;

  /**
   * Represents imaginary part of a complex number
   */
  private final double im;

  public ComplexNumber(double re, double im) {
    this.re = re;
    this.im = im;
  }

  public double getRe() {
    return re;
  }

  public double getIm() {
    return im;
  }

  /**
   * @return modulus (or absolute value) of the number
   */
  private double getModule() {
    return Math.sqrt(this.re * this.re + this.im * this.im);
  }

  /**
   * Allows to get the sum of two complex numbers given in the parameters.
   *
   * @return the new complex number
   */
  public static ComplexNumber sum(ComplexNumber cn1, ComplexNumber cn2) {
    return new ComplexNumber(cn1.getRe() + cn2.getRe(), cn1.getIm() + cn2.getIm());
  }

  /**
   * Allows to get the product of two complex numbers given in the parameters.
   *
   * @return the new complex number
   */
  public static ComplexNumber multiply(ComplexNumber cn1, ComplexNumber cn2) {
    return new ComplexNumber(cn1.getRe() * cn2.getRe() - cn1.getIm() * cn2.getIm(), cn1.getRe() * cn2.getIm() + cn1.getIm() * cn2.getRe());
  }

  /**
   * Allows to get the difference of two complex numbers given in the parameters.
   *
   * @return the new complex number
   */
  public static ComplexNumber subtract(ComplexNumber cn1, ComplexNumber cn2) {
    return new ComplexNumber(cn1.getRe() - cn2.getRe(), cn1.getIm() - cn2.getIm());
  }

  /**
   * Allows to get the product of two complex numbers given in the parameters.
   *
   * @return the new complex number
   */
  public static ComplexNumber divide(ComplexNumber cn1, ComplexNumber cn2) {
    ComplexNumber temp = new ComplexNumber(cn2.getRe(), (-1) * cn2.getIm());
    temp = ComplexNumber.multiply(cn1, temp);
    double denominator = cn2.getRe() * cn2.getRe() + cn2.getIm() * cn2.getIm();
    return new ComplexNumber(temp.getRe() / denominator, temp.getIm() / denominator);
  }

  /**
   * This function allows to get the argument of complex number to represent it in trigonometric form
   *
   * @return argument of complex number
   */
  private double GetArg() {
    if (this.re > 0) {
      return Math.atan(im / re);
    } else {
      if (re < 0 && im > 0) {
        return Math.PI + Math.atan(im / re);
      } else {
        return -Math.PI + Math.atan(im / re);
      }
    }
  }

  /**
   * Allows to raise complex number to specified power with the help of de Moivre's formula.
   *
   * @param cn    needed complex number (the base)
   * @param power the exponent
   * @return the new complex number
   */
  public static ComplexNumber pow(ComplexNumber cn, int power) {
    double factor = Math.pow(cn.getModule(), power);
    return new ComplexNumber(factor * Math.cos(power * cn.GetArg()), factor * Math.sin(power * cn.GetArg()));
  }

  /**
   * The function of getting square roots of complex number cn
   *
   * @return an array of pair of square roots
   */
  public static ComplexNumber[] sqrt(ComplexNumber cn) {
    double a = cn.getModule() / 2;
    ComplexNumber pos = new ComplexNumber(Math.sqrt(a + cn.getRe() / 2), Math.signum(cn.getIm()) * Math.sqrt(a - cn.getRe() / 2));
    ComplexNumber neg = new ComplexNumber((-1) * pos.getRe(), (-1) * pos.getIm());
    return new ComplexNumber[]{pos, neg};
  }

  /**
   * Defines and returns the sign required for correct record of a number
   *
   * @return string with appropriate sign
   */
  private String sign() {
    if (im > 0) return " + ";
    else return " - ";
  }

  @Override
  public String toString() {
    String string;
    if (im == 1 || im == -1) {
      if (re == 0) {
        string = sign() + "i";
      } else {
        string = re + sign() + "i";
      }
    } else {
      string = re + sign() + Math.abs(im) + "i";
    }
    return string;
  }

  @Override
  public boolean equals(Object obj) {
    return this.getClass() == obj.getClass();
  }

  /**
   * In this function main test on the correctness of this program are done.
   * All operations on complex numbers are shown.
   */
  public static void main(String[] args) {
    ComplexNumber x = new ComplexNumber(2, 3);
    ComplexNumber y = new ComplexNumber(-1, 2);
    System.out.println("z1 = " + x + ",     z2 = " + y);

    ComplexNumber z;
    z = ComplexNumber.sum(x, y);
    System.out.println("+ : " + z);

    z = ComplexNumber.subtract(x, y);
    System.out.println("- : " + z);

    z = ComplexNumber.divide(x, y);
    System.out.println("/ : " + z);

    z = ComplexNumber.multiply(x, y);
    System.out.println(" * :" + z);

    z = ComplexNumber.pow(y, 2);
    System.out.println("Pow 2 of z2 : " + z);

    ComplexNumber b = new ComplexNumber(3, 4);
    ComplexNumber[] ans = ComplexNumber.sqrt(b);
    System.out.println("Sqrt of " + b + " = " + ans[0] + ",  " + ans[1]);

  }
}