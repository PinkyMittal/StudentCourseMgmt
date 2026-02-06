package com.airtribe.learntrack.enrollment.service;

import com.airtribe.learntrack.course.exception.CourseNotFoundException;
import com.airtribe.learntrack.enrollment.exception.EnrollmentNotFoundException;
import com.airtribe.learntrack.student.exception.EntityNotFoundException;

public interface EnrollmentService {

    public void enrollStudent() throws EntityNotFoundException, CourseNotFoundException;
    public void viewEnrollments() throws EntityNotFoundException, EnrollmentNotFoundException;
    public void markEnrollment() throws EntityNotFoundException, EnrollmentNotFoundException;

}
