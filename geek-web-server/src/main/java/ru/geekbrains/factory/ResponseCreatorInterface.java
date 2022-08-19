package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpResponse;

public interface ResponseCreatorInterface {
    HttpResponse createNotFoundResponse();

    HttpResponse createOKResponse(String body);
}
