package com.robocafaz.gwplayer.main.constants;

public class Instrument {
  public static final Instrument BELL = new Instrument("Bell", 3, false, false);
  public static final Instrument HORN = new Instrument("Horn", 3, true, false);
  public static final Instrument FLUTE = new Instrument("Flute", 2, true, false);
  public static final Instrument HARP = new Instrument("Harp", 3, false, true);

  private final String _name;
  private final int _octaves;
  private final boolean _hold;
  private final boolean _chords;

  public Instrument(String name, int octaves, boolean holds, boolean chords) {
    this._name = name;
    this._octaves = octaves;
    this._hold = holds;
    this._chords = chords;
  }

  public String getName() {
    return this._name;
  }

  public int getOctaves() {
    return this._octaves;
  }

  public boolean supportsHolds() {
    return this._hold;
  }

  public boolean supportsChords() {
    return this._chords;
  }
}
