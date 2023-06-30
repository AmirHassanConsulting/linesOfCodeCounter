package com.exxeta.loccounter.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class FileCollector {

  /**
   * @param filepath
   * @return
   */
  public List<File> getFiles(String filepath) {
    try (Stream<Path> paths = Files.walk(Paths.get(filepath))) {
      return paths
          .filter(Files::isRegularFile)
          .map(Path::toFile)
          .toList();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }
}
