package ru.geekbrains.domain;

import java.util.Map;

public class HttpRequest {

    private String method;

    private String path;

    private Map<String, String> headers;

    private String body;

    public HttpRequest() {
    }

    public HttpRequest(String method, String path, Map<String, String> headers, String body) {
        this.method = method;
        this.path = path;
        this.headers = headers;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final HttpRequest httpRequest;

        public Builder() {
            this.httpRequest = new HttpRequest();
        }

        public Builder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public Builder withPath(String path) {
            this.httpRequest.path = path;
            return this;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public Builder withBody(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build() {
            return httpRequest;
        }
    }
}
