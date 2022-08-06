package com.imaginnovate.demo.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressTest {

	public Address crateTestSuite(){
	      return new Address();
	     }
	
	 @Test
	 public void testGetId() {
		 Address address =null;
		 address = crateTestSuite();
	     address.getId();
	    } 
	 
	 @Test
	 public void setId() {
		 int id=1;
		 Address address =null;
		 address = crateTestSuite();
		 address.setId(1);
	     assertEquals(address.getId(),id);

	    }      
	 
	 @Test
	 public void testGetCity() {
	     Address address =null;
	     address = crateTestSuite();
	     address.getCity();

	    } 
	 @Test
	 public void setCity() {
		 String name="VSP";
		 Address address =null;
	     address = crateTestSuite();
	     address.setCity(name);
	     assertEquals(address.getCity(),name);

	    }  
	 @Test
	 public void testGetPincode() {
	     Address address =null;
	     address = crateTestSuite();
	     address.getPincode();

	    } 
	 @Test
	 public void setPincode() {
		 String pincode="535101";
		 Address address =null;
	     address = crateTestSuite();
	     address.setPincode(pincode);
	     assertEquals(address.getPincode(),pincode);

	    } 
	 @Test
	 public void testGetStreet() {
	     Address address =null;
	     address = crateTestSuite();
	     address.getStreet();

	    } 
	 @Test
	 public void setStreet() {
		 String street="kalingastreet";
		 Address address =null;
	     address = crateTestSuite();
	     address.setStreet(street);
	     assertEquals(address.getStreet(),street);

	    } 
	 @Test
	 public void testGetVillage() {
	     Address address =null;
	     address = crateTestSuite();
	     address.getVillage();

	    } 
	 @Test
	 public void setVillage() {
		 String village="madhavadhara";
		 Address address =null;
	     address = crateTestSuite();
	     address.setVillage(village);
	     assertEquals(address.getVillage(),village);

	    } 
	 
	 
	 @Test
	 public void TestAddress()
	 {
		 Address address= new Address(0, null, null, null, null);
	 }
	 
	 @Test
	 public void ToString()
	 {
		 Address address= new Address(0, null, null, null, null);

	     assertEquals(address.toString(),"Address(id=0, street=null, village=null, city=null, pincode=null)");
	 }
	 
	 @Test
	 public void HashCode()
	 {
		 Address Address= new Address(0, null, null, null, null);
		 Address Address1 = new Address(0, null, null, null, null);

	     assertEquals(Address.hashCode(), Address1.hashCode());
	 }
	 
	 @Test
	 public void TestEquals()
	 {
		 Address address= new Address(0, null, null, null, null);
		 Address address1 = new Address(0, null, null, null, null);

	     assertThat(address).isEqualTo(address1);
	 }
}
