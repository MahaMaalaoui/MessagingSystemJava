package org.task;

/**
 * The Player class represents a participant in a chat system.
 * It can send and receive messages.
 */
public class Player {


    private String name;  //The player's name
    private int countSendMsg = 0; //The number of messages the player has sent.
    private Player otherPlayer; //The other player in the chat application.


    /**
     * Constructor to Creates a new Player with the specified name.
     *
     * @param name The name of the player.
     *
     */
    public Player(String name) {
        this.name = name;
    }

    public void setOtherPlayer(Player otherPlayer)
    {
        this.otherPlayer = otherPlayer;
    }


    /**
     * Sends a message to another player.
     *
     * @param otherPlayer The player who will receive the message.
     * @param message  The message to send.
     * if the number of messages sent by both player reach 10 the program will end(mean each has sent and received 10 msg).
     */
    public void sendMessage(Player otherPlayer, String message) {
        this.countSendMsg++;
        if (this.countSendMsg<=10 && otherPlayer.countSendMsg <=10){
        otherPlayer.receiveMessage(message);}
        else System.out.println("Game over!");
    }

    /**
     * Receives a message and generates a reply with the received message concatenated
     * with the number of messages this player has already sent.
     *
     * @param message The received message.
     */



    public void receiveMessage(String message) {

        String reply = message + " (" + this.countSendMsg+ ")";
        System.out.println(this.name +" replay is: "+ reply );
        this.sendMessage(this.otherPlayer,reply);
    }






}
