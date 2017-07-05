package com.sunrun.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.StringUtils;

public final class StringUtil {
	private static final Logger log = Logger.getLogger(StringUtil.class);
	
	public static void main(String[] args) {
		/*List<Object> list = new ArrayList<Object>();
		Map map = new HashMap();
		map.put("mip", "99.1.34.248");
		map.put("STATE", "1");
		map.put("CREATE_TIME", 1478487556000l);
		map.put("start_date", 1);
		Map map1 = new HashMap();
		map1.put("mip", "99.1.34.241");
		map1.put("STATE", "0");
		map1.put("CREATE_TIME_TE", 1238487556022l);
		map1.put("start_date", 1);
		list.add(map1);
		list.add(map);
		
		System.out.println(list.toString());
		List<Object> l = filedConvert(list);
		System.out.println(l.toString());*/
		List<String> ls = new ArrayList<String>();
		ls.add("11111");
		ls.add("2222");
		System.out.println(ls.toString());
		
		System.out.println(emailHeadStr()); 
		String d = "E_TITMT";
		System.out.println(filedConvertProperty(d));
		
		byte[] b = ("01034090:").getBytes();
		System.out.println("Basic " + Base64Util.base64Encode(b));
		
	}
	
	/**
	 * 将数据库中字段改为实体类属性（如：start_date-->startDate）
	 * @param list
	 * @return
	 */
	public static List<Object> filedConvert(List list){
		List<Object> l = new ArrayList<Object>();
		for(int i=0;i<list.size();i++){
			Map mm = new HashMap();
			Map m = (Map) list.get(i);
			Set set = m.keySet();
			Iterator<String> ite = set.iterator();
	        while(ite.hasNext()){
	           String s1 = ite.next();
	           Object value = m.get(s1);
	           String key = "";
	           if(s1.toLowerCase().indexOf("_")!=-1){
	        	   String[] ss = s1.toLowerCase().split("_");
	        	   String s = "";
	        	   for(int j=0;j<ss.length;j++){
	        		   if(j==0){
	        			   s += ss[j];
	        		   }else{
	        			   String head = ss[j].substring(0, 1).toUpperCase();
	        			   String other = ss[j].substring(1);
	        			   s += head + other;
	        		   }
	        	   }
	        	   key = s;
	           }else{
	        	   key = s1.toLowerCase();
	           }
	           mm.put(key, value);
	        } 
	        l.add(mm);
		}
		return l;
	}
	
	/**
	 * 将一些字段转换成采用驼峰命名法的格式（如：start_date-->startDate）
	 * @param filed
	 * @return
	 */
	public static String filedConvertProperty(String filed){
		String property = "";
		if(!StringUtils.isEmpty(filed)){
			if(filed.toLowerCase().indexOf("_")!=-1){
				 String[] ss = filed.toLowerCase().split("_");
	        	   String s = "";
	        	   for(int j=0;j<ss.length;j++){
	        		   if(j==0){
	        			   s += ss[j];
	        		   }else{
	        			   String head = ss[j].substring(0, 1).toUpperCase();
	        			   String other = ss[j].substring(1);
	        			   s += head + other;
	        		   }
	        	   }
	        	   property = s;
			} else{
				property = filed.toLowerCase();
	        }
		}
		return property;
	}
	
	
	/**
	 * 将mybatis默认为空的键值对填充返回
	 * @param list	查询数据库返回的键值对map集合（mybatis查询map,当值为空时候默认不返回该对键值对）
	 * @param propertys	完整的表字段map键值对
	 */
	public static void showNullProperty(List<Object> list, List<String> propertys){
		for(int i=0;i<list.size();i++){
			Map m = (Map)list.get(i);
			Map lm = (Map)list.get(i)==null ? new HashMap() : (Map)list.get(i);
			m = lm;
			if(m!=null){
				Set set = m.keySet();
	        	for(int j=0;j<propertys.size();j++){
	        		String key = propertys.get(j);
	        		if(!set.contains(key) || (set.contains(key) && (m.get(key)==null || m.get(key).equals("")))){
	        			lm.put(key, "");
	        		}
	        	}
			}else{
				for(int j=0;j<propertys.size();j++){
					String key = propertys.get(j);
					lm.put(key, "");
				}
			}
		}
	}
	
	/**
	 * 随机生成32位UUID字符串
	 */
	public static String getUuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	/**
	 *  判断一个字符串是否含有数字 add by ymg
	 * @param content
	 * @return
	 */
		public static boolean hasDigit(String content) {
			boolean flag = false;
			Pattern p = Pattern.compile(".*\\d+.*");
			Matcher m = p.matcher(content);
			if (m.matches())
				flag = true;
			return flag;
		}
		
		/**
		 * 截取数字   add by ymg
		 * @param content
		 * @return
		 */
		public static String getNumbers(String content) {  
		    Pattern pattern = Pattern.compile("\\d+");  
		    Matcher matcher = pattern.matcher(content);  
		    while (matcher.find()) {  
		       return matcher.group(0);  
		    }  
		    return "";  
		}
		
		/**
		 * 截取非数字  
		 * @param content
		 * @return
		 */
		public static String splitNotNumber(String content) {  
		    Pattern pattern = Pattern.compile("\\D+");  
		    Matcher matcher = pattern.matcher(content);  
		    while (matcher.find()) {  
		        return matcher.group(0);  
		    }  
		    return "";  
		} 
		
		/**
		 * 	 冒泡排序
		 * @param a
		 * @return
		 */
		public static int[] sort(int a[]){
	        for (int k = 0; k < a.length - 1; k++) {
	            for (int j = k + 1; j < a.length; j++) { // 升序把<改成>
	                if (a[k] > a[j]) {
	                    int temp = a[k];
	                    a[k] = a[j];
	                    a[j] = temp;
	                }
	            }
	        }
			return a;
		}
		
		/**
		 * 读取文件
		 * @param fileName
		 * @return
		 */
		public static String readFile(String fileName){
			File file = new File(fileName);
			BufferedReader reader = null;
			StringBuffer sb = new StringBuffer();
			
			InputStream is = null;
	        Reader fr = null;
			try {
				
				is = new FileInputStream(file);
				fr = new InputStreamReader(is, "UTF-8");
				reader = new BufferedReader(fr);
				
				//reader = new BufferedReader(new FileReader(file));
				String tempString = null;
				while((tempString = reader.readLine()) != null){
						sb.append(tempString);
				}
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(reader!=null){
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return sb.toString();
		}
		
		/**
		 * 读取文件(带格式的)
		 * @param file
		 * @return
		 */
		public static String read(String file){
			String s = null;
			try {
	            FileReader fileReader = new FileReader(file);
	            Reader reader = new InputStreamReader(new FileInputStream(file), fileReader.getEncoding());
	            int ch = 0;
	            StringBuffer sb = new StringBuffer();
	            while ((ch = reader.read()) != -1) {
	                sb.append((char) ch);
	            }
	            fileReader.close();
	            reader.close();
	            s = sb.toString();
	           // System.out.println("文件的内容是：\n" + s);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return s;
		}
		
		/**
		 * 返回下次 task数据上报时间
		 * @param reporttime task数据上报时间
		 * @param interval 间隔
		 * @return
		 */
		public static  Date getTaskReporttime(java.util.Date reporttime,String interval ) {
			Integer interval_m=getInterval(interval); 
			if(interval_m!=null && reporttime!=null){
				java.util.Calendar cal=java.util.Calendar.getInstance();  
				cal.setTime(reporttime);    
				cal.add(Calendar.MINUTE, interval_m); 
				return cal.getTime();
			}else{
				return null;
			}
			
		}
		
		/**
		 * 解析 时间间隔,换算后 以分钟返回。
		 * @param interval 间隔 
		 * //	时间时隔单位。M,H,D,W,M,HY,Y  默认为分钟 ( 填写数字时 ,不能填写类似数字在字母的方式，如： 3D) ：M: 分钟 H: 小时 D: 天 W: 周 M: 月 HY: 半年 Y: 年	
		 * @return
		 */
		public  static Integer    getInterval( String interval ) {
			Integer interval_m=null;
			 
			 //分钟
			if(interval.contains("M")||interval.contains("m")){ 
			 
				interval_m=  isInteger(interval.substring(0,interval.toUpperCase().indexOf("M")))?Integer.parseInt(interval.substring(0,interval.toUpperCase().indexOf("M"))):null;
				
			}else  if (interval.contains("H")||(interval.contains("h"))){
				interval_m=  isInteger(interval.substring(0,interval.toUpperCase().indexOf("H")))?Integer.parseInt(interval.substring(0,interval.toUpperCase().indexOf("H")))*60:null;
					
			} else if (interval.contains("D")||(interval.contains("d"))){
				interval_m=  isInteger(interval.substring(0,interval.toUpperCase().indexOf("D")))?Integer.parseInt(interval.substring(0,interval.toUpperCase().indexOf("D")))*24*60:null;
					
			}else{
				interval_m=null;
			}
				
			return interval_m;
		}
		
		/* 
		  * 判断是否为整数  
		  * @param str 传入的字符串  
		  * @return 是整数返回true,否则返回false  
		*/  
		  public static boolean isInteger(String str) {    
		    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		    boolean  return_value=false;
		    if(str!=null && !"".equals(str)){
		    	return_value= pattern.matcher(str).matches(); 
		    }
		    return return_value;
		       
		  }  
		  
		  /**
		   * 按照给500的长度，对给定的txt字符串进行分段切割
		   * @param txt 被切割的目标字符串
		   * @return
		   */
		  public static List<String> inciseTxt(StringBuffer txt){
			  List<String> list=new ArrayList<String>();
			  int length=500;
				  for(int start=0;start<txt.length();){
					  if(start+length<=txt.length()){
						  list.add(txt.substring(start,start+length));
						  start=start+length;
					  }else{
						  list.add(txt.substring(start, txt.length()));
						  return list;
					  }
				  }
			  return list;
		  }

		  	/**
			 * 返回base64加密后的用户名字和密码
			 * @param username
			 * @param pwd
			 * @return
			 */
			public static String basic64Encord(String username, String pwd){
				byte[] b = (username + ":" + pwd).getBytes();
				return "Basic " + Base64Util.base64Encode(b);
			}

		/**
		 * 交换机发送邮件通知头部格式信息
		 * @return
		 */
		 public static String emailHeadStr(){
			 StringBuffer sb = new StringBuffer();
			 sb.append("<div><table border='0' cellpadding='5' cellspacing='0' width='1500' style='border:1px solid #ededed;border-collapse:collapse;width:1070pt;text-align:center'>");
			 sb.append("<colgroup><col width='85' style='mso-width-source:userset;mso-width-alt:2720;width:64pt'>");
			 sb.append("<col width='72' style='width:54pt'>");
			 sb.append("<col width='125' style='mso-width-source:userset;mso-width-alt:4000;width:94pt'>");
			 sb.append("<col width='165' span='3' style='mso-width-source:userset;mso-width-alt:5280;width:124pt'>");
			 sb.append("<col width='244' style='mso-width-source:userset;mso-width-alt:7808;width:183pt'>");
			 sb.append("<col width='165' style='mso-width-source:userset;mso-width-alt:5280;width:124pt'>");
			 sb.append("<col width='238' style='mso-width-source:userset;mso-width-alt:7616;width:179pt'>");
			 sb.append("</colgroup><tbody><tr height='80' style='mso-height-source:userset;height:25.0pt'>");
			 sb.append("<th height='80' class='xl65' width='85' style='border:1px solid #ededed;height:25.0pt;width:64pt'>设备品牌</th>");
			 sb.append("<th class='xl65' width='72' style='border:1px solid #ededed;width:54pt'>型号</th>");
			 sb.append("<th class='xl65' width='125' style='border:1px solid #ededed;width:94pt'>区域</th>");
			 sb.append("<th class='xl65' width='165' style='border:1px solid #ededed;width:124pt'>主汇聚交机:端口</th>");
			 sb.append("<th class='xl65' width='165' style='border:1px solid #ededed;width:124pt'>备汇聚交机:端口</th>");
			 sb.append("<th class='xl65' width='165' style='border:1px solid #ededed;width:124pt'>上线机架位置</th>");
			 sb.append("<th class='xl65' width='244' style='border:1px solid #ededed;width:183pt'>hostname</th>");
			 sb.append("<th class='xl65' width='165' style='border:1px solid #ededed;width:124pt'>管理地址</th>");
			 sb.append("<th class='xl65' width='165' style='border:1px solid #ededed;width:124pt'>接入交换机连接主汇聚端口</th>");
			 sb.append("<th class='xl65' width='165' style='border:1px solid #ededed;width:124pt'>接入交换机连接备汇聚端口</th>");
			 sb.append("<th class='xl65' width='238' style='border:1px solid #ededed;width:179pt'>带外交换机信息</th></tr>");
			return sb.toString();
		 }
	
}
