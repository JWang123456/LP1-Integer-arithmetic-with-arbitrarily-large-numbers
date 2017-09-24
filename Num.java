package lp1.g18;

import java.util.LinkedList;

class Num {
	int base = 10;
	int mark = 0;
	
	LinkedList<Integer> list = new LinkedList<Integer>();

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
			
			while(number%base >= 0) {
				list.add(number % base);
				number = number/base;
				if(number == 0) break;
			}
			
			}else{
			String s1 = s.substring(1);
			Integer number = Integer.valueOf(s1);
			while(number%base >= 0){
				list.add(number % base);
				number = number/base;
				if(number == 0) break;
			}
		
			
			
			this.mark = 1;  // This means the number is negative;
		}
	}
	
//	Num(long x){
//		
//		if(x>=0) {
//			while(x%base >= 0){
//				list.add((int)x % base);
//				x = x/base;
//				if(x == 0) break;
//			}
//		}else{
//			x = -x;
//			while(x%base >= 0){
//				list.add((int)x % base);
//				x = x/base;
//				if(x == 0) break;
//			}
//			this.mark = 1;  // This means the number is negative;
//		}
//	}
	
Num(long x){
		
		if(x>=0) {
			while(x%10 >= 0){
				list.add((int)x % 10);
				x = x/10;
				if(x == 0) break;
			}
		}else{
			x = -x;
			while(x%10 >= 0){
				list.add((int)x % 10);
				x = x/10;
				if(x == 0) break;
			}
			this.mark = 1;  // This means the number is negative;
		}
	}
	
	Num(String s, int base){
		this.base = base;
		if(!negative(s)) {
		Integer number = Integer.valueOf(s);
		while(number%base >= 0){
		list.add(number % base);
		number = number/base;
		if(number == 0) break;
		}
		}else {
		String s1 = s.substring(1);
		Integer number = Integer.valueOf(s1);
		while(number%base >= 0){
		list.add(number % base);
		number = number/base;
		if(number == 0) break;
		}
		this.mark = 1;  // This means the number is negative;
		}
		}
	
		Num(long x, int base){
		this.base = base;
		if(x>=0) {
		while(x%base >= 0){
		list.add((int)x % base);
		x = x/base;
		if(x == 0) break;
		}
		}else{
		x = -x;
		while(x%base >= 0){
		list.add((int)x % base);
		x = x/base;
		if(x == 0) break;
		}
		this.mark = 1;  // This means the number is negative;
		}
		}

	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		if(this.mark == 1) {  //not sure about this
			
			for(Integer i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if(i < list.size() - 1) sb.append("-->");
			}
			sb.append("-");	
		}else {
			for(Integer i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				if(i < list.size() - 1) sb.append("-->");
			}
		}
		return sb.toString();				
	}
	
	public void printList(){
		System.out.print(base + " : " );
		for(int i = 0;i < list.size();i ++){
			System.out.print(list.get(i) + " ");
		}
		System.out.print("\n");
	}
}
