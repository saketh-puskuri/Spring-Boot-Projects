package com.example.Mapping.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	private int rollno;
	private String name;
	private int marks;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "laptopid", referencedColumnName = "lid",unique=true)
	private Laptop laptop;
	@ManyToOne
	private Standard standard;
}
