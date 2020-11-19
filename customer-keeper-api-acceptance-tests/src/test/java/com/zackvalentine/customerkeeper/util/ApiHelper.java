package com.zackvalentine.customerkeeper.util;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.jackson.JacksonObjectMapper;

import java.util.Map;

public class ApiHelper {
    private final static String baseUrl = "http://localhost:8080";

    public static HttpResponse<JsonNode> get(String path) {
        resetUnirest();
        return Unirest.get(baseUrl + path)
                .asJson();
    }

    public static HttpResponse<JsonNode> post(String path, Map<String, Object> body) {
        resetUnirest();

        return Unirest.post(baseUrl + path)
                .header("content-type", "application/json")
                .body(body)
                .asJson();
    }

    public static void resetUnirest() {
        Unirest.config()
                .reset()
                .setObjectMapper(new JacksonObjectMapper())
                .followRedirects(false);
    }
}
