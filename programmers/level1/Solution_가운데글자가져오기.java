package com.programmers;

public class Solution_가운데글자가져오기 {
	public static void main(String[] args) {
		String s = "abcd";
		solution(s);
	}
	  public static String solution(String s) {
	       
	        int m =s.length()/2;
	        char ch = ' ';
	        StringBuffer sb = new StringBuffer();
	        if(s.length()%2==1) {
	        	ch= s.charAt(m);
	        	sb.append(ch);
	        }
	        else {
	        	ch = s.charAt(m-1);
	        	sb.append(ch);
	        	ch = s.charAt(m);
	        	sb.append(ch);
	        }
	       // System.out.println(sb);
	        return sb.toString();
	    }
}
