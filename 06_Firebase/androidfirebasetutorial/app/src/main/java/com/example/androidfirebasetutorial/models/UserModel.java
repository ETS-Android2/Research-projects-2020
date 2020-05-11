package com.example.androidfirebasetutorial.models;

public class UserModel {

    private final String name;
    private final String course;
    private final String description;
    private int grade;
    public UserModel(String name, String course, String description, int grade) {
        this.name = name;
        this.course = course;
        this.description = description;
        this.grade = grade;
    }

    public UserModel() {
        name = "";
        course = "";
        description = "";
        grade = 0;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getDescription() {
        return description;
    }

    public int getGrade() {
        return grade;
    }
    
}