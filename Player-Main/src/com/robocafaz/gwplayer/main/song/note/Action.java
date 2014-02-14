package com.robocafaz.gwplayer.main.song.note;

public enum Action {
  N1, N2, N3, N4, N5, N6, N7, N8, OCTAVE_UP, OCTAVE_DOWN;

  public static Action getActionFor(char c) {
    switch (c) {
    case '1':
      return N1;
    case '2':
      return N2;
    case '3':
      return N3;
    case '4':
      return N4;
    case '5':
      return N5;
    case '6':
      return N6;
    case '7':
      return N7;
    case '8':
      return N8;
    case '>':
    case '(':
    case ']':
      return OCTAVE_UP;
    case '<':
    case ')':
    case '[':
      return OCTAVE_DOWN;
    default:
      return null;
    }
  }
}
