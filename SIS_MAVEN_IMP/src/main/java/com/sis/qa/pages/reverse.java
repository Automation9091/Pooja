package com.sis.qa.pages;

public class reverse {
	
	public static void main(String[] args){
		
			String input="Anuradha";
			String reverse="";
			char[] revinput = input.toCharArray();
			
			int lengthofString = input.length();
			System.out.println(lengthofString);
			
			
			for(int i=lengthofString-1;i>=0;i--){
				reverse = reverse +input.charAt(i);
			}

			System.out.println("Reverse of "+input+" is "+reverse);
}
	
	
}
