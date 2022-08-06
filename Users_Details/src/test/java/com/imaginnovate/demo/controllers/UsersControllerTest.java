package com.imaginnovate.demo.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.imaginnovate.demo.DTO.UsersDTO;
import com.imaginnovate.demo.entities.Address;
import com.imaginnovate.demo.entities.Users;
import com.imaginnovate.demo.service.UsersService;

@SpringBootTest
public class UsersControllerTest {

	@InjectMocks
	UsersController usersController;
	
	@Mock
	private UsersService usersService;
	
	@Test
	public void addUsersDetailsTest() {
		
        Address address = new Address();
    	
    	address.setCity("visakapatnam");
        address.setPincode("535101");
        address.setStreet("kapustreet");
        address.setVillage("madhavadhara");
        address.setId(1);
    	
      List<Address> usersAddress = new ArrayList<>();
      usersAddress.add(address);
      
      UsersDTO usersDTO = new UsersDTO();
      
      usersDTO.setId(1);
      usersDTO.setName("sagar kondeti");
      usersDTO.setUsername("sagar");
      usersDTO.setPhone("8234590922");
      usersDTO.setWebsite("www.sagar.com");
      usersDTO.setEmail("sagar@gmail.com");
      usersDTO.setAddress(usersAddress);
      
      
      Users users = new Users();
      
      users.setId(1);
      users.setName("sagar kondeti");
      users.setUsername("sagar");
      users.setPhone("8234590922");
      users.setWebsite("www.sagar.com");
      users.setEmail("sagar@gmail.com");
      users.setAddress(usersAddress);
       
      when(usersService.addUsersDetails(any(UsersDTO.class))).thenReturn(users);
      
      usersController.addUsersDetails(usersDTO);
      
      verify(usersService, times(1)).addUsersDetails(usersDTO);
    }
	
	@Test
	public void getAllUserDetailsTest() {
		Address address1 = new Address(1,"bhanu street","garividi","vzm","65789");
        Address address2 = new Address(2,"bhanu street","garividi","vzm","65789");
        Address address3 = new Address(3,"raj street","madhavadara","vsk","530001");
        
        List<Address> users1Address = new ArrayList<>();
        users1Address.add(address3);
        users1Address.add(address1);
        Users users1 = new Users(1,"sagar kondeti","sagar","sagar@gmail.com","8234590922","www.sagar.com", users1Address);
        
        List<Address> users2Address = new ArrayList<>();
        users2Address.add(address2);
        
        Users users2 = new Users(2,"divya kondeti","divya","divya@gmail.com","9087612354","www.divya.com",users2Address);
        
        Users users3 = new Users(3,"laxmi kondeti","laxmi","laxmi@gmail.com","9087612354","www.laxmi.com",null);
        List<Users> list = new ArrayList<Users>();
        list.add(users1);
        list.add(users2);
        list.add(users3);
        when(usersService.getAllUsers()).thenReturn(list);
        //test
        List<Users> usersList = usersController.getAllUsers();
        assertEquals(3, usersList.size());
        
        verify(usersService, times(1)).getAllUsers();
	}
	
	
	@Test
    public void updateUserDetailsTest()
    {
        Address address = new Address();
    	
    	address.setCity("visakapatnam");
        address.setPincode("535101");
        address.setStreet("kapustreet");
        address.setVillage("madhavadhara");
        address.setId(1);
    	
      List<Address> usersAddress = new ArrayList<>();
      usersAddress.add(address);
      
      UsersDTO usersDTO = new UsersDTO();
      
      usersDTO.setId(1);
      usersDTO.setName("sagar kondeti");
      usersDTO.setUsername("sagar");
      usersDTO.setPhone("8234590922");
      usersDTO.setWebsite("www.sagar.com");
      usersDTO.setEmail("sagar@gmail.com");
      usersDTO.setAddress(usersAddress);
      
      Users users = new Users();
      
      users.setId(1);
      users.setName("sagar kondeti");
      users.setUsername("sagar");
      users.setPhone("8234590922");
      users.setWebsite("www.sagar.com");
      users.setEmail("sagar@gmail.com");
      users.setAddress(usersAddress);
      
       
      when(usersService.updateUserDetails(any(UsersDTO.class))).thenReturn(users);
      
      usersController.updateUserDetails(usersDTO);
      
      verify(usersService, times(1)).updateUserDetails(usersDTO);
    }
	
	 @Test
	    public void getUserDetailsTest()
	    {
	        
	        Address address1 = new Address(1,"bhanu street","garividi","vzm","65789");
	        
	        List<Address> users1Address = new ArrayList<>();
	        users1Address.add(address1);
	        
	        Optional<Users> users1 = Optional.of(new Users(1,"sagar kondeti","sagar","sagar@gmail.com","8234590922","www.sagar.com", users1Address));
	        when(usersService.getUserDetails(1)).thenReturn(users1);
	        
	        Optional<Users> users=usersController.getUserDetails(1);
	        assertEquals(users1.get().getName(), users.get().getName());
	        assertEquals(users1.get().getPhone(), users.get().getPhone());
	        assertEquals(users1.get().getId(), users.get().getId());
	    }
	 
	 @Test
	    public void deleteByIdTest() {
	    
	    	Address address = new Address(1,"bhanu street","garividi","vzm","65789");
	    	List<Address> userAddress = new ArrayList<>();
	        userAddress.add(address);
	        Users user = new Users(1,"sagar kondeti","sagar","sagar@gmail.com","8234590922","www.sagar.com", userAddress);
	        
	        assertEquals(1, user.getId());
	        usersController.deleteUserDetails(1); 
//	        usersService.deleteUserDetails(1);
//	        verify(usersController).deleteUserDetails(1);
	    
	    }
}
