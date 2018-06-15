package com.results.app.controller;

import com.results.app.model.Option;
import com.results.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    AppRepository appRepository;

    private final MongoOperations mongoOperations;

    @Autowired
    public ResultController(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Option> getOptions(){
        Query query = new Query();
        query.limit(10);
        query.with(new Sort(Sort.Direction.DESC, "votes"));


        List<Option> top = mongoOperations.find(query, Option.class);

        return top;
    }
}
