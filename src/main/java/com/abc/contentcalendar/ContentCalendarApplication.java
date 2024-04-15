package com.abc.contentcalendar;

import com.abc.contentcalendar.config.ContentCalendarProperties;
import com.abc.contentcalendar.model.Content;
import com.abc.contentcalendar.model.ContentType;
import com.abc.contentcalendar.model.Status;
import com.abc.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ContentCalendarApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(ContentCalendarApplication.class, args);
        //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
        System.out.println(restTemplate);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository respository) {
        return args -> {
            // insert some data into the database
            Content content = new Content(null,
                    "My First Blog Post through commandLineRunner",
                    "My First Blog Post through commandLineRunner",
                    Status.IDEA,
                    ContentType.ARTICLE,
                    LocalDateTime.now(),
                    null,
                    "");
            respository.save(content);
        };
    }

}
