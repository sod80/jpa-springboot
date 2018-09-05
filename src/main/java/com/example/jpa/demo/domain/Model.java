package com.example.jpa.demo.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@NamedQuery(name="Model.findAllModelsByType", query="select m from Model m where m.modelType.name = :name")
public class Model {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String name;	
	private BigDecimal price;
	private int frets;
	private String woodType;
	private Date yearFirstMade;

	public Model(Long id, String name, BigDecimal price, int frets, String woodType,
			Date yearFirstMade) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.frets = frets;
		this.woodType = woodType;
		this.yearFirstMade = yearFirstMade;
	}

	@ManyToOne
	private Manufacturer manufacturer;

	@ManyToOne
	private ModelType modelType;

	@Override
	public String toString() {
		return "Model{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", frets=" + frets +
				", woodType='" + woodType + '\'' +
				", yearFirstMade=" + yearFirstMade +
				", manufacturer=" + manufacturer +
				", modelType=" + modelType +
				'}';
	}
}
