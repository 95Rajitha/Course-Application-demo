package com.example.demo.controller;

import com.example.demo.model.Topic;
import com.example.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;


    //getting the Topics list
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopic();

    }

    // getting a topic by id
    @RequestMapping("/topics/{pathId}")
    public Topic getTopic(@PathVariable("pathId") String id) {
        return topicService.getTopic(id);


    }


    //add a topic by sending the topic in a payload
    //taking the payload from the Request body using the Post method and set to the Topic instance
    @RequestMapping(method= RequestMethod.POST,value = "/topics")
    public void addTopic(@RequestBody Topic topic){

        topicService.addTopic(topic);

    }

    //update a topic by the id
    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){

        topicService.updateTopic(topic,id);

    }


    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}/{name}")
    public void updateName (@PathVariable("name") String name,@PathVariable("id") String id){

        topicService.updateName(name,id);

    }


    // delete whole at once
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics")
    public void deleteAllTopics(){

        topicService.deleteAllTopics();

    }

    // delete  a single topic by id
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){

        topicService.deleteTopic(id);

    }



}
