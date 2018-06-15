package com.results.app.repository;

import com.results.app.model.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppRepository  extends MongoRepository<Option, String> {


}
