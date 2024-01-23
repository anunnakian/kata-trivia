package com.adaptionsoft.games.uglytrivia;

import java.io.PrintStream;

class ConsolePrinter {

  private final PrintStream print;

  public ConsolePrinter(PrintStream print) {
    this.print = print;
  }

  void sendMessage(String message) {
    print.println(message);
  }
}
