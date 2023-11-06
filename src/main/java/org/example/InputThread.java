package org.example;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class InputThread extends Thread implements Runnable {

    private final Console console;

    public InputThread(Console console) {
        this.console = console;
    }

    public void run() {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();

            while (console.isRunning()) {
                String userInput = lineReader.readLine();
                System.out.println("Input: " + userInput);
            }

            terminal.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
