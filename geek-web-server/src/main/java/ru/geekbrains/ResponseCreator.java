package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

import java.util.HashMap;

public class ResponseCreator {

    public HttpResponse createNotFoundResponse() {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setStatusCode(404);
        httpResponse.setStatusMessage("NOT FOUND");
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "text/html; charset=utf-8");
        httpResponse.setHeaders(map);
        httpResponse.setBody("<h1>Файл не найден!</h1>");
        return httpResponse;
    }

    public HttpResponse createOKResponse(String body) {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setStatusCode(200);
        httpResponse.setStatusMessage("OK");
        HashMap<String, String> map = new HashMap();
        map.put("Content-Type", "text/html; charset=utf-8");
        httpResponse.setHeaders(map);
        httpResponse.setBody(body);
        return httpResponse;
    }
}
