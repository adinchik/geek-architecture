package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;

public class RequestParser {

    public HttpRequest parse(Deque<String> rawRequest) {
        String firstLine = rawRequest.pollFirst();
        String[] parts = firstLine.split(" ");
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setMethod(parts[0]);
        httpRequest.setPath(parts[1]);
        HashMap<String, String> map = new HashMap();
        int cnt = 0;
        while (rawRequest.peekFirst() != null) {
            String line = rawRequest.pollFirst();
            if (line.length() == 0) {
                cnt++;
                continue;
            }
            if (cnt == 2) {
                httpRequest.setBody(line);
            }
            else {
                parts = line.split(": ");
                map.put(parts[0], parts[1]);
            }
        }
        httpRequest.setHeaders(map);
        return httpRequest;
    }
}
