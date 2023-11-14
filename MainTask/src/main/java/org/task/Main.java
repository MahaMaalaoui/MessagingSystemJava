package org.task;

/**
 *
 * Creates two player instances and sets the other player for each player.
 * Sends a message from the first player to the second player and trigger a chat between the two players.
 *
 */



public class Main {

    public static void main(String[] args) {
        Player Initiator = new Player("Initiator");
        Player Receiver= new Player("Receiver");

        Initiator.setOtherPlayer(Receiver);
        Receiver.setOtherPlayer(Initiator);


        Initiator.sendMessage(Receiver, "Hello, T360 Thanks for the opportunity! ");




    }
}

