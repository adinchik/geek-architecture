package ru.geekbrains.handler;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

import java.util.HashMap;

@Handler(method = "PUT", order = 2)
class PutMethodHandler extends MethodHandlerImpl {

    public PutMethodHandler(MethodHandlerImpl next, SocketService socketService, ServerConfig config) {
        super("PUT", next, socketService, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "text/html; charset=utf-8");
        return HttpResponse.createBuilder()
                .withStatusCode(200)
                .withStatusMessage("Ok")
                .withHeaders(map)
                .withBody("<h1>PUT method handled</h1>")
                .build();
    }
}
