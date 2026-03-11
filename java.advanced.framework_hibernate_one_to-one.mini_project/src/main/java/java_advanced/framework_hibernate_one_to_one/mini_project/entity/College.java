package java_advanced.framework_hibernate_one_to_one.mini_project.entity;

import javax.persistence.*;

@Entity
public class College {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
