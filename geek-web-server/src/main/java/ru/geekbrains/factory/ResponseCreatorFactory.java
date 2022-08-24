package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpResponse;

public final class ResponseCreatorFactory {
    public static HttpResponse createNotFoundResponse() {
        return new ResponseCreator().createNotFoundResponse();
    }

    public static HttpResponse createOKResponse(String body) {
        return new ResponseCreator().createOKResponse(body);
    }
}
