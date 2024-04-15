package com.abc.contentcalendar;

// create your own bean

import org.springframework.stereotype.Component;

// add it to container
//Other usages are
//@service
//@restController
//@Repository
@Component
public class Message {

    public String getMessage() {
        return "Hello World";
    }
}
