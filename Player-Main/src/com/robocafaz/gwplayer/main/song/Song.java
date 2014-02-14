package com.robocafaz.gwplayer.main.song;

import java.util.LinkedList;
import java.util.Queue;
import com.robocafaz.gwplayer.main.constants.Instrument;
import com.robocafaz.gwplayer.main.song.note.SongAction;

public class Song {
  private final String _name;
  private final Instrument _instrument;
  private final int _bpm;
  private final Queue<SongAction> _actions;

  public Song(String name, Instrument instrument, int bpm) {
    this._name = name;
    this._instrument = instrument;
    this._bpm = bpm;
    this._actions = new LinkedList<SongAction>();
  }

  public void appendAction(SongAction action) {
    this._actions.add(action);
  }

  public String getName() {
    return this._name;
  }

  public Instrument getInstrument() {
    return this._instrument;
  }

  public int getBPM() {
    return this._bpm;
  }

  public Queue<SongAction> getActions() {
    Queue<SongAction> clonedActions = new LinkedList<SongAction>();
    for (SongAction action : this._actions) {
      clonedActions.add(action);
    }
    return clonedActions;
  }
}
