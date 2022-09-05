package ru.geekbrains.handler;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

import java.util.function.Function;

public class StrategyMethodHandler extends MethodHandlerImpl {

    private final Function<HttpRequest, HttpResponse> strategy;

    public StrategyMethodHandler(Function<HttpRequest, HttpResponse> strategy, String method, MethodHandlerImpl next, SocketService socketService, ServerConfig config) {
        super(method, next, socketService, config);
        this.strategy = strategy;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return strategy.apply(request);
    }
}
