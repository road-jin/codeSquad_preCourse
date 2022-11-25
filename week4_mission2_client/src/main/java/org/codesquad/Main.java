package org.codesquad;

import java.io.IOException;

public class Main {

    public static void main (String args[]) throws IOException {
        ChatClient chatClient = new ChatClient("127.0.0.1", 50002);
        chatClient.run();
    }
}
