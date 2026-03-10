package java_advanaced.framework.hibernate_jpa.one_to_many.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="StudentMany")
public class Student implements Serializable {

@Id
private Integer id;

private String name;

private String mailId;

private Long contactNumber;

@OneToMany(cascade = CascadeType.ALL)
private List<Project> projects;

public Student(){}

public List<Project> getProjects() {
    return projects;
}

public void setProjects(List<Project> projects) {
    this.projects = projects;
}

public Integer getId(){ return id; }

public void setId(Integer id){ this.id=id; }

public String getName(){ return name; }

public void setName(String name){ this.name=name; }

public String getMailId(){ return mailId; }

public void setMailId(String mailId){ this.mailId=mailId; }

public Long getContactNumber(){ return contactNumber; }

public void setContactNumber(Long contactNumber){ this.contactNumber=contactNumber; }

}