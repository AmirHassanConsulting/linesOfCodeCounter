package com.exxeta.loccounter.process;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LocFile {

  private String filepath;
  private int lines;
  private int linesOfCode;

  public LocFile(String filepath, int lines, int linesOfCode) {
    this.filepath = filepath;
    this.lines = lines;
    this.linesOfCode = linesOfCode;
  }

  public static List<File> getFiles(String filepath) {
    // get Files

    try {
      return Files.walk(Paths.get(filepath))
          .filter(Files::isRegularFile)
          .map(Path::toFile)
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  public int getLines() {
    return lines;
  }

  public void setLines(int lines) {
    this.lines = lines;
  }

  public int getLinesOfCode() {
    return linesOfCode;
  }
 
  public void setLinesOfCode(int linesOfCode) {
    this.linesOfCode = linesOfCode;
  }

  public String toString() {
    return filepath + " " + lines + " " + linesOfCode;
  }
}
