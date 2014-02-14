package com.robocafaz.gwplayer.main.song.note;

import com.robocafaz.gwplayer.main.executor.Executor;

public class Chord extends Note {
  protected final Action _actionTwo;

  public Chord(Action actionOne, Action actionTwo) {
    super(actionOne);
    this._actionTwo = actionTwo;
  }

  @Override
  public void play(Executor executor) {
    super.play(executor);
    executor.execute(this._actionTwo);
  }
}