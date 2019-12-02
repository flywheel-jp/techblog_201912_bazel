// src/test/java/jp/flywheel/MyLibTest.java
package jp.flywheel;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyLibTest {
  @Test
  public void testFibonacci() {
    assertEquals(144, MyLib.fibonacci(12));
  }
}
