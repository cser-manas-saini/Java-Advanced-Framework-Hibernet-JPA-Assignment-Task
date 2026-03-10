package java_advanaced.framework.hibernate_jpa.one_to_one.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student implements Serializable {

@Id
private Integer id;

private String name;
private String mailId;
private Long contactNumber;

@OneToOne
private Project project;

public Student() {}

public Student(Integer id,String name,String mailId,Long contactNumber,Project project){
this.id=id;
this.name=name;
this.mailId=mailId;
this.contactNumber=contactNumber;
this.project=project;
}

public Integer getId(){ return id; }

public void setId(Integer id){ this.id=id; }

public String getName(){ return name; }

public void setName(String name){ this.name=name; }

public String getMailId(){ return mailId; }

public void setMailId(String mailId){ this.mailId=mailId; }

public Long getContactNumber(){ return contactNumber; }

public void setContactNumber(Long contactNumber){ this.contactNumber=contactNumber; }

public Project getProject(){ return project; }

public void setProject(Project project){ this.project=project; }

}