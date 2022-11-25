package org.codesquad;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class CloseWindowAdapter extends WindowAdapter {

    private final Socket socket;
    private final BufferedWriter bufferedWriter;
    private final BufferedReader bufferedReader;

    public CloseWindowAdapter(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedWriter = bufferedWriter;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Frame window = (Frame) e.getWindow();
        try {
            this.bufferedWriter.write(window.getTitle() + "님이 퇴장하였습니다.\n");
            this.bufferedWriter.close();
            this.bufferedReader.close();
            this.socket.close();
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
