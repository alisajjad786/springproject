package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ormconfig.xml");
        StudentDao studentDao = context.getBean("studentDao" , StudentDao.class);

//        Student student = new Student("BS IT", 48, "Sartaj Ali", "DADU CITY");

//        int r= studentDao.insert(student);

//        System.out.println("Done " +r);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean go = true;
       while (go) {
           System.out.println("Press 1 for add new Student! ");
           System.out.println("Press 2 for display all Students!");
           System.out.println("Press 3 for get detail of single Student!");
           System.out.println("Press 4 for deleting the student!");
           System.out.println("Press 5 for updating the Students!");
           System.out.println("Press 6 for exit!!");

           try {
               int input = Integer.parseInt(br.readLine());
               switch (input) {
                   case 1:
                       // add the new the student!!
                       // Taking input from the user!
                       System.out.println("Enter user Department!");
                       String uDepart = br.readLine();

                       System.out.println("Enter user Id: ");
                       int uid = Integer.parseInt(br.readLine());

                       System.out.println("Enter the User Name: ");
                       String uName = br.readLine();

                       System.out.println("Enter User city: ");
                       String uCity = br.readLine();

                       Student s = new Student();
                       s.setStudentDepart(uDepart);
                       s.setStudentId(uid);
                       s.setStudentName(uName);
                       s.setStudentCity(uCity);

                       //Saving Student object to database by calling insert of student dao
                       int r = studentDao.insert(s);
                       System.out.println(r + " Student Added!! ");

                       break;
                   case 2:
                       // Display all Student!!
                       List <Student> allStudents = studentDao.getAllStudent();
                       for (Student st: allStudents) {

                           System.out.println("Name: " +st.getStudentName());
                           System.out.println("Id: " +st.getStudentDepart());
                           System.out.println("Department: " + st.getStudentDepart());
                           System.out.println("City: " + st.getStudentCity());
                           System.out.println("____________________________________");
                       }
                       System.out.println("****************************************");

                       break;
                   case 3:
                       // Get the single Student Data!!
                       System.out.println("Enter user Id: ");
                       int userid = Integer.parseInt(br.readLine());

                      Student student= studentDao.getStudent(userid);

                       System.out.println("Name: " +student.getStudentName());
                       System.out.println("Id: " +student.getStudentDepart());
                       System.out.println("Department: " + student.getStudentDepart());
                       System.out.println("City: " + student.getStudentCity());
                       System.out.println("____________________________________");

                       break;
                   case 4:
                       // Delete the student!!
                       System.out.println("Enter user Id for deleting: ");

                       int id = Integer.parseInt(br.readLine());
                       studentDao.deleteStudent(id);

                       System.out.println("Student Detail Deleted Successfully from the database!! ");
                       break;
                   case 5:
                       // Update the student!!
                       System.out.println("Enter user Id for updating: ");
                       int idup = Integer.parseInt(br.readLine());

                       // Retrieve the student from the database
                       Student studentToUpdate = studentDao.getStudent(idup);

                       if (studentToUpdate != null) {
                           System.out.println("Current student details:");
                           System.out.println("Name: " + studentToUpdate.getStudentName());
                           System.out.println("Department: " + studentToUpdate.getStudentDepart());
                           System.out.println("City: " + studentToUpdate.getStudentCity());
                           System.out.println("____________________________________");

                           System.out.println("Enter the updated Name: ");
                           String updatedName = br.readLine();
                           System.out.println("Enter the updated Department: ");
                           String updatedDepartment = br.readLine();
                           System.out.println("Enter the updated City: ");
                           String updatedCity = br.readLine();

                           // Update the student attributes
                           studentToUpdate.setStudentName(updatedName);
                           studentToUpdate.setStudentDepart(updatedDepartment);
                           studentToUpdate.setStudentCity(updatedCity);

                           // Save the updated student back to the database
                           studentDao.updateStudent(studentToUpdate);

                           System.out.println("Student Updated Successfully!");
                       } else {
                           System.out.println("Student with ID " + idup + " not found in the database.");
                       }
                       break;
                   case 6:
                       // Exit the Application!!
                       go = false;
                       break;
               }

           } catch (Exception e) {
               System.out.println("Invalid Input Try with another one!!");
               System.out.println(e.getMessage());
           }
       }
        System.out.println("Thank you for using my APPLICATION!! ");
        System.out.println("See You Soon!! ");
    }
}