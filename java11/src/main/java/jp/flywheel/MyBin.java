// src/main/java/jp/flywheel/MyBin.java
package jp.flywheel;

import java.util.List;
import java.util.function.IntFunction;

public class MyBin {
  public static void main(String[] args) {
    // Java9
    List<String> numbers = List.of("a", "b", "c");

    // Java10
    for (var n : numbers) {
      System.out.print(n + " ");
    }
    System.out.println();

    // Java11
    IntFunction<Integer> f = (var n) -> n + 1;
    System.out.println(f.apply(10));
  }
}
