package com.abc.contentcalendar.controller;

import com.abc.contentcalendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

   // @Value("${cc.welcomeMessage: Default Welcome Message}")
    //public String welcomeMessage;

    //@Value("${cc.about}")
    //public String about;

    //@GetMapping("/")
    //public Map<String, String> home() {
    //    return Map.of("welcomeMessage", welcomeMessage, "about", about);
    //}

    private final ContentCalendarProperties contentCalendarProperties;

    public HomeController(ContentCalendarProperties contentCalendarProperties){
        this.contentCalendarProperties = contentCalendarProperties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home() {
        return contentCalendarProperties;
    }
}
