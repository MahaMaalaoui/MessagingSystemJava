package org.task;

import java.io.IOException;
import java.net.Socket;

public class ClientPlayer {

    public static void main(String[] args) throws IOException {
        // Create the initiator player processes .
        Player initiatorPlayer = new Player(new Socket("localhost", 8080));


        // initiatorPlayer start communication and send the first message.
        initiatorPlayer.send("Hello from the initiator Player!");
        initiatorPlayer.incrementCounter();

        // Continue communication until the message counter reaches 10
          while (initiatorPlayer.getCounter() < 10) {

            //initiatorPlayer receives the message and responds.

            String response = initiatorPlayer.receive();
            initiatorPlayer.send(response + " (" + initiatorPlayer.getCounter() + ")");
            System.out.println("initiatorPlayer: " +response + " (" + initiatorPlayer.getCounter() + ")");
            // Increment the counters of the Player.
            initiatorPlayer.incrementCounter();

         }



        // Finalize the program.
        initiatorPlayer.close();
    }
}
