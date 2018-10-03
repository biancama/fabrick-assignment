package com.fabrick.assignment.config;

import com.fabrick.assignment.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Slf4j
public class RestResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
//        log.error("Response error: {} {}", response.getStatusCode(), response.getStatusText());
       if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new ResourceNotFoundException();
        } else {
            throw new IllegalStateException("HTTP Status " + response.getStatusCode());
        }
    }
}
