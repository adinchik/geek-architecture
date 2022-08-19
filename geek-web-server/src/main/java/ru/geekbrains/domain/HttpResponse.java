package ru.geekbrains.domain;

import java.util.Map;

public class HttpResponse {

    private int statusCode;

    private String statusMessage;

    private Map<String, String> headers;

    private String body;

    public HttpResponse() {
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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
        return new HttpResponse.Builder();
    }

    public static class Builder {
        private final HttpResponse httpResponse;

        public Builder() {
            this.httpResponse = new HttpResponse();
        }

        public Builder withStatusCode(int statusCode) {
            this.httpResponse.statusCode = statusCode;
            return this;
        }

        public Builder withStatusMessage(String statusMessage) {
            this.httpResponse.statusMessage = statusMessage;
            return this;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpResponse.headers = headers;
            return this;
        }

        public Builder withBody(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build() {
            return httpResponse;
        }
    }
}
