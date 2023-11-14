package org.task;

import java.io.IOException;
import java.net.ServerSocket;
public class ServerPlayer {


        public static void main(String[] args) throws IOException {

            // Create a Player instance that listens for incoming connections on port 8080.
            Player otherPlayer = new Player(new ServerSocket(8080).accept());

            // Continue communication until the message counter reaches 10
            while (otherPlayer.getCounter() < 10) {

                // Other Player receives the message and responds.
                String response = otherPlayer.receive();
                otherPlayer.send(response + " (" + otherPlayer.getCounter() + ")");
                System.out.println("other Player :" +response + " (" + otherPlayer.getCounter() + ")");

                // Increment the counters of both Players.
                otherPlayer.incrementCounter();
             }


            // Finalize the program.
            otherPlayer.close();
        }
    }












