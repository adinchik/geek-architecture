package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.factory.RequestParserFactory;
import ru.geekbrains.factory.ResponseCreatorFactory;
import ru.geekbrains.factory.ResponseSerializerFactory;
import ru.geekbrains.handler.MethodHandler;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final MethodHandler methodHandler;


    public RequestHandler(SocketService socketService, MethodHandler methodHandler) {
        this.socketService = socketService;
        this.methodHandler = methodHandler;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = RequestParserFactory.parse(rawRequest);

        methodHandler.handle(httpRequest);

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
