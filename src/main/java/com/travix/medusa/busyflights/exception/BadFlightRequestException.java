package com.travix.medusa.busyflights.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.nio.charset.Charset;


public class BadFlightRequestException extends HttpStatusCodeException {
    public BadFlightRequestException(HttpStatus statusCode) {
        super(statusCode);
    }

    public BadFlightRequestException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public BadFlightRequestException(HttpStatus statusCode, String statusText, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseBody, responseCharset);
    }

    public BadFlightRequestException(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
    }
}
