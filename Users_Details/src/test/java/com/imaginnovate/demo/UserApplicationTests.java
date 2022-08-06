package com.imaginnovate.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserApplicationTests {
	
	
	@Test
    public void contextLoads() {
		assertThat(true);
	}
	
	@Test
	  public  void applicationStarts() {
		UserApplication.main(new String[] {"hello","world"});
	  }

}