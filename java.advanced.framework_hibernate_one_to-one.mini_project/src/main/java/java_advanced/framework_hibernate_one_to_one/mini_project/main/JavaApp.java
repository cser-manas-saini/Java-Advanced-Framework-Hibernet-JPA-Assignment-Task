package java_advanced.framework_hibernate_one_to_one.mini_project.main;

import javax.persistence.*;

import java_advanced.framework_hibernate_one_to_one.mini_project.entity.*;

import java.util.Scanner;

public class JavaApp {

    public static void execution() {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Taking inputs from user

        System.out.print("Enter University Name: ");
        String universityName = sc.nextLine();

        System.out.print("Enter College Name: ");
        String collegeName = sc.nextLine();

        System.out.print("Enter Department Name: ");
        String departmentName = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Project Title: ");
        String projectTitle = sc.nextLine();

        // Creating objects

        Project p = new Project();
        p.setTitle(projectTitle);

        Student s = new Student();
        s.setName(studentName);
        s.setProject(p);

        Department d = new Department();
        d.setName(departmentName);
        d.setStudent(s);

        College c = new College();
        c.setName(collegeName);
        c.setDepartment(d);

        University u = new University();
        u.setName(universityName);
        u.setCollege(c);

        // Saving data

        et.begin();

        em.persist(p);
        em.persist(s);
        em.persist(d);
        em.persist(c);
        em.persist(u);

        et.commit();

        System.out.println("\nData Saved Successfully!");

        em.close();
        emf.close();
        sc.close();
    }
}