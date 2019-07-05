import java.util.Random;

public class Main {
    public static void main(String[] args) {

    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while(empty) {

        }
        empty = true;
        return message;
    }

    public synchronized void write(String message) {
        while(!empty) {

        }

        empty = false;
        this.message = message;
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "first string",
                "second string",
                "third string",
                "fourth string"
        };

        Random random = new Random();

        for(int i = 0; i < messages.length; ++i) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}