package com.airtribe.learntrack.student.service;

import com.airtribe.learntrack.student.exception.EntityNotFoundException;

public interface StudentService {

    public void addStudent();
    public void deactivateStudent() throws EntityNotFoundException;
    public void removeStudent() throws EntityNotFoundException;
    public void updateStudent() throws EntityNotFoundException;
    public void listStudent();
    public void searchStudent() throws EntityNotFoundException;

    boolean isFound(int studentId, boolean b);
}
