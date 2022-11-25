package org.codesquad;

import java.awt.*;
import java.awt.event.ActionListener;

public class ChatUserInterface extends Frame {

    private final String nickname;
    private final TextField messageWindow;
    private final TextArea screen;

    public ChatUserInterface(String nickname) {
        this.nickname = nickname;
        this.messageWindow = new TextField();
        this.screen = new TextArea();
        initGraphics();
    }

    private void initGraphics() {
        this.messageWindow.setBackground(Color.white);
        this.screen.setBackground(Color.CYAN);
        this.add("North", messageWindow);
        this.add("Center", screen);
        super.setVisible(true);
        super.setSize(400,300);
        super.setTitle(this.nickname);
    }

    public void addMessageWindowActionListener(ActionListener actionListener) {
        this.messageWindow.addActionListener(actionListener);
    }

    public void clearMessageWindow() {
        this.messageWindow.setText("");
    }

    public String getMessage() {
        return messageWindow.getText();
    }

    public void addScreenMessage(String message) {
        if (message == null || message.equals("")) {
            return;
        }
        screen.append(message + "\n");
    }
}
