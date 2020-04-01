package com.example.demo.model;

//use lombok plugin for getters setters



// here in this section we are going to make this model as an entity in the data base
// save topic instances by the JPA
// we need to map the objects of this topic class to the relational database table

// topic table is created and columns are the variables in the table and the rows are the instances of the topic class
// after this configuration JPA can convert topic instance to a row in the database and row to a topic instance
// next we should change the Topic service to handle methods for the database manipulation
import javax.persistence.Entity;
import javax.persistence.Id;

// using this anotation we tell to the JPA that this is an entity class and JPA create a table as above columns are all text columns
@Entity
public class Topic {

    @Id   // sets the the primary key as Id in the topic table > this is a field level anotation >> what ever an primary key can be given by this ID anotation
    private String id;
    private String name;
    private String Description;



    public Topic(){

    }


    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.Description = description;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.Description = description;
    }



}
