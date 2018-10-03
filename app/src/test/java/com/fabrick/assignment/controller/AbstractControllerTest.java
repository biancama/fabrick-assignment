package com.fabrick.assignment.controller;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URLEncoder;
import java.util.Locale;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@ContextConfiguration
@WebAppConfiguration
public abstract class AbstractControllerTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected MockHttpServletRequest request;

    @Autowired
    private MessageSource messageSource;

    @Value("${frame-core.rest.endpoint}")
    protected String endpoint;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
            .webAppContextSetup(context)
            .build();
        LocaleContextHolder.setLocale(new Locale("en", "EN"));
    }


}
