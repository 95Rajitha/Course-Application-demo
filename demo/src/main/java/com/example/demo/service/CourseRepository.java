package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> {

//here lets see what spring data JPA really do??
    // define methods which are abstract methods and Spring data JPA does that its going to look at your METHOD NAME and  figure out what the implementation what ypu need based on the name
    // unless defining a method in a standard way that S.D.JPA understands, we have to give an implementation for the method. otherwise S.D.JPA does the thing by the name.
    // since CrudRepository know how to get data and manipulate in some ways we only need to convince our need to make a filtering to the purpose; we need a  extra filter to get all the
    // courses related to a topic.

    // example: assume that we need to get all the courses by a particular name provided of a course
        // for the purpose we need to create a method in a particular way that S.D jpa provides its implementation.

        // All custom methods that need to perform finding things goes with the first word as "find" same as in the predefine findAll/findById methods in CrudRepo
        // next property use because we need to FILTER BY a certain property so the next part is "By"
        // soon after the that state the PROPERTY that we need to FILTER BY as "Name" so we are done withe the method declaration
    //IMPORTANT:  here the JPA looks the return type and sees the model and check weather there is a field related to the filtering part which is requested in the methods declaration.and the type passed to find as the parameter matches with the field.
    //public List<Course> findByName(String name);
    //EXAMPLE: public List<Course> findByDescription(String Description);

    // lets declare the method that we needed, find the "all courses for a given topic"


    public List<Course> findByTopicId(String topicId);

    // in the method we still require the List Of courses such that we defined it as the return type as Course
    // purpose: FINDING ---> find
    // filter: By
    // Property:Topic ---> and look in the course model to find the type of the Topic which is not a String and we need to take a String property by the Topic object which makes it as "TopicId"
    //  CHANGE THE METHOD CALL IN THE COURSESERVICE

}
