package com.robocafaz.gwplayer.main.util;

import java.util.Date;

public class Logger {
  private static final String ERROR = "ERROR";
  private static final String DEBUG = "DEBUG";
  private static final String INFO = " INFO";

  public static void logError(String message) {
    logMessage(ERROR, message);
  }

  public static void logDebug(String message) {
    logMessage(DEBUG, message);
  }

  public static void logMessage(String message) {
    logMessage(INFO, message);
  }

  public static void logMessage(String header, String message) {
    System.out.println("[" + new Date() + "] " + header + " - " + message);
  }
}
