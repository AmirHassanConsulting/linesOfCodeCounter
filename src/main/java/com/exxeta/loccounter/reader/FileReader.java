package com.exxeta.loccounter.reader;

import com.exxeta.loccounter.reader.dto.LocFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

  /**
   * Transforms a list of files to a list with the customized representation of LocFile.
   *
   * @param files The list of files that should be transformed
   * @return a list of LocFiles
   */
  public List<LocFile> getLocFiles(List<File> files) {
    List<LocFile> locFiles = new ArrayList<>(files.size());
    for (File file : files) {
      locFiles.add(createLocFile(file.getPath()));
    }
    return locFiles;
  }

  /**
   * Builds a LocFile from the given filepath.
   *
   * @param filepath The filepath from which the LocFile should be created
   * @return the newly build LocFile
   */
  private static LocFile createLocFile(String filepath) {
    var locFile = new LocFile(filepath);
    try (BufferedReader reader = Files.newBufferedReader(Path.of(locFile.getFilepath()),
        StandardCharsets.UTF_8)) {
      String line = reader.readLine();

      while (line != null) {
        if (isLineOfCode(line)) {
          locFile.setLinesOfCode(locFile.getLinesOfCode() + 1);
        }
        locFile.setLines(locFile.getLines() + 1);
        line = reader.readLine();
      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return locFile;
  }

  /**
   * Retrieves if a line is line of code or not.
   *
   * @param line a single line of a file
   * @return false if line is null, empty or is a single line comment that starts with '//',
   * otherwise true.
   */
  private static boolean isLineOfCode(String line) {
    return line != null && !(line.trim().startsWith("//") || line.isEmpty());
  }
}
