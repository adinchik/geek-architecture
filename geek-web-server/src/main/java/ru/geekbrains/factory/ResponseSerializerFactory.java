package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpResponse;

public final class ResponseSerializerFactory {
    public static String serialize(HttpResponse httpResponse) {
        return new ResponseSerializer().serialize(httpResponse);
    }
}
