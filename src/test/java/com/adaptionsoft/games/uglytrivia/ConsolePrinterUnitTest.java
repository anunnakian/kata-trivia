package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ConsolePrinterUnitTest {

  PrintStream print = mock(PrintStream.class);

  @Test
  void shouldPrintMessage() {
    ConsolePrinter printer = new ConsolePrinter(print);

    ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);

    String message = "IS THIS MESSAGE";
    printer.sendMessage(message);

    verify(print).println(messageCaptor.capture());
    assertThat(messageCaptor.getValue()).isEqualTo(message);
  }
}
