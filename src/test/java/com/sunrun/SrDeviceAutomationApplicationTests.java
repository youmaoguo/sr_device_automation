package com.sunrun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.mapper.DevOnlineTaskMapper;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
@WebAppConfiguration
@Configuration
@EnableTransactionManagement
public class SrDeviceAutomationApplicationTests {

	@Resource
	private DevOnlineTaskMapper devOnlineTaskMapper;
	
	//@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void test(){
		/*List<DevOnlineTask> map = devOnlineTaskMapper.findPort(null);
		System.out.println(map.toString());
		Assert.assertEquals("", devOnlineTaskMapper.findPort(null));*/
	}

	
	public static int test1() {
		 int i = 1; 

		 //          if(i == 1) 
		 //              return 0; 
		 i = i / 0; 

		 try { 
		    System.out.println("try block"); 
		      return i; 
		 }finally { 
		     System.out.println("finally block"); 
		  } 
	} 
	
	
	public static void main(String[] args) {
		
		String s = StringUtil.readFile("D:\\port.txt");
		try {
			JSONObject obj = new JSONObject(s);
			JSONArray j = obj.getJSONArray("taskId");
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(j.toString(), String.class);
			
			String[] a = new String[l.size()];
			String[] taskId = l.toArray(a);
			System.out.println(taskId[0]);
			System.out.println(taskId[1]);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		List<String> l1 = new ArrayList<String>();
		l1.add("1");l1.add("2");
		List<String> l2 = new ArrayList<String>();
		l2.add("11");l2.add("22");
		l2.addAll(l1);
		System.out.println(l2.toString());
		
		/*String s = StringUtil.readFile("D:\\port.txt");
		try {
			JSONObject obj = new JSONObject(s);
			JSONObject result = obj.getJSONObject("result");
			System.out.println(result.toString());
			
			Object g = result.getJSONArray("99.1.65.105");
			System.out.println(g.toString());
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(g.toString(), String.class);
			System.out.println(l.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}*/
		
		String str = "<table border=\"1\" width=\"100%\" id=\"table1\" cellpadding=\"2\" style=\"border-collapse: collapse\" bordercolor=\"#C0C0C0\">    "
				+ "		<tr  >       "
				+ "			<td width=\"48\" height=\"22\" ><span style=\"font-size: 9pt\" >闯红灯设备</span></td>       "
				+ "			<td width=\"49\" align=\"center\" height=\"22\"><span style=\"font-size: 9pt\" >浙E1396G</span></td>        "
				+ "			<td width=\"79\" align=\"center\" height=\"22\"><span style=\"font-size: 9pt\" title=\"\" >机动车不按交通信号灯规定通行的</span></td>        "
				+ "			<td align=\"center\" width=\"38\" height=\"22\">        <span style=\"font-size: 9pt\">        ------        </span></td>        "
				+ "			<td width=\"71\" align=\"center\" height=\"22\"><span style=\"font-size: 9pt\">11/06/07 11:53</span></td>        "
				+ "			<td width=\"75\" height=\"22\" ><span style=\"font-size: 9pt\">二环西路西塞路</span></td>        "
				+ "			<td width=\"65\" ><span style=\"font-size: 9pt\">湖州市公安局交通警察支队</span></td>        "
				+ "			<td width=\"68\" style=\"font-size: 9pt\" align=\"center\" height=\"22\"><font color='#008000'>已处理</font>        </td>    "
				+ "		</tr>      "
				+ " </table>";

		//正则处理
		String eg = "<(span|font)[^>]*>(.*?)</\\1>";
		Matcher m = Pattern.compile(eg, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE).matcher(str);
		        while (m.find()) {
		        	String ss = m.group(2);
		            System.out.println(ss);
		        }

		
		
	}
	
	
}
