package java_advanced.framework_hibernate_one_to_one.mini_project.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne
    private Project project;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
