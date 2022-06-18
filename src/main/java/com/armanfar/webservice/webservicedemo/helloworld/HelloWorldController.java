package com.armanfar.webservice.webservicedemo.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String getHelloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world/{name}")
    public String getHelloWorld(@PathVariable String name) {
        return "Hello World, " + name;
    }

    @GetMapping(path = "/hello-world-internationalized-with-locale-param")
    public String getHelloWorldInternationalizedWithParamLocale(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message",
                null, "No translation available for this language", locale);
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String getHelloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message",
                null, "No translation available for this language", LocaleContextHolder.getLocale());
    }
}