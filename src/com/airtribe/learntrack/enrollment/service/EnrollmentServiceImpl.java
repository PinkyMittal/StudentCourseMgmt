package com.airtribe.learntrack.enrollment.service;

import com.airtribe.learntrack.course.exception.CourseNotFoundException;
import com.airtribe.learntrack.course.service.CourseService;
import com.airtribe.learntrack.enrollment.entity.Enrollment;
import com.airtribe.learntrack.enrollment.entity.Status;
import com.airtribe.learntrack.enrollment.exception.EnrollmentNotFoundException;
import com.airtribe.learntrack.helper.IdGenerator;
import com.airtribe.learntrack.student.exception.EntityNotFoundException;
import com.airtribe.learntrack.student.service.StudentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EnrollmentServiceImpl implements EnrollmentService{

    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentServiceImpl(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    /**
     *
     */
    @Override
    public void enrollStudent() throws EntityNotFoundException, CourseNotFoundException {
        int id = IdGenerator.generateId();
        System.out.println("Enter Student id for enrollment");
        int studentId = scan.nextInt();
        boolean isValidStudent = validateStudent(studentId);
        if(!isValidStudent){
            throw new EntityNotFoundException("Student Id doesnot exist,Please enter different student id");
        }
        System.out.println("Enter course id for enrollment ");
        int courseid = scan.nextInt();
        boolean isValidCourse = validateCourse(courseid);
        if(!isValidCourse){
            throw new CourseNotFoundException("Course Id doesnot exist,Please enter different course id");
        }
       Enrollment enrollment = new Enrollment(id,studentId,courseid,new Date(), Status.ACTIVE);
       enrollments.add(enrollment);
        System.out.println("New Enrollment created "+enrollment.toString());


    }

    private boolean validateStudent(int studentId) {
        return studentService.isFound(studentId,false);
    }

    private boolean validateCourse(int courseId) {
        return courseService.isFound(courseId,false);
    }

    /**
     *
     */
    @Override
    public void viewEnrollments() throws EntityNotFoundException, EnrollmentNotFoundException {
        int studentId = scan.nextInt();
        boolean isValidStudent = validateStudent(studentId);
        boolean found = false;
        if(!isValidStudent){
            throw new EntityNotFoundException("Student Id doesnot exist,Please enter different student id");
        }
        for(Enrollment e : enrollments){
            if(e.getStudentId() == studentId){
                System.out.println("Enrollment for Student id "+ studentId + "is" + e.toString());
                found = true;
            }
        }
        if(!found){
            throw new EnrollmentNotFoundException("Enrollment not found for mention student id");
        }

    }

    /**
     *
     */
    @Override
    public void markEnrollment() throws EntityNotFoundException, EnrollmentNotFoundException {
        int studentId = scan.nextInt();
        boolean isValidStudent = validateStudent(studentId);
        boolean found = false;
        if(!isValidStudent){
            throw new EntityNotFoundException("Student Id doesnot exist,Please enter different student id");
        }
        for(Enrollment e : enrollments){
            if(e.getStudentId() == studentId){
                e.setStatus(Status.COMPLETED);
                System.out.println("Enrollment for Student id "+ studentId + "is" + e.toString());
                found = true;
            }
        }
        if(!found){
            throw new EnrollmentNotFoundException("Enrollment not found for mention student id");
        }

    }
}
