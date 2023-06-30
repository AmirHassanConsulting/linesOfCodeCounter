package com.exxeta.loccounter.output.dto;

import com.exxeta.loccounter.reader.dto.LocFile;
import java.util.List;

public class LocCounterOutput {

  private final List<LocFile> locFiles;
  private int linesSum;
  private int linesOfCodeSum;

  public LocCounterOutput(List<LocFile> locFiles) {
    this.locFiles = locFiles;
    calculateTotalLines();
    calculateTotalLinesOfCode();
  }

  public void calculateTotalLines() {
    locFiles.forEach(file -> linesSum += file.getLines());
  }

  public void calculateTotalLinesOfCode() {
    locFiles.forEach(file -> linesOfCodeSum += file.getLinesOfCode());
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
