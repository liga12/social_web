package controller;

import java.text.MessageFormat;
import java.util.Date;

public class TestFormat {

  public static void main(String[] args) {

    String s = "45";
    String result = MessageFormat.format(
        "At  on planet {0}.",
        s);
    System.out.println(result);
  }
}

