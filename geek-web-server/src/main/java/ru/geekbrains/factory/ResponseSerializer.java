package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpResponse;

import java.util.Map;

class ResponseSerializer implements ResponseSerializerInterface {

    @Override
    public String serialize(HttpResponse response) {
        StringBuilder rawResponse = new StringBuilder("HTTP/1.1 " + String.valueOf(response.getStatusCode()) + " " + response.getStatusMessage() + "\n");
        for (Map.Entry<String, String> entry : response.getHeaders().entrySet()) {
            rawResponse.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        rawResponse.append("\n");
        rawResponse.append(response.getBody());
        return rawResponse.toString();
    }

}
