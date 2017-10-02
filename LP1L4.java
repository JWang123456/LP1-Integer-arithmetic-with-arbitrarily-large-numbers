package lp1.g18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LP1L4 {

	static HashMap<Character, Num> map = new HashMap<>();
	static TreeMap<Integer, String> line = new TreeMap<>();
	
	static Num last = new Num(0);
	static LP1L1 lp1l1 = new LP1L1();
	//static LP1L2 lp1l2 = new LP1L2();
	
	static void stringProcess(String str) {
		
		int idx = str.indexOf('=');
    	if(str.charAt(0) == ';') {
    		last.printList();
    	} else if(Character.isDigit(str.charAt(idx + 2))) {
    		String output = str.substring(idx + 2, str.length() - 2);
    		map.put(str.charAt(0), new Num(output));
    		System.out.println(output);
    	} else if(!str.contains("?")) {
    		int lineno = Integer.parseInt(str.substring(0, idx - 1));
    		line.put(new Integer(lineno), str);
    		Num res = new Num(0);
    		if(str.charAt(idx + 4) == '^') {
    			res = lp1l2.power(map.get(str.charAt(idx + 2)), map.get(str.charAt(idx + 6)));
    		} else if(str.charAt(idx + 4) == '+') {
    			res = lp1l1.add(map.get(str.charAt(idx + 2)), map.get(str.charAt(idx + 6)));
    		}
    		map.put(str.charAt(0), res);
    		StringBuilder sb = new StringBuilder();
    		for(Integer i: res.list) {
    			sb.append(i.toString());
    		}
    		last = res;
    		System.out.println(sb.reverse().toString());
    	} else {
    		int lineno = Integer.parseInt(str.substring(0, idx - 1));
    		int qes = str.indexOf('?');
    		Num num = map.get(str.charAt(qes - 2));
    		if(num.equals(new Num(0))) {
    			return;
    		} else {
    			String li = line.get(lineno);
    			stringProcess(li);
    		}
    	}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new File("input.in"));
	    while(in.hasNext()) {
	    	String str = in.nextLine();
	    	stringProcess(str);
	    }
		
	}
}
