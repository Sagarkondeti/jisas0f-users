package com.imaginnovate.demo.DTO;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import  static org.junit.jupiter.api.Assertions.assertEquals;
import com.imaginnovate.demo.entities.Address;

public class UsersDTOTest {

	public UsersDTO crateTestSuite(){
	      return new UsersDTO();
	     }
	
	 @Test
	 public void testGetId() {
	     UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.getId();

	    } 
	 
	 @Test
	 public void setId() {
		 int id=1;
		 UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.setId(1);
	     assertEquals(usersDTO.getId(),id);

	    }      
	 
	 @Test
	 public void testGetName() {
	     UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.getName();

	    } 
	 @Test
	 public void setName() {
		 String name1="sagar";
		 UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.setName(name1);
	     assertEquals(usersDTO.getName(),name1);

	    }  
	 @Test
	 public void testGetUsername() {
	     UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.getUsername();

	    } 
	 @Test
	 public void setUsername() {
		 String username="sagar kondeti";
		 UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.setUsername(username);
	     assertEquals(usersDTO.getUsername(),username);

	    } 
	 @Test
	 public void testGetEmail() {
	     UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.getEmail();

	    } 
	 @Test
	 public void setEmail() {
		 String email="sagarkondeti@gmail.com";
		 UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.setEmail(email);
	     assertEquals(usersDTO.getEmail(),email);

	    } 
	 @Test
	 public void testGetPhone() {
	     UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.getPhone();

	    } 
	 @Test
	 public void setPhone() {
		 String phone="8345678123";
		 UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.setPhone(phone);
	     assertEquals(usersDTO.getPhone(),phone);

	    } 
	 @Test
	 public void testGetWebsite() {
	     UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.getWebsite();

	    }
	 @Test
	 public void setWebsite() {
		 String website="www.sagar.com";
		 UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.setWebsite(website);
	     assertEquals(usersDTO.getWebsite(),website);

	    } 
	 
	 @Test
	 public void testGetAddress() {
	     List<Address> address= new ArrayList();
	     address=null;
	     UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     address = usersDTO.getAddress();
	    } 
	 
	 @Test
	 public void setAddress() {
		 List<Address> address= new ArrayList();
	     address=null;
		 UsersDTO usersDTO =null;
	     usersDTO = crateTestSuite();
	     usersDTO.setAddress(address);
	    }
	 
	 @Test
	 public void TestUsersDTO()
	 {
		 UsersDTO user= new UsersDTO(0,null, null, null, null, null, null);
	 }
	 
	 @Test
	 public void TestToString()
	 {
		 UsersDTO usersDTO= new UsersDTO(0,null, null, null, null, null, null);

	     assertEquals(usersDTO.toString(), "UsersDTO(id=0, name=null, username=null, email=null, phone=null, website=null, address=null)"
);
	 }
	 
	 @Test
	 public void HashCode()
	 {
		 UsersDTO usersDTO= new UsersDTO(1,null, null, null, null, null, null);
		 UsersDTO usersDTO1 = new UsersDTO(1,null, null, null, null, null, null);

	     assertEquals(usersDTO.hashCode(), usersDTO1.hashCode());
	 }
	 
	 @Test
	 public void TestEquals()
	 {
		 UsersDTO usersDTO= new UsersDTO(1,null, null, null, null, null, null);
		 UsersDTO usersDTO1 = new UsersDTO(1,null, null, null, null, null, null);

	     assertThat(usersDTO).isEqualTo(usersDTO1);
	 }
	 
}
