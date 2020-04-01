package com.example.demo.service;

import com.example.demo.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;





    @Service
    public class TopicService {
        //Created a mutable list using an Array

        // we need to inject the dependency of TopicRepository in oder to make the an object of it and use that object for calling methods

        @Autowired
        private TopicRepository topicRepository;


        //as the last section we are going to remove these hardcoded list and create the own database to implement queries and handle queries by JPA
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//
//            new Topic("java", "java", "aaaaaaaaaaaaa"),
//            new Topic("C", "C", "bbbbbbbbbbbbbbb"),
//            new Topic("python", "python", "aaaaaaaaaaaaa"),
//            new Topic("C", "C", "aaaaaaabbbbaaaaaa")
//
//
//    ));


        public List<Topic> getAllTopic() {
//        return this.topics;
            List<Topic> topicList = new ArrayList<>();
            topicRepository.findAll().forEach(topicList::add);
//        topicRepository.findAll().forEach(t->topicList.add(t));
            return topicList;

        }

        public Topic getTopic(String id) {
//        return topics.stream().filter(topic1 -> topic1.getId().equals(id)).findFirst().get();
            return topicRepository.findById(id).get();
            // findById returns optional object Optional<Topic>
            // can also use .orElse(null/new Topic())

        }

        public void addTopic(Topic topic) {

//        this.topics.add(topic);
            topicRepository.save(topic);

        }

        public void updateTopic(Topic topic, String id) {


            topicRepository.save(topic);

            //this is simple and this does the update as well as the insert
            // here repo knows well enough about weather the releavant topic
            // is in a row or not if it is in a row so it knows that this is an update
            //if it is not its going to insert to the table



//   this is the old code before for without repository/ for hardcoded values

//        for (int i = 0; i < topics.size(); i++) {
//
//            Topic temp = topics.get(i);
//
//            if (temp.getId().equals(id)) {
//
//                topics.set(i, topic);
//            }

            // this is other implementation

//        if(topicRepository.findById(id).isPresent()){
//
//            topicRepository.save(topic);
//        }
//
//        new RuntimeException("not exists");

            // same thing except this exception could be done as in the above



        }


        public void deleteAllTopics() {

            topicRepository.deleteAll();
//        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList());

        }


        public void deleteTopic(String id) {


            topicRepository.deleteById(id);


//        return topics.removeIf(t -> t.getId().equals(id)); change the return type to boolean

//        for (int i = 0; i < topics.size(); i++) {
//            if (topics.removeIf(topic -> )) {
//
//            }
//        }
        }

        public void updateName(String name, String id) {



            topicRepository.findById(id).get().setName(name);




//        for(int i=0;i<topics.size();i++){
//
//            Topic temp = topics.get(i);
//             if(temp.getId().equals(id)){
//
//                 temp.setName(name);
//                 break;
//             }
//
//
//        }



        }
    }




