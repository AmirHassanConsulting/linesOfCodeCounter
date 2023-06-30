package com.exxeta.loccounter.reader.dto;

public class LocFile {

  private final String filepath;
  private int lines;
  private int linesOfCode;

  public LocFile(String filepath) {
    this.filepath = filepath;
  }

  public String getFilepath() {
    return filepath;
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
