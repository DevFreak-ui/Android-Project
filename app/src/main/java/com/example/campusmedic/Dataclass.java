package com.example.campusmedic;

public class Dataclass {

    String id, name, statement, date, time;
    int age;

    public Dataclass() {

    }

    public Dataclass(String id, String name, int age, String statement, String date, String time) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.statement = statement;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
