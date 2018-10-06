package com.hisrun.utils;

import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang.StringUtils{

	/**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
	public static String autoGenericCode(String code, int num) {
        // 保留num的位数
        // 0 代表前面补充0     
        // num 代表长度为4     
        // d 代表参数为正数型 
        return String.format("%0" + num + "d", Integer.parseInt(code));
    }
	/**
	  * 判断是否为整数 
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/

	  public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	  }
	  
	  public static void main(String[] args) {
		
		  String aa = "s";
		  String bb = "11";
		  String cc = "";
		  System.out.println(isInteger(aa));
		  System.out.println(isInteger(bb));
		  System.out.println(isInteger(cc));
		  System.out.println(Integer.parseInt("0000200234"));

	}
	  
}
