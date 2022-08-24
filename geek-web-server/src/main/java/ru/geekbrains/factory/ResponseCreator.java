package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpResponse;

import java.util.HashMap;

class ResponseCreator implements ResponseCreatorInterface {

    @Override
    public HttpResponse createNotFoundResponse() {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "text/html; charset=utf-8");
        HttpResponse httpResponse = HttpResponse.createBuilder()
                        .withStatusCode(404)
                        .withStatusMessage("NOT FOUND")
                        .withHeaders(map)
                        .withBody("<h1>Файл не найден!</h1>")
                        .build();
        return httpResponse;
    }

    @Override
    public HttpResponse createOKResponse(String body) {
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "text/html; charset=utf-8");
        HttpResponse httpResponse = HttpResponse.createBuilder()
                .withStatusCode(200)
                .withStatusMessage("OK")
                .withHeaders(map)
                .withBody(body)
                .build();
        return httpResponse;
    }
}
