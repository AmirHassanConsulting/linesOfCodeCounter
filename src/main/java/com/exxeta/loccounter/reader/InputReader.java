package com.exxeta.loccounter.reader;

import com.exxeta.loccounter.process.LocFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

  public static List<LocFile> getLocFiles(List<File> files) {
    List<LocFile> locFiles = new ArrayList<>(files.size());
    for (File file : files) {
      locFiles.add(getLocFile(new LocFile(file.getPath(), 0, 0)));
    }
    return locFiles;
  }

  private static LocFile getLocFile(LocFile locFile) {
    try (BufferedReader reader = Files.newBufferedReader(Path.of(locFile.getFilepath()),
        StandardCharsets.UTF_8)) {

      while ((reader.readLine()) != null) {
        if (isCode(reader.readLine())) {
          locFile.setLinesOfCode(locFile.getLinesOfCode() + 1);
        }
        locFile.setLines(locFile.getLines() + 1);
      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return locFile;
  }

  private static boolean isCode(String line) {
    if (line == null) {
      return false;
    }
    return line.trim().startsWith("//") || line.trim().startsWith("*") || line.isEmpty();
  }
}
