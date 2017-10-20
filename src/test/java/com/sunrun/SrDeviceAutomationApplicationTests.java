package com.sunrun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {


	@Test
	public void contextLoads() {
		
	}
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(1);
		List<Object> methods = new ArrayList<Object>();
		methods.addAll(set);
		System.out.println(methods.toString());
		
		String error = "1 2 3 fail";
		error = error.substring(0, error.indexOf(" fail"));
		System.out.println(error);
	}

	
}
