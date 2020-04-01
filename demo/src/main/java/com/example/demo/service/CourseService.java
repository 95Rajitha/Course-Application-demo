package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
//
//    List<Course> courseList = new ArrayList<>(Arrays.asList(
//
//            new Course("Programing","Programming","desc1"),
//            new Course("Devoloping","Devoloping","desc2"),
//            new Course("Algorithms","Algorithms","desc3")
//
//            ));


    public List<Course> getAllCourses(String topicId) {

//        return this.courseList;
// we need to take all courses from a topic passed by...CrudRepository doesnt have these kind of filters so we have to implement a methods to get all the courses belong to a given topi
// here the findAll method will not work out for the need. there fore see the CourseRepository...
        List<Course> courseList = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courseList::add);
        return courseList;

    }


    public Course getCourse(String id) {

       // return courseList.stream().filter(c->c.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();


    }

    public void updateCourse(Course course) {

//        for(int i=0;i<courseList.size();i++){
//
//            Course temp = courseList.get(i);
//
//            if(temp.getId().equals(id)){
//
//                courseList.set(i,course);
//
//            }
//
//        }
        courseRepository.save(course);


    }

    public void deleteCourse(String id) {

//        courseList.removeIf(course -> course.getId().equals(id));

        courseRepository.deleteById(id);

    }

    public void addCourse(Course course) {

        courseRepository.save(course);
    }
}
