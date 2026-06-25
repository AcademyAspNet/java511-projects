package ru.academy.simple.http.server.v1;

import java.util.List;

public record HttpRequest(
        String method,
        String path,
        String protocolVersion,
        List<Header> headers) {

}
