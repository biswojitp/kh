package com.kh.kitchenhome;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8 {
	public static void main(String[] args) {
	/*    System.out.println("Stream without terminal operation");
	     
	    Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
	        System.out.println("without todoubling " + i);
	        return i * 2;
	    });
	  
	    System.out.println("Stream with terminal operation");
	       int sum =  Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
	            System.out.println("with to doubling " + i);
	            return i * 2;
	    }).sum();
	       
	       System.out.println(sum+" sum");*/
		
		
		Set<String> strSet1 =null;
				
				Stream.of("A", "B", "C", "D")
		         .collect(Collectors.toCollection(HashSet::new));
		System.out.println(strSet1.size());

//		// stream from an array (String[] stringArray)
//		Set<String> strSet2 = Arrays.stream(stringArray)
//		         .collect(Collectors.toCollection(HashSet::new));
//
//		// stream from a list (List<String> stringList)
//		Set<String> strSet3 = stringList.stream()
//		         .collect(Collectors.toCollection(HashSet::new));
	}
}
