package com.exxeta.loccounter.process;

import com.exxeta.loccounter.output.Printer;
import com.exxeta.loccounter.output.dto.LocCounterOutput;
import com.exxeta.loccounter.reader.FileCollector;
import com.exxeta.loccounter.reader.FileReader;

public class Processor {

  /**
   * @param filepath
   */
  public void process(String filepath) {
    var fileCollector = new FileCollector();
    var fileReader = new FileReader();
    var printer = new Printer();

    var files = fileCollector.getFiles(filepath);
    var locFiles = fileReader.getLocFiles(files);
    printer.print(new LocCounterOutput(locFiles));
  }
}