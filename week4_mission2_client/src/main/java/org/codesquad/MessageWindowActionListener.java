package org.codesquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;

public class MessageWindowActionListener implements ActionListener {

    private final ChatUserInterface ui;
    private final BufferedWriter bufferedWriter;

    public MessageWindowActionListener(ChatUserInterface ui, BufferedWriter bufferedWriter) {
        this.ui = ui;
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = this.ui.getMessage();

        if(message == null || message.equals("")){
            return ;
        }

        try {
            this.bufferedWriter.write(message + "\n");
            this.bufferedWriter.flush();
            this.ui.clearMessageWindow();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
