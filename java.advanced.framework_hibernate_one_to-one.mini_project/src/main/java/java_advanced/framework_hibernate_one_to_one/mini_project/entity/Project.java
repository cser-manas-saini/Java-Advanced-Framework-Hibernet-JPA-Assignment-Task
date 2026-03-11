package java_advanced.framework_hibernate_one_to_one.mini_project.entity;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
