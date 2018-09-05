package com.example.jpa.demo.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "modeltype")
public class ModelType {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String name;	

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="MODELTYPE_ID")
	private List<Model> models = new ArrayList<Model>();

  @Override
  public String toString() {
    return "ModelType{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", models=" + models +
        '}';
  }
}
