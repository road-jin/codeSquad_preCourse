package org.codesquad;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatRoomCallBack{

    private final List<ChatThread> chatRoom;

    public ChatRoom() {
        this.chatRoom = new ArrayList<>();
    }

    public synchronized void add(ChatThread chatThread) {
        chatRoom.add(chatThread);
    }

    @Override
    public synchronized void sendAll(String message) {
        validateChatRoom();
        chatRoom.forEach(c -> c.send(message));
    }

    private synchronized void validateChatRoom() {
        List<ChatThread> collect = chatRoom.stream()
                .filter(c -> !c.isAlive())
                .toList();

        if (!collect.isEmpty()) {
            chatRoom.removeAll(collect);
        }
    }
}
