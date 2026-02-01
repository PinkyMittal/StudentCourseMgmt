package com.airtribe.learntrack.student.entity;

public class Trainer extends Person{


    public Trainer(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    @Override
    public void getDisplayName(){
        System.out.println("Trainer  name = "+super.getFirstName());
    }
}
