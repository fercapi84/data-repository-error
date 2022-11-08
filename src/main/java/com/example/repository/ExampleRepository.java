package com.example.repository;

import com.example.entity.Example;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ExampleRepository extends CrudRepository<Example,Long> {

    @Query(value =  "select * from test_example p where p.code in ( :codes ) ", nativeQuery = true)
    List<Example> findExamplesByCode(List<String> codes);
}
