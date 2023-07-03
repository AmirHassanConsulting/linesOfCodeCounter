package com.exxeta.loccounter;

import com.exxeta.loccounter.process.Processor;

public class Main {

  /**
   * Main method to start linesOfCodeCounter application. Here, the directory to search in can be
   * modified.
   *
   * @param args
   */
  public static void main(String[] args) {
    var processor = new Processor();
    processor.process("src/test/java/com/exxeta/loccounter");
  }
}
