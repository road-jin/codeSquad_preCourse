package org.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private final ChatRoom chatRoom;

    public ChatServer() {
        this.chatRoom = new ChatRoom();
    }

    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(50002);
        waitClient(serverSocket);
        serverSocket.close();
    }

    private void waitClient(ServerSocket serverSocket) throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            String nickName = getNickName(socket);
            createThread(socket, nickName);
            notifyClientConnection(nickName);
        }
    }

    private void createThread(Socket socket, String nickName) throws IOException {
        System.out.printf("[%s:%d] 접속\n", socket.getLocalAddress(), socket.getPort());
        ChatThread chatThread = new ChatThread(nickName, socket, chatRoom);
        chatRoom.add(chatThread);
        chatThread.start();
    }

    private String getNickName(Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String nickName = br.readLine();
        return nickName;
    }

    private void notifyClientConnection(String nickName) {
        chatRoom.sendAll("\""+ nickName + "\"님이 입장했습니다.");
    }
}
