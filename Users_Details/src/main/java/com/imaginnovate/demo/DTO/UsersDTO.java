package com.imaginnovate.demo.DTO;

import java.util.List;

import com.imaginnovate.demo.entities.Address;
import com.imaginnovate.demo.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDTO {
	
    private int id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String phone;
		
	private String website;
	
	private List<Address> address;

}
