import com.airtribe.learntrack.HelloWorld;
import com.airtribe.learntrack.course.exception.CourseNotFoundException;
import com.airtribe.learntrack.course.service.CourseService;
import com.airtribe.learntrack.course.service.CourseServiceImpl;
import com.airtribe.learntrack.enrollment.exception.EnrollmentNotFoundException;
import com.airtribe.learntrack.enrollment.service.EnrollmentService;
import com.airtribe.learntrack.enrollment.service.EnrollmentServiceImpl;
import com.airtribe.learntrack.student.exception.EntityNotFoundException;
import com.airtribe.learntrack.student.service.StudentService;
import com.airtribe.learntrack.student.service.impl.StudentServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Menu {
    public static void main(String[] args) throws EntityNotFoundException, CourseNotFoundException {

        HelloWorld hw = new HelloWorld();
        hw.print();
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(studentService,courseService);

        int choice;

        do {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Search Student");
            System.out.println("6. Deactivate Student");
            System.out.println("\n--- Course Menu---");
            System.out.println("7. Add New Course");
            System.out.println("8. View all Course");
            System.out.println("9. Activate/Deactivate a Course");
            System.out.println("\n--- Enrollment Menu-------------");
            System.out.println("10. Enroll a  Student");
            System.out.println("11. View Enrollement for Student");
            System.out.println("12. Mark Enrollment as Completed");


            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    studentService.addStudent();
                    break;
                case 2:
                    studentService.listStudent();
                    break;
                case 3:
                    try{
                        studentService.removeStudent();
                    }catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    try{
                        studentService.updateStudent();
                    }catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:try{
                    studentService.searchStudent();   }
                catch(EntityNotFoundException e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 6:try{
                    studentService.deactivateStudent();   }catch(EntityNotFoundException e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 7:
                    courseService.addCourse();
                break;
                case 8:
                    courseService.getAllCourses();
                    break;
                case 9:try{
                    courseService.deactivateCourse();   }
                catch(EntityNotFoundException e){
                    System.out.println(e.getMessage());
                }break;
                case 10:try{
                    enrollmentService.enrollStudent();}
                      catch (EntityNotFoundException | CourseNotFoundException e ) {
                    System.out.println(e.getMessage());
                     }
                    break;
                case 11:try{
                    enrollmentService.viewEnrollments();}
                catch (EnrollmentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                    break;
                case 12:try{
                    enrollmentService.markEnrollment();}
                catch (EnrollmentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 15);

        sc.close();
    }
}

