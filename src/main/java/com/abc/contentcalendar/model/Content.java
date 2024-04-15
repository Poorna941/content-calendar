package com.abc.contentcalendar.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

// @Table()
public record Content(
        // this id is something I am going to manage
        @Id
        Integer id,
        //@column("str_title")
        String title,
        String desc,
        Status status,
        ContentType contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url

) {
}
