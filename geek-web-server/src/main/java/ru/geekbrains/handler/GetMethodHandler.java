package ru.geekbrains.handler;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.util.HashMap;

@Handler(method = "GET", order = 0)
class GetMethodHandler extends MethodHandlerImpl {

    private final FileService fileService;

    public GetMethodHandler(MethodHandlerImpl next, SocketService socketService, ServerConfig config, FileService fileService) {
        super("GET", next, socketService, config);
        this.fileService = fileService;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest req) {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "text/html; charset=utf-8");
        if (!fileService.exists(req.getPath())) {
            return HttpResponse.createBuilder()
                    .withStatusCode(404)
                    .withStatusMessage("NOT_FOUND")
                    .withHeaders(map)
                    .withBody("File not found")
                    .build();
        }

        return HttpResponse.createBuilder()
                .withStatusCode(200)
                .withStatusMessage("OK")
                .withHeaders(map)
                .withBody(fileService.readFile(req.getPath()))
                .build();
    }
}
