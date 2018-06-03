package com.sunrun.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class StringUtil {
	
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("11111");
		ls.add("2222");
		ls.add("2222");
		System.out.println(ls.toString());
		
		Set<String> set = new HashSet<String>(ls);
		ls.clear();
		ls.addAll(set);
		System.out.println(ls.toString());
		
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
			 * 返回base64加密后的用户名字和密码
			 * @param username
			 * @param pwd
			 * @return
			 */
			public static String basic64Encord(String username, String pwd){
				byte[] b = (username + ":" + pwd).getBytes();
				return "Basic " + Base64Util.base64Encode(b);
			}

		
 
 
}
