package ru.geekbrains.factory;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;

public interface RequestParserInterface {
    HttpRequest parse(Deque<String> rawRequest);
}
