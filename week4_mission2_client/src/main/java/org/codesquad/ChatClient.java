package org.codesquad;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    private final Socket socket;
    private final ChatUserInterface ui;

    public ChatClient(String serverAddress, Integer serverPort) throws IOException {
        this.socket = new Socket(serverAddress, serverPort);
        this.ui = new ChatUserInterface(InputView.getNickName());
    }

    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        initChatUserInterface(bufferedReader);

        while (true) {
            this.ui.addScreenMessage(bufferedReader.readLine());
        }
    }

    private void initChatUserInterface(BufferedReader bufferedReader) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        sendNickNameToServer(bufferedWriter);
        this.ui.addMessageWindowActionListener(new MessageWindowActionListener(this.ui, bufferedWriter));
        this.ui.addWindowListener(new CloseWindowAdapter(this.socket, bufferedWriter, bufferedReader));
    }

    private void sendNickNameToServer(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(this.ui.getTitle() + "\n");
        bufferedWriter.flush();
    }
}
