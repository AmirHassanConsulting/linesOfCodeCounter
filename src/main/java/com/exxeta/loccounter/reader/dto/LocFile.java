package com.exxeta.loccounter.reader.dto;

/**
 * The DTO to represent a File in the linesOfCodeCounter context.
 */
public class LocFile {

  /**
   * The full filepath of a file.
   */
  private final String filepath;

  /**
   * The amount of lines in a file.
   */
  private int lines;
  
  /**
   * The amount of lines of code in a file.
   */
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
