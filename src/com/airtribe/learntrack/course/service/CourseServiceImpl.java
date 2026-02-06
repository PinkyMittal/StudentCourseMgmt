package com.airtribe.learntrack.course.service;

import com.airtribe.learntrack.course.entity.Course;
import com.airtribe.learntrack.helper.IdGenerator;
import com.airtribe.learntrack.student.entity.Student;
import com.airtribe.learntrack.student.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService{

    private final ArrayList<Course> courses = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);


    @Override
    public void addCourse() {
        int id = IdGenerator.generateCourseId();
        System.out.println("Enter Course Name");
        String courseName = scan.next();
        System.out.println("Enter Course description");
        String courseDescription = scan.next();
        System.out.println("Enter Duration in weeks");
        int dow = scan.nextInt();
        Course c = new Course(id,courseName,courseDescription,dow,true);
        courses.add(c);
        System.out.println("Course added successfully "+ c.toString());
    }

    /**
     * @return
     */
    @Override
    public void getAllCourses() {
        if(courses.isEmpty()){
            System.out.println("No Course found");
            return;
        }
        for(Course c : courses){
            System.out.println(c.toString());
        }
    }

    public boolean isFound(int courseId,boolean found){
        for(Course s : courses){
            if(s.getId() == courseId){
                System.out.println("Course found successfully "+s.toString());
                found =true;
                break;
            }
        }
        return found;
    }

    @Override
    public void deactivateCourse() throws EntityNotFoundException {
        System.out.println("Enter CourseId to deactivate");
        int id = scan.nextInt();
        boolean deactivated = false;
        scan.nextLine();
        for(Course c : courses){
            if(c.getId() == id){
                c.setActive(false);
                System.out.println("Course deactivated successfully");
                deactivated=true;
                break;
            }
        }
        if(!deactivated){
            throw new EntityNotFoundException("Course ID does not exist for deactivation");
        }

    }
}
