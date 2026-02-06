import com.airtribe.learntrack.HelloWorld;
import com.airtribe.learntrack.student.exception.EntityNotFoundException;
import com.airtribe.learntrack.student.service.StudentService;
import com.airtribe.learntrack.student.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws EntityNotFoundException {

        HelloWorld hw = new HelloWorld();
        hw.print();
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        int choice;
        int i = 0;
        do {
            System.out.print(i + " ");
            i++;
        } while (i < 3);

        do {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Search Student");
            System.out.println("6. Deactivate Student");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addStudent();
                    break;
                case 2:
                    service.listStudent();
                    break;
                case 3:
                    try{
                        service.removeStudent();
                    }catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    try{
                    service.updateStudent();
                    }catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:try{
                    service.searchStudent();   }
                catch(EntityNotFoundException e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 6:try{
                    service.deactivateStudent();   }catch(EntityNotFoundException e){
                    System.out.println(e.getMessage());
                }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 7);

        sc.close();
    }
}

