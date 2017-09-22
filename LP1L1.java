package cs6301.g18;

import java.util.LinkedList;

public class LP1L1 {
	
	
	//LinkedList<Integer> list = new LinkedList<Integer>();
		
		
		
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
			
//			public String toString(){
//				String res = list.toString();
//				return res;
//			}*/
			
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
	
		Num add(Num a, Num b){

			if(a.mark == 1 && b.mark == 1) {
				Num res = add(a, b);
				res.markadd = 1; 
				return res;
				
			}else if(a.mark == 0 && b.mark == 1) {
				return subtract(a, b);
			}else if(a.mark == 1 && b.mark == 0) {
				return subtract(b, a);
			}else {
				
			LinkedList<Integer> l = a.list;
			LinkedList<Integer> l1 = b.list;
			int carry = 0;
			int r = 0;
			
			Num result = new Num(0);
			LinkedList<Integer> res = result.list;
			
			int i=0;
			int j=0;
			
			while(i<l.size() && j<l1.size()){
				r = ((int)l.get(i) + (int)l1.get(j) + carry) % 10;
				res.add(r);
				carry = ((int)l.get(i) + (int)l1.get(j) + carry) / 10;
				i++;
				j++;
			}
			while(i>=l.size() && j<l1.size()){
				r = (l1.get(j) + carry) % 10;
				res.add(r);
				carry = (l1.get(j) + carry) / 10;
				j++;

			}
			while(j>=l1.size() && i<l.size()){
				r = (l.get(i) + carry) % 10;
				res.add(r);
				carry = (l.get(i) + carry) / 10;
				i++;
			}
			
			if(carry != 0){
				res.add(carry);
			}
			
			return result;
		}
			
		}
		/*
		
		Num product(Num a, Num b){
			
			Num result = new Num(0);
			if(a.list.size() == 1) {
				int carry = 0;
				for(int i = 0; i < b.list.size(); i++) {
					result.list.add((b.list.get(i) * a.list.get(0) + carry)%10);
					carry = (b.list.get(i) * a.list.get(0))/10;
				}
				if(carry != 0) {
					result.list.add(carry);
				}
				return result;
			}
			if(b.list.size() == 1) {
				int carry = 0;
				for(int i = 0; i < a.list.size(); i++) {
					result.list.add((a.list.get(i) * b.list.get(0) + carry)%10);
					carry = (a.list.get(i) * b.list.get(0))/10;
				}
				if(carry != 0) {
					result.list.add(carry);
				}
				return result;
			}
			
			int k = 0;
			if(a.list.size() < b.list.size()){
				k = a.list.size() / 2;
			}else{
				k = b.list.size() / 2;
			}
			Num al = new Num(0);
			Num ah = new Num(0);
			Num bl = new Num(0);
			Num bh = new Num(0);
			for(int i=0 ; i<k ; i++){
				al.list.add(a.list.get(i));
			}
			for(int i=0 ; i<k ; i++){
				bl.list.add(b.list.get(i));
			}
			for(int i=k ; i<a.list.size() ; i++){
				ah.list.add(b.list.get(i));
			}
			for(int i=k ; i<b.list.size() ; i++){
				bh.list.add(b.list.get(i));
			}
			Num result1 = product(ah,ah);
			Num result2 = subtract(subtract(product(add(al,ah), add(bl,bh)) , product(ah,bh)) , product(al,bl));
			Num result3 = product(al, bl);
			
			for(int i=0 ; i<2*k ; i++){
				result1.list.addFirst(0);
				
			}
			for(int i=0 ; i<k ; i++){
				result2.list.addFirst(0);
				
			}
			result =add( add(result1 , result2) , result3);
			return result;
		}*/

		
		Num power(Num x, long n){
			if(n == 0){
				Num zero = new Num(0);
				return zero;
			}
			if(n == 1){
				return  x;
			}
			else{
				Num s = power(x,  n/2);
				if(n % 2 == 0){
					return product(s,s);
				}
				else{
					return product(product(s,s),x);
				}
			}
		}
		
		
		
		
			
		
		
		Num divide(Num a, Num b){
			return a;
			
		}
		
		Num mod(Num a, Num b){
			return a;
		}
		
		Num squareRoot(Num a){
			return a;
		}
		
		Num product(Num a, Num b){
			
			Num result = new Num(0);
			if(a.list.size() == 1) {
				int carry = 0;
				for(int i = 0; i < b.list.size(); i++) {
					result.list.add((b.list.get(i) * a.list.get(0) + carry)%10);
					carry = (b.list.get(i) * a.list.get(0))/10;
				}
				if(carry != 0) {
					result.list.add(carry);
				}
				return result;
			}
			if(b.list.size() == 1) {
				int carry = 0;
				for(int i = 0; i < a.list.size(); i++) {
					result.list.add((a.list.get(i) * b.list.get(0) + carry)%10);
					carry = (a.list.get(i) * b.list.get(0))/10;
				}
				if(carry != 0) {
					result.list.add(carry);
				}
				return result;
			}
			
			int k = 0;
			if(a.list.size() < b.list.size()){
				k = a.list.size() / 2;
			}else{
				k = b.list.size() / 2;
			}
			Num al = new Num(0);
			Num ah = new Num(0);
			Num bl = new Num(0);
			Num bh = new Num(0);
			for(int i=0 ; i<k ; i++){
				al.list.add(a.list.get(i));
			}
			for(int i=0 ; i<k ; i++){
				bl.list.add(b.list.get(i));
			}
			for(int i=k ; i<a.list.size() ; i++){
				ah.list.add(b.list.get(i));
			}
			for(int i=k ; i<b.list.size() ; i++){
				bh.list.add(b.list.get(i));
			}
			Num result1 = product(ah,ah);
			Num result2 = subtract(subtract(product(add(al,ah), add(bl,bh)) , product(ah,bh)) , product(al,bl));
			Num result3 = product(al, bl);
			
			for(int i=0 ; i<2*k ; i++){
				result1.list.addFirst(0);
				
			}
			for(int i=0 ; i<k ; i++){
				result2.list.addFirst(0);
				
			}
			result =add( add(result1 , result2) , result3);
			return result;
		}
		
		Num subtract(Num a, Num b){
			
			if(a.mark == 1 && b.mark == 1) {
				return subtract(b, a);
				
			}else if(a.mark == 0 && b.mark == 1) {
				return add(a, b);
			}else if(a.mark == 1 && b.mark == 0) {
				Num res = add(a,b);
				res.marksubtra = 1;
				return res;
			}else {
			
			Num result = new Num(0);
			LinkedList<Integer> res = result.list;
			
		
			LinkedList<Integer> l = a.list;
			LinkedList<Integer> l1 = b.list;
			
			
			if(l.size()>l1.size()) {
				
				int carry = 0;
				int i=0;
				int j=0;
				int r=0;
				
				while(i<l.size() && j<l1.size()){
					if(l.get(i) >= l1.get(j)) {
						r = (int)l.get(i) - (int)l1.get(j) + carry;
						carry = 0;
					}else {
						r = 10 + (int)l.get(i) - (int)l1.get(j) + carry;
						carry = -1;
					}
					
					res.add(r);
					
					i++;
					j++;
				}
				
				
				while(j>=l1.size() && i<l.size()){
					r = l.get(i) + carry;
					res.add(r);
					carry = 0;
					i++;
				}
				
			}
			
			if(l.size()<l1.size()) {
				int carry = 0;
				int i=0;
				int j=0;
				int r=0;
				
				while(i<l.size() && j<l1.size()){
					if(l.get(i) >= l1.get(j)) {
						r = 10 + (int)l1.get(i) - (int)l.get(j) + carry;
						carry = -1;
					}else {
						r = (int)l1.get(i) - (int)l.get(j) + carry;
						carry = 0;
					}
					
					res.add(r);
					result.marksubtra = 1;
				
					i++;
					j++;
				}
				
				
				while(j<l1.size() && i>=l.size()){
					r = l1.get(i) + carry;
					res.add(r);
					carry = 0;
					j++;
				}
				
			}
			if(l.size()==l1.size()) {
				for(int m = l.size()-1; m>=0; m--) {
					if(l.get(l.size()-1)>=l1.get(l.size()-1)) {

						int carry = 0;
						int i=0;
						int j=0;
						int r=0;
						
						while(i<l.size() && j<l1.size()){
							if(l.get(i) >= l1.get(j)) {
								r = (int)l.get(i) - (int)l1.get(j) + carry;
								carry = 0;
							}else {
								r = 10 + (int)l.get(i) - (int)l1.get(j) + carry;
								carry = -1;
							}
							
							res.add(r);
							i++;
							j++;
						}
						
						
						while(j>=l1.size() && i<l.size()){
							r = l.get(i) + carry;
							res.add(r);
							carry = 0;
							i++;
						}
						
						return result;
					
					}else {

						int carry = 0;
						int i=0;
						int j=0;
						int r=0;
						
						while(i<l.size() && j<l1.size()){
							if(l.get(i) >= l1.get(j)) {
								r = (int)l1.get(i) - (int)l.get(j) + carry;
								carry = 0;
							}else {
								r = 10 + (int)l1.get(i) - (int)l.get(j) + carry;
								carry = -1;
							}
							
							res.add(r);
							i++;
							j++;
						}
						
						
						while(j<l1.size() && i>=l.size()){
							r = l1.get(i) + carry;
							res.add(r);
							carry = 0;
							j++;
						}
					}
				}
			}
			return result;
		}
		}
}
