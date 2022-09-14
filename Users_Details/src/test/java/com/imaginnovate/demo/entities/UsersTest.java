package com.imaginnovate.demo.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.imaginnovate.demo.DTO.UsersDTO;


public class UsersTest {

	public Users crateTestSuite(){
	      return new Users();
	     }
	
	 @Test
	 public void testGetId() {
		 Users users =null;
		 users = crateTestSuite();
	     users.getId();

	    } 
	 
	 @Test
	 public void setId() {
		 int id=1;
		 Users users =null;
		 users = crateTestSuite();
		 users.setId(1);
	     assertEquals(users.getId(),id);

	    }      
	 
	 @Test
	 public void testGetName() {
	     Users users =null;
	     users = crateTestSuite();
	     users.getName();

	    } 
	 @Test
	 public void setName() {
		 String name1="sagar";
		 Users users =null;
	     users = crateTestSuite();
	     users.setName(name1);
	     assertEquals(users.getName(),name1);

	    }  
	 @Test
	 public void testGetUsername() {
	     Users users =null;
	     users = crateTestSuite();
	     users.getUsername();

	    } 
	 @Test
	 public void setUsername() {
		 String username="sagar kondeti";
		 Users users =null;
	     users = crateTestSuite();
	     users.setUsername(username);
	     assertEquals(users.getUsername(),username);

	    } 
	 @Test
	 public void testGetEmail() {
	     Users users =null;
	     users = crateTestSuite();
	     users.getEmail();

	    } 
	 @Test
	 public void setEmail() {
		 String email="sagarkondeti@gmail.com";
		 Users users =null;
	     users = crateTestSuite();
	     users.setEmail(email);
	     assertEquals(users.getEmail(),email);

	    } 
	 @Test
	 public void testGetPhone() {
	     Users users =null;
	     users = crateTestSuite();
	     users.getPhone();

	    } 
	 @Test
	 public void setPhone() {
		 String phone="8345678123";
		 Users users =null;
	     users = crateTestSuite();
	     users.setPhone(phone);
	     assertEquals(users.getPhone(),phone);

	    } 
	 @Test
	 public void testGetWebsite() {
	     Users users =null;
	     users = crateTestSuite();
	     users.getWebsite();

	    }
	 @Test
	 public void setWebsite() {
		 String website="www.sagar.com";
		 Users users =null;
	     users = crateTestSuite();
	     users.setWebsite(website);
	     assertEquals(users.getWebsite(),website);

	    } 
	 
	 @Test
	 public void testGetAddress() {
	     List<Address> address= new ArrayList();
	     address=null;
	     Users users =null;
	     users = crateTestSuite();
	     address = users.getAddress();

	    } 
	 
	 @Test
	 public void setAddress() {
		 List<Address> address= new ArrayList();
	     address=null;
	     Users users =null;
	     users = crateTestSuite();
	     users.setAddress(address);
	    }
	 
	 @Test
	 public void TestUsers()
	 {
		 Users user= new Users(0,null, null, null, null, null, null);
	 }
	 
	 @Test
	 public void ToString()
	 {
		 Users Users= new Users(0,null, null, null, null, null, null);

	     assertEquals(Users.toString(), "Users(id=0, name=null, username=null, email=null, phone=null, website=null, address=null)"
);
	 }
	 
	 @Test
	 public void HashCode()
	 {
		 Users Users= new Users(0,null, null, null, null, null, null);
		 Users Users1 = new Users(0,null, null, null, null, null, null);

	     assertEquals(Users.hashCode(), Users1.hashCode());
	 }
	 
	 @Test
	 public void TestEquals()
	 {
		 Users users= new Users(1,null, null, null, null, null, null);
		 Users users1 = new Users(1,null, null, null, null, null, null);

	     assertThat(users).isEqualTo(users1);
	 }
}
