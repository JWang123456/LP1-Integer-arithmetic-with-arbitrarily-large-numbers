package cs6301.g18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class LP1L3 {
	
	static HashMap<Character, Num> map = new HashMap<>();
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		Num last = new Num(0);
		LP1L1 lp1l1 = new LP1L1();
		LP1L2 lp1l2 = new LP1L2();
	    Scanner in = new Scanner(new File("input.in"));
	    while(in.hasNext()) {
	    	String str = in.nextLine();
	    	if(str.charAt(0) == ';') {
	    		last.printList();
	    		break;
	    	} else if(Character.isDigit(str.charAt(4))) {
	    		String output = str.substring(4, str.length() - 2);
	    		map.put(str.charAt(0), new Num(output));
	    		System.out.println(output);
	    	} else {
	    		Num res = new Num(0);
	    		if(str.charAt(8) == '^') {
	    			res = lp1l2.power(map.get(str.charAt(4)), map.get(str.charAt(6)));
	    		} else if(str.charAt(8) == '+') {
	    			res = lp1l1.add(map.get(str.charAt(4)), map.get(str.charAt(6)));
	    		}
	    		map.put(str.charAt(0), res);
	    		StringBuilder sb = new StringBuilder();
	    		for(Integer i: res.list) {
	    			sb.append(i.toString());
	    		}
	    		last = res;
	    		System.out.println(sb.reverse().toString());
	    	}
	    	
	    }
		
	}
}
