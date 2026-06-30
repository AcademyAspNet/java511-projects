package ru.academy.simple.http.server.v1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HttpRequestReader implements Closeable {

    private static final String WHITESPACE = " ";

    private final BufferedReader bufferedReader;

    public HttpRequestReader(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public HttpRequest readHttpRequest() throws IOException {
        String controlLine = bufferedReader.readLine();
        String[] controlLineParts = controlLine.split(WHITESPACE, 3);

        if (controlLineParts.length != 3)
            throw new IllegalStateException("Illegal control line parts size!");

        String method = controlLineParts[0];
        String path = controlLineParts[1];
        String protocolVersion = controlLineParts[2];

        List<Header> headerList = new ArrayList<>();
        String headerLine;

        while ((headerLine = bufferedReader.readLine()) != null && !headerLine.isEmpty()) {
            Header header = Header.fromString(headerLine);
            headerList.add(header);
        }

        return new HttpRequest(
                method,
                path,
                protocolVersion,
                headerList
        );
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}
