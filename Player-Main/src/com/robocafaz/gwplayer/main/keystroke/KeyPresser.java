package com.robocafaz.gwplayer.main.keystroke;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import com.robocafaz.gwplayer.main.util.Logger;

public class KeyPresser {
  private static final List<Integer> ACCEPTABLE_INPUTS;
  private static Robot _robot;
  private static final ScheduledExecutorService _keyThread;

  static {
    // @formatter:off
    ACCEPTABLE_INPUTS = Arrays.asList(new Integer[] {
        KeyEvent.VK_0,
        KeyEvent.VK_1,
        KeyEvent.VK_2,
        KeyEvent.VK_3,
        KeyEvent.VK_4,
        KeyEvent.VK_5,
        KeyEvent.VK_6,
        KeyEvent.VK_7,
        KeyEvent.VK_8,
        KeyEvent.VK_9
      });
    // @formatter:on
    try {
      _robot = new Robot();
    } catch (AWTException e) {
      Logger.logError("Could not instantiate Robot due to an error!");
    }
    _keyThread = Executors.newSingleThreadScheduledExecutor();
  }

  public static void keyPress(int keyCode) {
    keyPress(keyCode, 10);
  }

  public static void keyPress(int keyCode, int duration) {
    if (_robot == null) {
      Logger.logError("Attempted to press '" + keyCode + "' when robot was not instantiated.");
      return;
    }
    if (!ACCEPTABLE_INPUTS.contains(keyCode)) {
      Logger.logError("Attempted to press an invalid keycode: '" + keyCode + "'.");
      return;
    }
    executePress(keyCode, duration);
  }

  private static void executePress(final int keyCode, int duration) {
    if (duration < 0) {
      duration = 0;
    }
    final long actualDuration = duration;
    _keyThread.execute(new Runnable() {
      @Override
      public void run() {
        Logger.logMessage("Key " + keyCode + " pressed.");
        long startTime = System.currentTimeMillis();
        do {
          _robot.keyPress(keyCode);
        } while (System.currentTimeMillis() - startTime < actualDuration);
        Logger.logMessage("Key " + keyCode + " released.");
        _robot.keyRelease(keyCode);
      }
    });
  }

  public static void shutdown() {
    _keyThread.shutdown();
  }

  public static void main(String... args) {
    KeyPresser.keyPress(KeyEvent.VK_0, 5000);
    KeyPresser.keyPress(KeyEvent.VK_1);
    KeyPresser.keyPress(KeyEvent.VK_2);
    KeyPresser.shutdown();
  }
}
