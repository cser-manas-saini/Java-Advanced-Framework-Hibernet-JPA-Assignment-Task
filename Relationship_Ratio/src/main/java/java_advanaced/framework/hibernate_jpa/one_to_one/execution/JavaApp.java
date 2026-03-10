
package java_advanaced.framework.hibernate_jpa.one_to_one.execution;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java_advanaced.framework.hibernate_jpa.one_to_one.entity.Project;
import java_advanaced.framework.hibernate_jpa.one_to_one.entity.Student;

public class JavaApp {

    public static void execution() {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Student_Project");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        System.out.println("====== Student Project Management ======");
        System.out.println("1. Insert Student & Project");
        System.out.println("2. Update Student Name");
        System.out.println("3. Delete Student");
        System.out.println("4. Find Student");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch(choice) {

        case 1:

            et.begin();

            System.out.print("Enter Project Id: ");
            int pid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Project Name: ");
            String pname = sc.nextLine();

            System.out.print("Enter Project Description: ");
            String pdesc = sc.nextLine();

            Project project = new Project();
            project.setId(pid);
            project.setName(pname);
            project.setDescription(pdesc);

            em.persist(project);

            System.out.print("Enter Student Id: ");
            int sid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String sname = sc.nextLine();

            System.out.print("Enter Student Email: ");
            String mail = sc.nextLine();

            System.out.print("Enter Contact Number: ");
            long contact = sc.nextLong();

            Student student = new Student();
            student.setId(sid);
            student.setName(sname);
            student.setMailId(mail);
            student.setContactNumber(contact);
            student.setProject(project);

            em.persist(student);

            et.commit();

            System.out.println("Student Inserted Successfully");

            break;



        case 2:

            System.out.print("Enter Student Id to Update: ");
            int uid = sc.nextInt();
            sc.nextLine();

            Student updateStudent = em.find(Student.class, uid);

            if(updateStudent != null) {

                et.begin();

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                updateStudent.setName(newName);

                em.merge(updateStudent);

                et.commit();

                System.out.println("Student Updated");

            } else {

                System.out.println("Student Not Found");
            }

            break;



        case 3:

            System.out.print("Enter Student Id to Delete: ");
            int did = sc.nextInt();

            Student deleteStudent = em.find(Student.class, did);

            if(deleteStudent != null) {

                et.begin();

                em.remove(deleteStudent);

                et.commit();

                System.out.println("Student Deleted");

            } else {

                System.out.println("Student Not Found");
            }

            break;



        case 4:

            System.out.print("Enter Student Id: ");
            int fid = sc.nextInt();

            Student findStudent = em.find(Student.class, fid);

            if(findStudent != null) {

                System.out.println(findStudent);

            } else {

                System.out.println("Student Not Found");
            }

            break;



        default:
            System.out.println("Invalid Choice");
        }

        em.close();
        emf.close();
        sc.close();
    }
}
