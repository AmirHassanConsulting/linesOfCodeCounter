package com.exxeta.loccounter.process;

import com.exxeta.loccounter.output.Printer;
import com.exxeta.loccounter.output.dto.LocCounterOutput;
import com.exxeta.loccounter.reader.FileCollector;
import com.exxeta.loccounter.reader.FileReader;

public class Processor {

  /**
   * Central method to call all classes for retrieving and converting the desired files and for
   * printing the calculation result to the console.
   *
   * @param filepath The filepath in which the files should be searched, converted and used for
   *                 calculation.
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