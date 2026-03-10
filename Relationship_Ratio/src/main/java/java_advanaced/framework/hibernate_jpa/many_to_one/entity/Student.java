package java_advanaced.framework.hibernate_jpa.many_to_one.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="StudentManyOne")
public class Student implements Serializable {

@Id
private Integer id;

private String name;

private String mailId;

private Long contactNumber;

@ManyToOne
@JoinColumn(name="project_id")

private Project project;

public Student(){}

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

public String getMailId() {
return mailId;
}

public void setMailId(String mailId) {
this.mailId = mailId;
}

public Long getContactNumber() {
return contactNumber;
}

public void setContactNumber(Long contactNumber) {
this.contactNumber = contactNumber;
}

public Project getProject() {
return project;
}

public void setProject(Project project) {
this.project = project;
}

@Override
public String toString() {
return "Student [id=" + id + ", name=" + name + ", mailId=" + mailId + "]";
}

}