package java_development.framework.hibernate_jpa.main;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java_development.framework.hibernate_jpa.entity.Employee;

public class JavaApp {

    public static void execution() {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Employee");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        int choice;

        do {

            System.out.println("\n------ Employee Management ------");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Find Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Email: ");
                    String email = sc.next();

                    System.out.print("Enter Contact Number: ");
                    long contact = sc.nextLong();

                    Employee emp = new Employee();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setMailId(email);
                    emp.setContactNumber(contact);

                    et.begin();
                    em.persist(emp);
                    et.commit();

                    System.out.println("Employee Added Successfully");

                    break;

                case 2:

                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();

                    Employee empUpdate = em.find(Employee.class, updateId);

                    if(empUpdate != null) {

                        et.begin();

                        System.out.print("Enter New Email: ");
                        empUpdate.setMailId(sc.next());

                        System.out.print("Enter New Contact Number: ");
                        empUpdate.setContactNumber(sc.nextLong());

                        et.commit();

                        System.out.println("Employee Updated");

                    } else {
                        System.out.println("Employee Not Found");
                    }

                    break;

                case 3:

                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    Employee empDelete = em.find(Employee.class, deleteId);

                    if(empDelete != null) {

                        et.begin();
                        em.remove(empDelete);
                        et.commit();

                        System.out.println("Employee Deleted");

                    } else {
                        System.out.println("Employee Not Found");
                    }

                    break;

                case 4:

                    System.out.print("Enter Employee ID to Find: ");
                    int findId = sc.nextInt();

                    Employee empFind = em.find(Employee.class, findId);

                    if(empFind != null) {
                        System.out.println(
                                empFind.getId() + " " +
                                empFind.getName() + " " +
                                empFind.getMailId() + " " +
                                empFind.getContactNumber()
                        );
                    }
                    else {
                        System.out.println("Employee Not Found");
                    }

                    break;

            }

        } while(choice != 5);

        em.close();
        emf.close();
        sc.close();
    }
}