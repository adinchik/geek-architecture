package ru.geekbrains.handler;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.factory.ResponseSerializerFactory;
import ru.geekbrains.service.SocketService;

import java.util.HashMap;

abstract class MethodHandlerImpl implements MethodHandler {

    private final String method;

    private final MethodHandlerImpl next;

    protected final SocketService socketService;

    protected final ServerConfig config;

    public MethodHandlerImpl(String method, MethodHandlerImpl next, SocketService socketService, ServerConfig config) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.config = config;
    }

    @Override
    public void handle(HttpRequest request) {
        HttpResponse response;
        if (method.equals(request.getMethod())) {
            response = handleInternal(request);
        } else if (next != null) {
            next.handle(request);
            return;
        } else {
            HashMap<String, String> map = new HashMap();
            map.put("Content-Type", "text/html; charset=utf-8");
            response = HttpResponse.createBuilder()
                    .withStatusCode(405)
                    .withStatusMessage("METHOD_NOT_ALLOWED")
                    .withHeaders(map)
                    .withBody("<h1>Метод не поддерживается!</h1>")
                    .build();
        }
        String rawResponse = ResponseSerializerFactory.serialize(response);
        socketService.writeResponse(rawResponse);
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
