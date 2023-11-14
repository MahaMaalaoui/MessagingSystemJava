package org.task;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Player {

    private Socket socket;// The socket used to communicate with the other player.
    private int counter; // The number of messages this player has sent.


    /**
     * Constructor to Creates a new Player with a socket.
     *
     * @param socket The socket of the player.
     *
     */
    public Player(Socket socket) {
        this.socket = socket;
        this.counter = 0;
    }


    /**
     * Sends a message to the other player through the socket.
     *
     * @param message The message to send.
     *
     * @throws IOException If an I/O error occurs
     */
    public void send(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());
        outputStream.flush();
    }



    /**
     * Sends a message to the other player through the socket.
     *
     * @return The received message.
     *
     * @throws IOException If an I/O error occurs.
     *
     */

    public String receive() throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        return new String(bytes, 0, read);
    }

    /**
     *
     * Increments the message counter.
     *
     */

    public void incrementCounter() {
        this.counter++;
    }

    /**
     *
     * Retrieves the current value of the message counter.
     *
     */
    public int getCounter() {
        return this.counter;
    }

    /**
     *
     * Closes the socket connection.
     *
     */

    public void close() throws IOException {
        socket.close();
    }
}
