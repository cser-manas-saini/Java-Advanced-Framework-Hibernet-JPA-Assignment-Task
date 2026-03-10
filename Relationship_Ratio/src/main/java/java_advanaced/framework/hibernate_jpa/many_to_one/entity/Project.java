package java_advanaced.framework.hibernate_jpa.many_to_one.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="ProjectManyOne")
public class Project implements Serializable {

@Id
private Integer id;

private String name;

private String description;

@OneToMany(mappedBy = "project")
private List<Student> students;

public Project(){}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public List<Student> getStudents() {
return students;
}

public void setStudents(List<Student> students) {
this.students = students;
}

@Override
public String toString() {
return "Project [id=" + id + ", name=" + name + ", description=" + description + "]";
}

}