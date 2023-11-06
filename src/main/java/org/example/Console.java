package org.example;

public class Console {

    private InputThread inputThread;
    private boolean running;
    private String userInput = "";

    public void run() {
        running = true;

        inputThread = new InputThread(this);
        inputThread.start();

        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("SPEELVELD");
        }
    }

    public boolean isRunning() {
        return running;
    }
}
