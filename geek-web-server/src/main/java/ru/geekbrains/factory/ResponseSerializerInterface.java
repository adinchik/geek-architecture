package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpResponse;

public interface ResponseSerializerInterface {
    String serialize(HttpResponse response);
}
