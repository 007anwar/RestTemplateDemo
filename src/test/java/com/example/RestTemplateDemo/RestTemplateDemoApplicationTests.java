package com.example.RestTemplateDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RestTemplateDemoApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("hello");
	}
	@Test
	void testGetall()
	{
		RestTemplate restTemplate = new RestTemplate();
		Object forObject = restTemplate.getForObject("http://localhost:8020/employee", Object.class);
		System.out.println(forObject);
	}
	@Test
	void testGet()
	{
		RestTemplate restTemplate = new RestTemplate();
		Object forObject = restTemplate.getForObject("http://localhost:8020/employee/1", Object.class);
		System.out.println(forObject);
	}
	@Test
	void testPost() {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> map = new HashMap<>();
		map.put("name", "Nihilent");
		map.put("designation", "Company");
		map.put("email", "Nihilent@test.com");
		ResponseEntity<Void> voidResponseEntity = restTemplate.postForEntity("http://localhost:8020/employee", map, void.class);
		System.out.println(voidResponseEntity);
	}
	@Test
	void testPut() {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> map = new HashMap<>();
		map.put("id", "2");
		map.put("name", "Azam");
		restTemplate.put("http://localhost:8020/employee", map);

	}
	@Test
	void testDelete(int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8020/employee/"+id);

	}


	@Test
			void calldelete()
	{
		this.testDelete(2);

	}




	}




