package com.imaginnovate.demo.controller.intigrated;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.web.client.RestTemplate;

import com.imaginnovate.demo.DTO.UsersDTO;
import com.imaginnovate.demo.entities.Address;
import com.imaginnovate.demo.entities.Users;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegratedTest{
	
	@LocalServerPort
	private int port;	
	
	private String baseURL="http://localhost";
	
	private static RestTemplate restTemplate;
	
	@Autowired
	private UsersRepositoryH2 usersRepositoryH2;
	
	@BeforeAll
	public static void init()
	{
		restTemplate=new RestTemplate();
	}
	
	@BeforeEach
	public void setUp()
	{
		baseURL=baseURL.concat(":").concat(port+"");
	}
	
	@Test
	@Sql(statements = "DELETE From address where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	@Sql(statements = "DELETE From users where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	public void addUsersDetailsTest()
	{
		Address address=new Address(1,"bhanu street","garividi","vzm","65789");
		List<Address> usersAddress=new ArrayList<>();
		usersAddress.add(address);
		UsersDTO userDTO = new UsersDTO(1,"sagar kondeti","sagar","sagar@gmail.com","8234590922","www.sagar.com", usersAddress);
		Users user= restTemplate.postForObject(baseURL.concat("/addUsersDetails"), userDTO, Users.class);
		assertEquals(1, user.getId());
		assertEquals("sagar kondeti", user.getName());
		assertEquals(1, usersRepositoryH2.findAll().size());
	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id, email, name, phone, username, website) VALUES (1, 'sagar1@gmail.com', 'sagar kondeti', '67584399', 'sagar', 'www.sagar.com')",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "	INSERT INTO address(id, city, pincode, street, village, user_id) VALUES (1, 'VZM', '67589', 'bhanu street', 'garividi', 1)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE From address where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	@Sql(statements = "DELETE From users where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	public void updateUsersDetailsTest()
	{
		Address address=new Address(1,"bhanu street","garividi","vzm","65789");
		List<Address> usersAddress=new ArrayList<>();
		usersAddress.add(address);
		UsersDTO userDTO = new UsersDTO(1,"sagar kondeti","sagar","sagar@gmail.com","8234590922","www.sagar.com", usersAddress);
		Users user= restTemplate.postForObject(baseURL.concat("/updateUser"), userDTO,Users.class);
		assertEquals(1, user.getId());
		assertEquals(1, user.getAddress().get(0).getId());
		assertEquals("sagar@gmail.com", user.getEmail());
		assertEquals("8234590922", user.getPhone());
		assertEquals("65789",user.getAddress().get(0).getPincode());
		assertEquals(1, usersRepositoryH2.findAll().size());
	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id, email, name, phone, username, website) VALUES (1, 'sagar1@gmail.com', 'sagar kondeti', '67584399', 'sagar', 'www.sagar.com')",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "	INSERT INTO address(id, city, pincode, street, village, user_id) VALUES (1, 'VZM', '67589', 'bhanu street', 'garividi', 1)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE From address where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	@Sql(statements = "DELETE From users where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	public void getAllUsersTest()
	{
		List<Users> users=restTemplate.getForObject(baseURL.concat("/getAllUsers"),List.class);
		assertEquals(1, users.size());
		assertEquals(1, usersRepositoryH2.findAll().size());

		
	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id, email, name, phone, username, website) VALUES (1, 'sagar1@gmail.com', 'sagar kondeti', '67584399', 'sagar', 'www.sagar.com')",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "	INSERT INTO address(id, city, pincode, street, village, user_id) VALUES (1, 'VZM', '67589', 'bhanu street', 'garividi', 1)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE From address where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	@Sql(statements = "DELETE From users where id=1",executionPhase = ExecutionPhase.AFTER_TEST_METHOD )
	public void getUserDetailsTest()
	{
		Users users=restTemplate.getForObject(baseURL.concat("/getUser/{id}"),Users.class,1);

		assertNotNull(users);
		assertEquals(1,users.getId());
		assertEquals("sagar1@gmail.com", users.getEmail());
	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id, email, name, phone, username, website) VALUES (1, 'sagar1@gmail.com', 'sagar kondeti', '67584399', 'sagar', 'www.sagar.com')",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "	INSERT INTO address(id, city, pincode, street, village, user_id) VALUES (1, 'VZM', '67589', 'bhanu street', 'garividi', 1)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteUserDetailsTest()
	{
		int recordCount = usersRepositoryH2.findAll().size();
		assertEquals(1,recordCount);
	    restTemplate.delete(baseURL.concat("/deleteUser/{id}"),1);
	    
	    assertEquals(0,usersRepositoryH2.findAll().size());
	} 
}