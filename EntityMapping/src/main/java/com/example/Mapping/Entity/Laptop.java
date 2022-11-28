package com.example.Mapping.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Laptop {
	@Id
	private int lid;
	private String lname;
}
