package com.example;

import com.example.entity.Example;
import com.example.repository.ExampleRepository;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@MicronautTest
@Testcontainers
@Slf4j
class ExampleRepositoryTest {

    @Inject
    ExampleRepository exampleRepository;

    @Test
    void exampleRepositoryTestOK(){
        log.debug("Begin exampleRepositoryTestOK");
        Example example = new Example();
        example.setFirstName("First");
        example.setLastName("Name");

        exampleRepository.save(example);
        log.debug("Example saved");

        Iterable<Example> exa = exampleRepository.findAll();

        Assertions.assertNotNull(exa);
        Assertions.assertEquals(1,exa.spliterator().estimateSize());
    }

    @Test
    void exampleRepositoryTestFindByCode(){
        log.debug("Begin exampleRepositoryTestfindByCode");
        Example example = new Example();
        example.setCode("1");
        example.setFirstName("First");
        example.setLastName("Name");

        exampleRepository.save(example);
        log.debug("Example saved");

        List<Example> examples = exampleRepository.findExamplesByCode(List.of("1", "2"));
        Assertions.assertNotNull(examples);
        Assertions.assertEquals(1,examples.spliterator().estimateSize());
    }

    @Test
    void exampleRepositoryTestFindByCodeNOK(){
        log.debug("Entro a exampleRepositoryTestOK");

        Example example = new Example();
        example.setCode("1");
        example.setFirstName("First");
        example.setLastName("Name");

        exampleRepository.save(example);
        log.debug("Example saved");

        List<Example> examples = exampleRepository.findExamplesByCode(List.of("1"));
        Assertions.assertNotNull(examples);
        Assertions.assertEquals(1,examples.spliterator().estimateSize());
    }

}