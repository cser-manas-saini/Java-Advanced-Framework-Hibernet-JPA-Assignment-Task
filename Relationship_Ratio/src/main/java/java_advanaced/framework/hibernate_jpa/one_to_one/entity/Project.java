package java_advanaced.framework.hibernate_jpa.one_to_one.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Project implements Serializable {

@Id
private Integer id;

private String name;
private String description;

public Project(){}

public Project(Integer id,String name,String description){
this.id=id;
this.name=name;
this.description=description;
}

public Integer getId(){ return id; }

public void setId(Integer id){ this.id=id; }

public String getName(){ return name; }

public void setName(String name){ this.name=name; }

public String getDescription(){ return description; }

public void setDescription(String description){ this.description=description; }

}