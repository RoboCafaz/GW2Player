package com.robocafaz.gwplayer.main.song;

import com.robocafaz.gwplayer.main.constants.Instrument;
import com.robocafaz.gwplayer.main.executor.KeyboardExecutor;
import com.robocafaz.gwplayer.main.song.note.Action;
import com.robocafaz.gwplayer.main.song.note.Chord;
import com.robocafaz.gwplayer.main.song.note.Note;

public class SongFactory {
  public static Song interpret(String string) {
    Song song = new Song("Imported Song", Instrument.BELL, 100);
    for (int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);
      Action act = Action.getActionFor(character);
      if (act != null) {
        if (string.length() > i + 2) {
          char next = string.charAt(i + 1);
          switch (next) {
          case '/':
          case '\\':
            char chord = string.charAt(i + 2);
            Action nextAct = Action.getActionFor(chord);
            if (nextAct != null) {
              song.appendAction(new Chord(act, nextAct));
              i += 2;
              continue;
            }
            break;
          default:
            break;
          }
        }
        song.appendAction(new Note(act));
      }
    }
    return song;
  }

  public static void main(String... args) {
    Song song = SongFactory.interpret("6 (4 342 5 32) 6 6 (4 342 5 86 445 65 354 2 445 65 4 2 1 2)");
    KeyboardExecutor executor = new KeyboardExecutor();
    executor.play(song);
  }
}
