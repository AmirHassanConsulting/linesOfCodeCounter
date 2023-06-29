package com.exxeta.loccounter.process;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocFile {

  private String filepath;
  private int lines;
  private int linesOfCode;

  public LocFile(String filepath, int lines, int linesOfCode) {
    this.filepath = filepath;
    this.lines = lines;
    this.linesOfCode = linesOfCode;
  }

  public static List<java.io.File> getFiles(String filepath) {
    // get Files
    listFilesUsingJavaIO(filepath);
    return null;
  }

  public static Set<String> listFilesUsingJavaIO(String filepath) {
    return Stream.of(Objects.requireNonNull(new File(filepath).listFiles()))
        .filter(file -> !file.isDirectory())
        .map(File::getName)
        .collect(Collectors.toSet());
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
