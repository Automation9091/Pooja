package com.sis.qa.pages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class duplicate_in_array {
	public static void main(String[] args){
		
		 String names[] = {"Java","JavaScript","C","Selenium","ETL","Java","ETL"};
		 
		 //HashSet contains no duplicate
		 Set<String> store = new HashSet<String>();
		 for(String name : names){
			 if(store.add(name)== false){
				 System.out.println("Duplicate number is "+name);
			 }
		 }
		  
		 System.out.println("------------");
		
	//using HashMap
	//HashMap contains values for key appearance
	
	Map<String,Integer> storemap = new HashMap<String, Integer>();
	for(String name : names){
		Integer count = storemap.get(name);             //first time value is null
		if(count == null){                   
			storemap.put(name, 1);
			}
		else{
			storemap.put(name, ++count);
		}
	}
	
	//get values for HashMap
	Set<Entry<String,Integer>> entryset = storemap.entrySet();
	for(Entry<String, Integer> entry : entryset){
		if(entry.getValue()>1){
			System.out.println("duplicate element is "+ entry.getKey());
		}
	}
	
	
	
	
	
	
	}
}
