package java_advanced.framework_hibernate_one_to_one.mini_project.entity;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}