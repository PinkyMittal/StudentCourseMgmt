package com.airtribe.learntrack.student.service.impl;

import com.airtribe.learntrack.helper.IdGenerator;
import com.airtribe.learntrack.student.entity.Student;
import com.airtribe.learntrack.student.exception.EntityNotFoundException;
import com.airtribe.learntrack.student.service.StudentService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {

    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);


    public void addStudent(){
        int id = IdGenerator.generateId();
        System.out.println("Enter Student Firstname");
        String firstname = scan.next();
        System.out.println("Enter Student lastName");
        String lastname = scan.next();
        System.out.println("Enter Student email");
        String mail = scan.next();
        Student s = new Student(id,firstname,lastname,mail,"1",true);
        students.add(s);
        System.out.println("Student added successfully "+ s.toString());
    }

    public void deactivateStudent() throws EntityNotFoundException {
        System.out.println("Enter StudentId to deactivate");
        int id = scan.nextInt();
        boolean deactivated = false;
        scan.nextLine();
        for(Student s : students){
            if(s.getId() == id){
                s.setActive(false);
                System.out.println("Student deactivated successfully");
                deactivated=true;
                break;
            }
        }
        if(!deactivated){
            throw new EntityNotFoundException("Student ID does not exist for deactivation");
        }

    }

    public void removeStudent() throws EntityNotFoundException {
        System.out.println("Enter Student Id to remove");
        int id = scan.nextInt();
        boolean isRemoved = false;
        Iterator<Student> itr = students.iterator();
        while(itr.hasNext()) {
            Student s = itr.next();
            System.out.println(s.toString());
            if (s.getId() == id) {
                itr.remove();
                System.out.println("Student removed successfully");
                isRemoved = true;
                break;
            }
        }
        if(!isRemoved){
               throw new EntityNotFoundException("Student id does not exist");
        }

    }

    public void updateStudent() throws EntityNotFoundException {
        System.out.println("Enter StudentId to update");
        int id = scan.nextInt();
        scan.nextLine();
        boolean isUpdated = false;
        for(Student s : students){
            if(s.getId() == id){
                System.out.print("Enter new batch");
                s.setBatch(scan.next());
                System.out.println("Student updated successfully");
                isUpdated = true;
                break;
            }
        }
        if(!isUpdated){
            throw new EntityNotFoundException("Student id does not exist");
        }

    }

    public void listStudent(){
        if(students.isEmpty()){
            System.out.println("No Students found");
            return;
        }
        for(Student s : students){
            System.out.println(s.toString());
        }

    }

    public void searchStudent() throws EntityNotFoundException {
        System.out.println("Enter StudentId to search");
        int id = scan.nextInt();
        boolean found = false;
        scan.nextLine();
        found = isFound(id, found);
        if(!found){
            throw new EntityNotFoundException("Student id does not exist");
        }
    }

    public boolean isFound(int id, boolean found) {
        for(Student s : students){
            if(s.getId() == id){
                System.out.println("Student found successfully "+s.toString());
                found =true;
                break;
            }
        }
        return found;
    }
}
