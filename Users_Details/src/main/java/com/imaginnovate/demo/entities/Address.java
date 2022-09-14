package com.imaginnovate.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	@Id
	private int id;
	
	private String street;
	
	private String village;
	
	private String city;
	
	private String pincode;
	
	
}
