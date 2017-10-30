package com.travix.medusa.busyflights.utils;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
public class TestUtils {

    private static RestTemplate restTemplate = new RestTemplate();

    public static final String TEST_FOLDER = "test_samples/";

    public String readFile(String filename) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader
                .getSystemResourceAsStream(TEST_FOLDER + filename), "UTF-8"));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line.trim());
        }
        return sb.toString();
    }

    public String makePostCall(String url, int port, String data, MediaType contentType, MediaType accepts) throws Exception {
        HttpEntity<?> httpEntity = new HttpEntity<>(data, getHeaders(contentType, accepts));

        String response = restTemplate.postForObject("http://localhost:"  + port + url , httpEntity, String.class);
        return response;

    }

    public HttpHeaders getHeaders(MediaType contentType, MediaType accepts) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(contentType);
        requestHeaders.setAccept(Arrays.asList(accepts));

        return requestHeaders;
    }

}
