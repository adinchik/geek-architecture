package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.factory.RequestParserFactory;
import ru.geekbrains.factory.ResponseCreatorFactory;
import ru.geekbrains.factory.ResponseSerializerFactory;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;


    public RequestHandler(SocketService socketService, FileService fileService) {
        this.socketService = socketService;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = RequestParserFactory.parse(rawRequest);
        if (!fileService.exists(httpRequest.getPath())) {
            socketService.writeResponse(ResponseSerializerFactory.serialize(ResponseCreatorFactory.createNotFoundResponse()));
        }
        else
            socketService.writeResponse(ResponseSerializerFactory.serialize(ResponseCreatorFactory.createOKResponse(fileService.readFile(httpRequest.getPath()))));
        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
