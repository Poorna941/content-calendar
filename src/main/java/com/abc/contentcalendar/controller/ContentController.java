package com.abc.contentcalendar.controller;

import com.abc.contentcalendar.exception.ApiRequestException;
import com.abc.contentcalendar.model.Content;
import com.abc.contentcalendar.model.Status;
import com.abc.contentcalendar.repository.ContentCollectionRepository;
import com.abc.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

// Controller accepts requests and gives a response
@RestController
// how to get to this controller
@RequestMapping("api/content")
@CrossOrigin
public class ContentController {

    // Need to create an instance of ContentCollectionRepository
    // applicationContext is responsible for managing all the instances of the application.
    // - Inversion of control. We are no longer responsible for creating instances of classes.

    // Dependency Injection
    // We are dependent on repository. We are injecting the repository.
    //private final ContentCollectionRepository repository;
    private final ContentRepository repository;

    Logger logger = LoggerFactory.getLogger(ContentController.class);

    // same as @autowired. THis is implicit when there is only one public
    // constructor in the class
    public ContentController(ContentRepository contentRepository) {
        this.repository = contentRepository;
    }

    // make a request and find all the pieces of content in the system
    // getMapping is specialized version of requestMapping
    @GetMapping("")
    public List<Content> findAll() {
        //default = Info
        logger.trace("Testing Logger error");
        return repository.findAll();
    }

    // Map this id to that id using pathVariable annotation
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        //return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!"));
        return repository.findById(id).orElseThrow(() -> new ApiRequestException("Content Not Found! with custom Exception"));
    }

    // RequestBody - content needs to be a web request
    //the POST method call will create a child resource under a collection of resources.
    @ResponseStatus(HttpStatus.CREATED) // gives a response of 201
    @PostMapping("")
    public void createContent(@Valid @RequestBody Content content){
        repository.save(content);
    }

    // the PUT method call will either create a new resource or update an existing one.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }
}
