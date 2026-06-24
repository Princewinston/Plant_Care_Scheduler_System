package com.appdev.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot is Running!";
    }

    @GetMapping("/arraylist")
    public String runArrayList() {

        CollectionArrayList obj = new CollectionArrayList();

        obj.understandingArrayMethods();
        obj.display();
        obj.checkContains();
        obj.interviewQuestions();

        return "ArrayList methods executed successfully. Check the console output.";
    }

    @GetMapping("/names")
    public Object getNames() {

        CollectionArrayList obj = new CollectionArrayList();
        obj.understandingArrayMethods();

        return obj.getArrayListReference();
    }
}