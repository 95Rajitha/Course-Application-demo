package com.example.demo.service;

import com.example.demo.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String> {

    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t,String id)
    //deleteTopic(String id)

// above typical methods are being used for every entity that you keep inside the database

    //Spring data jpa is provided with interface to implement your version by extending "crudRepository"

    //crudRepository comes with then those above typical methods with their implementation
    //and to make your version extend it
    // we only have to implement custom methods since provided typical methods are already here.
    // it needs to be provided with a generic type.
    // use topic repository in your service layer to make the connections and handle data in the data layer

}
