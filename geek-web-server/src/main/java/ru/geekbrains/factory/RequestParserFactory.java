package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;

public final class RequestParserFactory {
    public static HttpRequest parse(Deque<String> rawRequest) {
        return new RequestParser().parse(rawRequest);
    }
}
