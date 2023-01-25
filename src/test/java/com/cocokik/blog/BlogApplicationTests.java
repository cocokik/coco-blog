package com.cocokik.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

	@Test
	void contextLoads() {
		String test = "!111";
		change(test);
		System.out.println(test);
	}

	void change(String test){
		test = test + "aaaa";
		System.out.println(test);
	}

}
