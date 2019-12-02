package jp.flywheel;

public class MyBin {
  public static void main(String[] args) {
    System.out.println(String.format("%d", "hello"));
    /*
    error: [FormatString] illegal format conversion: 'java.lang.String' cannot be formatted using '%d'
    System.out.println(String.format("%d", "hello"));
    */
  }
}
