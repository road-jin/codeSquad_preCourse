package org.codesquad;

import java.io.*;
import java.net.Socket;

public class ChatThread extends Thread{

    private final Socket socket;
    private final String nickName;
    private final ChatRoomCallBack chatRoomCallBack;
    private final BufferedWriter bw;
    private final BufferedReader br;

    public ChatThread(String nickName, Socket socket, ChatRoomCallBack chatRoomCallBack) throws IOException {
        this.nickName = nickName;
        this.socket = socket;
        this.chatRoomCallBack = chatRoomCallBack;
        this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
      try {
          while (true) {
              String message = this.br.readLine();
              validateMessageSend(message);
          }
      } catch (IOException e) {
          close();
      }
    }

    public void send(String message) {
        try {
            bw.write(message + "\n");
            bw.flush();
        } catch (IOException e) {
            close();
        }
    }

    private void validateMessageSend(String message) {
        if (message != null && !message.trim().equals("")) {
            this.chatRoomCallBack.sendAll("[" + this.nickName + "]: " + message);
        }
    }

    public void close() {
        try {
            br.close();
            bw.close();
            socket.close();
            this.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
