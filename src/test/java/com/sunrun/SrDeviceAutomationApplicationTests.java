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
		String portModeVlan = "[\"\",\"llo\",\"\"]";
		portModeVlan = portModeVlan.replace("[", "");
		portModeVlan = portModeVlan.replace("]", "");
		portModeVlan = portModeVlan.replace("\"", "");
		portModeVlan = portModeVlan.replace(",", ";");
		System.out.println(portModeVlan);
		String s[] = portModeVlan.split(";");
		System.out.println("s.length="+s.length);
		for(int i=0;i<s.length;i++){
			System.out.println("s["+(1+i)+"]="+s[i]);
		}
		
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
