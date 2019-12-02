// src/main/java/jp/flywheel/MyBin.java
package jp.flywheel;

public class MyBin {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    System.out.println("Hello Bazel!");
    System.out.println("Fib(" + n + ") = " + MyLib.fibonacci(n));
  }
}
