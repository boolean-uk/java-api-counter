package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("student")
public class Student {
    private HashMap<String, Character> courses;

    public Student() {
        this.courses = new HashMap<>();
    }

    @GetMapping
    public String getStudent() {
        StringBuilder output = new StringBuilder();
        output.append("The student is taking:");
        for (String name: this.courses.keySet()) {
            output.append("<br>- ");
            output.append(name);
            output.append(", and has grade: ");
            output.append(this.courses.get(name));
        }
        return output.toString();
    }

    @GetMapping("add/{courseName}")
    public String course(@PathVariable String courseName) {
        if (this.courses.containsKey(courseName)) {
            return "The student is already registered for the " + courseName + " course.";
        }
        this.courses.put(courseName, '-');
        return courseName + " course is added to the list.";
    }

    @GetMapping("remove/{courseName}")
    public String removeCourse(@PathVariable String courseName) {
        if(!this.courses.containsKey(courseName)) {
            return "The student wasn't registered for the " + courseName + " course.";
        }
        this.courses.remove(courseName);
        return courseName + " course is removed from the list.";
    }

    @GetMapping("update/{courseName}/{grade}")
    public String updateGrade(@PathVariable String courseName, @PathVariable char grade) {
        if(!this.courses.containsKey(courseName)) {
            return "The student is not registered for the " + courseName + " course. The grade can not be updated.";
        }
        this.courses.replace(courseName, grade);
        return "The grade for the " + courseName + " course is now " + grade;
    }
}
