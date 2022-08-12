package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements Runnable {
    private final Socket socket;
    private final String folder;
    private WriteOutput writeOutput;
    private RequestParsing requestParsing;

    public RequestHandler(Socket socket, String folder) {
        this.socket = socket;
        this.folder = folder;
        this.writeOutput = new WriteOutput(socket);
        this.requestParsing = new RequestParsing();
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {
            while (!input.ready()) ;
            String[] parts = requestParsing.getPartsOfFirstLineRequest(input.readLine());
            while (input.ready()) {
                System.out.println(input.readLine());
            }
            writeOutput.sendOutput(folder, parts[1]);
            System.out.println("Client disconnected!");

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
