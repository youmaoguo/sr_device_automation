package com.sunrun;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunrun.util.StringUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		String s = StringUtil.read("D:\\port.txt");
		try {
			//s = new String(s.getBytes("gbk"),"utf-8");
			org.json.JSONObject obj = new org.json.JSONObject(s);
			Object str = obj.get("data");
			System.out.println(str.toString()); 
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(str.toString(), String.class);
			System.out.println(l.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
