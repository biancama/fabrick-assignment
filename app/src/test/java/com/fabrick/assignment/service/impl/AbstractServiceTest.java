package com.fabrick.assignment.service.impl;

import static java.lang.String.format;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
public class AbstractServiceTest {
    @Rule
    public WireMockRule wireMock = new WireMockRule(
        WireMockConfiguration.options().dynamicPort());

    protected void setRestEndpoints(Object service) {
        ReflectionTestUtils.setField(service, "restEndpointUrl", format("http://localhost:%d", wireMock.port()));
    }

    @Autowired
    protected ObjectMapper objectMapper;
}
