package lp1.g18;

import java.util.LinkedList;

public class LP1L1 {
		
		int base = 10;
	
		public LP1L1(int base) {
			this.base = base;
		}
		
		public LP1L1() {
			
		}
	
		Num add(Num a, Num b){

			if(a.mark == 1 && b.mark == 1) {
				a.mark = 0;
				b.mark = 0;
				Num result = add(a, b);
				result.mark = 1; 
				return result;	
			}else if(a.mark != 1 && b.mark == 1) {
				b.mark = 0;
				return subtract(a, b);
			}else if(a.mark == 1 && b.mark != 1) {
				a.mark = 0;
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
				r = ((int)l.get(i) + (int)l1.get(j) + carry) % base;
				res.add(r);
				carry = ((int)l.get(i) + (int)l1.get(j) + carry) / base;
				i++;
				j++;
			}
			while(i>=l.size() && j<l1.size()){
				r = (l1.get(j) + carry) % base;
				res.add(r);
				carry = (l1.get(j) + carry) / base;
				j++;

			}
			while(j>=l1.size() && i<l.size()){
				r = (l.get(i) + carry) % base;
				res.add(r);
				carry = (l.get(i) + carry) / base;
				i++;
			}
			
			if(carry != 0){
				res.add(carry);
			}
			
			return result;
		}
			
		}

		
		Num subtract(Num a, Num b){
			
			if(a.mark == 1 && b.mark == 1) {
				a.mark = 0;
				b.mark = 0;
				Num result = subtract(b,a);
				return result;
			}else if(a.mark != 1 && b.mark == 1) {
				b.mark = 0;
				return add(a, b);
			}else if(a.mark == 1 && b.mark != 1) {
				a.mark = 0;
				Num result = add(a,b);
				result.mark = 1; 
				return result;
			}else {
				
			LinkedList<Integer> l = a.list;
			LinkedList<Integer> l1 = b.list;
			
			Num result = new Num(0);
			LinkedList<Integer> res = result.list;
			
			int carry = 0;
			int i=0;
			int j=0;
			int r=0;
			
			if(l.size()>l1.size()) {
				
				while(i<l.size() && j<l1.size()){
					if(l.get(i) >= l1.get(j)-carry) {
						r = (int)l.get(i) - (int)l1.get(j) + carry;
						carry = 0;
					}else {
						r = base + (int)l.get(i) - (int)l1.get(j) + carry;
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
				
				while(i<l.size() && j<l1.size()){
					if(l1.get(i) >= l.get(j) + carry) {
						r = (int)l1.get(i) - (int)l.get(j) + carry;
						carry = 0;
					}else {
						r = base + (int)l1.get(i) - (int)l.get(j) + carry;
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
				
				result.mark = 1;
			}
			
			if(l.size()==l1.size()) {
				for(int m = l.size()-1; m>=0; m--) {
					
					if(l.get(m)>l1.get(m)) {
						
						while(i<l.size() && j<l1.size()){
							if(l.get(i) >= l1.get(j)-carry) {
								r = (int)l.get(i) - (int)l1.get(j) + carry;
								carry = 0;
							}else {
								r = base + (int)l.get(i) - (int)l1.get(j) + carry;
								carry = -1;
							}
							
							res.add(r);
							
							i++;
							j++;
						}
						break;
						
					}else if(l.get(m) < l1.get(m)){
						while(i<l.size() && j<l1.size()){
							if(l1.get(i) >= l.get(j) + carry) {
								r = (int)l1.get(i) - (int)l.get(j) + carry;
								carry = 0;
							}else {
								r = base + (int)l1.get(i) - (int)l.get(j) + carry;
								carry = -1;
							}
							
							res.add(r);
							i++;
							j++;
						}
						
						result.mark = 1;
						break;
					}else {
						continue;
					}
				}
			}
			return result;
		}
	}


		Num product(Num a, Num b){
			
			Num result = new Num(0);
			//Num result = new Num(0);
//			char enda = a.toString().charAt(a.toString().length() - 1);
//			char endb = b.toString().charAt(b.toString().length() - 1);
//			if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
//				result.mark = 1;
//			}
			if(a.list.size() == 1) {
				int carry = 0;
				for(int i = 0; i < b.list.size(); i++) {
					result.list.add((b.list.get(i) * a.list.get(0) + carry)%base);
					carry = (b.list.get(i) * a.list.get(0))/base;
				}
				if(carry != 0) {
					result.list.add(carry);
				}
//				if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
//					result.mark = 1;
//				}
				return result;
			}
			if(b.list.size() == 1) {
				int carry = 0;
				for(int i = 0; i < a.list.size(); i++) {
					result.list.add((a.list.get(i) * b.list.get(0) + carry)%base);
					carry = (a.list.get(i) * b.list.get(0))/base;
				}
				if(carry != 0) {
					result.list.add(carry);
				}
//				if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
//					result.mark = 1;
//				}
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
				ah.list.add(a.list.get(i));
			}
			for(int i=k ; i<b.list.size() ; i++){
				bh.list.add(b.list.get(i));
			}
			Num result1 = product(ah,bh);
			Num result2 = subtract(subtract(product(add(al,ah), add(bl,bh)) , product(ah,bh)) , product(al,bl));
			Num result3 = product(al, bl);
			
			for(int i=0 ; i<2*k ; i++){
				result1.list.addFirst(0);
				
			}
			for(int i=0 ; i<k ; i++){
				result2.list.addFirst(0);
				
			}
			result =add( add(result1 , result2) , result3);
//			if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
//				result.mark = 1;
//			}
			return result;
		}
		
		
		
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
			
	
}
