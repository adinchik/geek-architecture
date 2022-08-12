package ru.geekbrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteOutput {
    private Socket socket;
    private FileSystem fileSystem;

    public WriteOutput (Socket socket) {
        this.socket = socket;
        this.fileSystem = new FileSystem();
    }

    public void sendOutput(String folder, String fileName) {
        try (PrintWriter output = new PrintWriter(socket.getOutputStream())) {
            if (fileSystem.isFileExist(folder, fileName)) {
                output.println("HTTP/1.1 404 NOT_FOUND");
                output.println("Content-Type: text/html; charset=utf-8");
                output.println();
                output.println("<h1>Файл не найден!</h1>");
                output.flush();
                return;
            }

            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();

            fileSystem.transferToOutput(output);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
