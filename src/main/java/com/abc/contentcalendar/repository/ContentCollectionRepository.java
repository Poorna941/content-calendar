package com.abc.contentcalendar.repository;

import com.abc.contentcalendar.model.Content;
import com.abc.contentcalendar.model.ContentType;
import com.abc.contentcalendar.model.Status;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        //System.out.println(content.get(1));
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }

    // PostConstruct is executed after dependency injection is executed
    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My First Blog Post",
                "My First Blog Post",
                Status.IDEA,
                ContentType.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(content);
    }
}
