package com.imaginnovate.demo.service;
import static org.mockito.ArgumentMatchers.any;
import  static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.imaginnovate.demo.DTO.UsersDTO;
import com.imaginnovate.demo.entities.Address;
import com.imaginnovate.demo.entities.Users;
import com.imaginnovate.demo.repositories.UsersRepository;

@SpringBootTest
public class UsersServiceTest {
    
    @Autowired
    private UsersService usersService;
    
    ModelMapper mm = new ModelMapper();
    
    @Mock
    private UsersRepository userRepository;
    
    
    @BeforeEach
    void initUseCase() {
        usersService = new UsersService(userRepository);
    }
        
    
    @Test
    public void addUsersDetailsTest()
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
      
    
      Users users = mm.map(usersDTO, Users.class);
       
      when(userRepository.save(any(Users.class))).thenReturn(users);
      
      Users user = usersService.addUsersDetails(usersDTO);
     
      assertEquals(user, users);
      
      verify(userRepository, times(1)).save(users);
      
    
    }
    
    @Test
    public void getAllUsersTest()
    {
        
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
        when(userRepository.findAll()).thenReturn(list);
        //test
        List<Users> usersList = usersService.getAllUsers();
        assertEquals(3, usersList.size());
        
        verify(userRepository, times(1)).findAll();
    }
    
    @Test
    public void updateUsersDetailsTest()
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
      
    
      Users users = mm.map(usersDTO, Users.class);
       
      when(userRepository.save(any(Users.class))).thenReturn(users);
      
      Users user = usersService.updateUserDetails(usersDTO);
     
      assertEquals(user, users);
      
      verify(userRepository, times(1)).save(users);
    }
    
    @Test
    public void getUserDetailsTest()
    {
        
        Address address1 = new Address(1,"bhanu street","garividi","vzm","65789");
        
        List<Address> users1Address = new ArrayList<>();
        users1Address.add(address1);
        
        Optional<Users> users1 = Optional.of(new Users(1,"sagar kondeti","sagar","sagar@gmail.com","8234590922","www.sagar.com", users1Address));
        when(userRepository.findById(1)).thenReturn(users1);
        
        Optional<Users> users=usersService.getUserDetails(1);
        assertEquals("sagar kondeti", users.get().getName());
        assertEquals("8234590922", users.get().getPhone());
        assertEquals(1, users.get().getId());
    }
    
   
    @Test
    public void test() {
    
    usersService.deleteUserDetails(1);
    	    
    verify(userRepository).deleteById(1); 
    
    }
    
}