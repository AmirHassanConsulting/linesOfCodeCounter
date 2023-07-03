package com.exxeta.loccounter.output.dto;

import com.exxeta.loccounter.reader.dto.LocFile;
import java.util.List;

/**
 * The DTO to represent the console output after calculating the lines of code.
 */
public class LocCounterOutput {

  /**
   * A list of all LocFiles that should be included in console output.
   */
  private final List<LocFile> locFiles;

  /**
   * The sum of all lines of all LocFiles included in the LocFile list.
   */
  private int linesSum;

  /**
   * The sum of all lines of code of all LocFiles included in the LocFile list.
   */
  private int linesOfCodeSum;

  public LocCounterOutput(List<LocFile> locFiles) {
    this.locFiles = locFiles;
    calculateTotalLines();
    calculateTotalLinesOfCode();
  }

  private void calculateTotalLines() {
    locFiles.forEach(locFile -> linesSum += locFile.getLines());
  }

  private void calculateTotalLinesOfCode() {
    locFiles.forEach(locFile -> linesOfCodeSum += locFile.getLinesOfCode());
  }

  public String toString() {
    var outputString = new StringBuilder();
    locFiles.forEach(locFile -> outputString.append(locFile.toString()).append("\n"));
    outputString
        .append("\nTotal:")
        .append("\n    Lines: ")
        .append(linesSum)
        .append("\n    LOC: ")
        .append(linesOfCodeSum);

    return outputString.toString();
  }
}
