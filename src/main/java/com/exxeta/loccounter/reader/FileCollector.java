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
   * Retrieves all files included in the directory and subdirectories of the passed filepath.
   *
   * @param filepath the filepath from which the files should be retrieved.
   * @return a list of all files found in the given filepath or an empty collection, if no files
   * exist in the given filepath.
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
