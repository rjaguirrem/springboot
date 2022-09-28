package com.rjaguirrem.springboot.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFile {
  private static final ObjectMapper mapper = new ObjectMapper();

  static {
    mapper.findAndRegisterModules();
  }

  /**
   * readDataFromFile: read data from a file.
   * @param fileName file name
   * @param className class name
   * @param <T> This describes a type parameter
   * @return a generic object
   */
  public static <T> T readDataFromFile(String fileName, Class<T> className) {
    try {
      return mapper.readValue(
              ReadFile.class.getClassLoader().getResourceAsStream(fileName), className);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

}
