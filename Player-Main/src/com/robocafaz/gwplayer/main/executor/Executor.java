package com.robocafaz.gwplayer.main.executor;

import com.robocafaz.gwplayer.main.song.Song;
import com.robocafaz.gwplayer.main.song.note.Action;

public interface Executor {
  public void play(Song song);

  public void execute(Action action);

  public void startSong(Song song);

  public void finishSong(Song song);
}
