package cs6301.g18;

import java.util.LinkedList;

class Num {
	int base = 10;
	int mark = 0;
	int markadd = 0;
	int marksubtra = 0;
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	/*Num(String s){
		Integer number = Integer.valueOf(s);
		while(number%base > 0){
			list.add(number % base);
			number = number/base;
		}
	}
	
	Num(long x){
		while(x%base > 0){
			list.add((int)x % base);
			x = x / base;
		}
	}
	
//	public String toString(){
//		String res = list.toString();
//		return res;
//	}*/
	
	boolean negative(String s) {
		if( s.charAt(0) != '-') {
			return false;
		}else {
			return true;
		}
	}
	
	Num(String s){
		
		if(!negative(s)) {
			Integer number = Integer.valueOf(s);
			while(number%base > 0){
				list.add(number % base);
				number = number/base;
			}
		}else {
			String s1 = s.substring(1);
			Integer number = Integer.valueOf(s1);
			while(number%base > 0){
				list.add(number % base);
				number = number/base;
				
			}
			mark = 1;
		}
	}
	
	Num(long x){
		
		if(x>=0) {
			while(x%base > 0){
				list.add((int)x % base);
				x = x/base;
			}
		}else{
			x = -x;
			while(x%base > 0){
				list.add((int)x % base);
				x = x/base;
			}
			mark = 1;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Integer i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if(i < list.size() - 1) sb.append("-->");
		}
		//String res = this.list.toString();
		if(markadd == 1 || marksubtra == 1) {
			sb.append("-");
			
		}
		return sb.toString();
		//return res;
		
	}
	public void printList(){
		System.out.print(base + " : " );
		for(int i = 0;i < list.size();i ++){
			System.out.print(list.get(i) + " ");
		}
		System.out.print("\n");
	}
	
}
