package com.exxeta.loccounter.process;

import com.exxeta.loccounter.output.LocCounterOutput;
import com.exxeta.loccounter.reader.InputReader;

public class Coordinator {

  public static void start(String filepath) {
    var files = LocFile.getFiles(filepath);
    var locFiles = InputReader.getLocFiles(files);
    System.out.println(new LocCounterOutput(locFiles));
  }
}
