package com.exxeta.loccounter;

import com.exxeta.loccounter.process.Processor;

public class Main {

  public static void main(String[] args) {
    var processor = new Processor();
    processor.process("src/test/java/com/exxeta/loccounter");
  }
}
