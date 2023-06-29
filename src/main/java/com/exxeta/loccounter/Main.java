package com.exxeta.loccounter;

import com.exxeta.loccounter.process.Coordinator;

public class Main {

  public static void main(String[] args) {
    Coordinator.start("src/test/java/com/exxeta/loccounter");
//    System.out.println("hello");
  }
}
