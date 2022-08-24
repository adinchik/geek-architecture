package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;

class RequestParser implements RequestParserInterface {

    @Override
    public HttpRequest parse(Deque<String> rawRequest) {
        String firstLine = rawRequest.pollFirst();
        String[] partsFirstLine = firstLine.split(" ");
        HashMap<String, String> map = new HashMap();
        int cnt = 0;
        String body = "";
        while (rawRequest.peekFirst() != null) {
            String line = rawRequest.pollFirst();
            if (line.length() == 0) {
                cnt++;
                continue;
            }
            if (cnt == 2) {
                body = line;
            }
            else {
                String[] parts = line.split(": ");
                map.put(parts[0], parts[1]);
            }
        }
        HttpRequest httpRequest = HttpRequest.createBuilder()
                        .withMethod(partsFirstLine[0])
                        .withPath(partsFirstLine[1])
                        .withHeaders(map)
                        .withBody(body)
                        .build();
        return httpRequest;
    }
}
