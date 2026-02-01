package com.airtribe.learntrack.student.entity;


/* Student class is inherited from Person ,
 to show inheritance */

public class Student extends Person{

    private String batch;
    private boolean active;


    public Student(int id, String firstName, String lastName, String email,String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch=batch;
        this.active=active;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void getDisplayName(){
        System.out.println("Student  name = "+super.getFirstName());
    }

    @Override
    public String toString() {
        return  super.toString() + ", " +
                "batch='" + batch + '\'' +
                ", active=" + active ;

    }
}
