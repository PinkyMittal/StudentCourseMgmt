package com.airtribe.learntrack.course.service;

import com.airtribe.learntrack.course.entity.Course;
import com.airtribe.learntrack.student.exception.EntityNotFoundException;

import java.util.List;

public interface CourseService {

    void addCourse();
    void getAllCourses();
    void deactivateCourse() throws EntityNotFoundException;
    boolean isFound(int id, boolean found);
}
