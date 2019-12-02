// src/main/java/jp/flywheel/MyLib.java
package jp.flywheel;

public class MyLib {
  public static int fibonacci(int n) {
    if (n < 0) {
      throw new IllegalArgumentException();
    } else if (n == 0 || n == 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
