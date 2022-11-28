package com.example.Mapping.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Standard {
	@Id
	private int classid;
	private int standard;
	private String section;

}
