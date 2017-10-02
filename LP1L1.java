package lp1.g18;

import java.util.LinkedList;

public class LP1L1 {
	
		Num add(Num a, Num b){
			
			int base = a.getBase();
			Num result = new Num();
			result.setBase(base);
			
			if(a.mark == 1 && b.mark == 1) {
				a.mark = 0;
				b.mark = 0;
				result = add(a, b);
				result.mark = 1; 
				return result;	
			}else if(a.mark != 1 && b.mark == 1) {
				b.mark = 0;
				result = subtract(a, b);
				return result;
			}else if(a.mark == 1 && b.mark != 1) {
				a.mark = 0;
				result = subtract(b, a);
				return result;
			}else {
	
			LinkedList<Integer> l = a.list;
			LinkedList<Integer> l1 = b.list;
			int carry = 0;
			int r = 0;
		
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
			
			int base = a.getBase();
			Num result = new Num();
			result.setBase(base);
			
			if(a.mark == 1 && b.mark == 1) {
				a.mark = 0;
				b.mark = 0;
				result = subtract(b,a);
				return result;
			}else if(a.mark != 1 && b.mark == 1) {
				b.mark = 0;
				result = add(a, b);
				return result;
			}else if(a.mark == 1 && b.mark != 1) {
				a.mark = 0;
				result = add(a,b);
				result.mark = 1; 
				return result;
			}else {
				
			LinkedList<Integer> l = a.list;
			LinkedList<Integer> l1 = b.list;
			
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
			
			int base = a.getBase();
			
			Num result = new Num();
			result.setBase(base);
			
			char enda = a.toString().charAt(a.toString().length() - 1);
			char endb = b.toString().charAt(b.toString().length() - 1);
			
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
			
			Num al = new Num();
			al.setBase(base);
			Num ah = new Num();
			ah.setBase(base);
			Num bl = new Num();
			bl.setBase(base);
			Num bh = new Num();
			bh.setBase(base);
			
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
			Num result1 = new Num(); 
			result1 =product(ah,bh);
			Num result2 = new Num();
			result2 = subtract(subtract(product(add(al,ah), add(bl,bh)) , product(ah,bh)) , product(al,bl));
			Num result3 = new Num();
			result3 = product(al, bl);
			
			for(int i=0 ; i<2*k ; i++){
				result1.list.addFirst(0);
				
			}
			for(int i=0 ; i<k ; i++){
				result2.list.addFirst(0);
				
			}
			result =add( add(result1 , result2) , result3);
			if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
				result.mark = 1;
			}
			return result;
		}
		
		
		Num power(Num x, long n){
			
			int base = x.getBase();
		
			if(n == 0){
				Num one = new Num(1);
				one.setBase(base);
				return one;
			}
			if(n == 1){
				return  x;
			}
			else{
				Num s = new Num();
				s.setBase(base);
				s = power(x,  n/2);
				if(n % 2 == 0){
					return product(s,s);
				}
				else{
					return product(product(s,s),x);
				}
			}
		}
		
	
		Num power(Num x, Num n) {
			int base = x.getBase();
			if(n.toString().equals("0")){
				Num one = new Num(1);
				one.setBase(base);
				return one;
			}
			if(n.toString().equals("1")){
				return  x;
			}
			else{
				Num s = new Num();
				s.setBase(base);
				s = power(x, divide(n, new Num(2)));
				
				if(mod(n, new Num(2)).equals(new Num(0))){
					return product(s, s);
				}
				else{
					return product(product(s, s), x);
				}
			}
		}
		
		int compare(Num a, Num b) {
			
			
			
			LinkedList<Integer> l = a.list;
			LinkedList<Integer> l1 = b.list;
		
			if(l.size()>l1.size()) {
				return 1;
			}else if(l.size()<l1.size()) {
				return -1;
			}else{
				for(int m = l.size()-1; m>=0; m--) {
					if(l.get(m)>l1.get(m)) {
						return 1;
					}else if(l.get(m) < l1.get(m)){
						return -1;
					}else {
						continue;
					}
				}
				return 0;
			}
		}

		
		Num divide(Num a, Num b){
			
			Num result = new Num();
			result.setBase(2);
			
			char enda = a.toString().charAt(a.toString().length() - 1);
			char endb = b.toString().charAt(b.toString().length() - 1);
			
			a.setBase(2);
			b.setBase(2);
			
			Num one = new Num(1);
			one.setBase(2);
			Num mid = new Num(0);
			mid.setBase(2);
			Num front = new Num(0);
			mid.setBase(2);
			Num end = new Num(0);
			mid.setBase(2);
			front = one;
			end = a;
			
			
//			public static boolean iterativeBinarySearch(int[] A, int p, int r, int x) {
//				while(p <= r) {
//					int q = (p+r)/2;
//					if(A[q] < x) {  // A[q] is too small, x is not in left half
//						p = q+1;
//					} else if (A[q] == x) {  // x found
//						return true;
//					} else { // A[q] > x, so x is not in the right half
//						r = q-1;
//					}
//				}
//					// x not found, return false
//					return false;
//				    }
			if(compare(a,b) == -1) {
				Num zero = new Num(0);
				zero.setBase(2);
				result = zero;
				return result;
			}
			
			while(compare(front,end) <= 0) {
				mid = add(front, end);
				mid.list.pollFirst();
				
			    if(compare(product(mid,b),a) == 0) {
			        result = mid;
			    	break;
			    }else if(compare(product(mid,b),a) == 1) { //mid too big, result in left half
			    	if(compare(product(subtract(mid,one),b),a) <= 0) {
			    		result = subtract(mid,one);
			    		break;
			    	}else {
			    		end = subtract(mid,one);
			    	
			    	}
			    }else{ //mid too small, result in right half
			    	if(compare(product(add(mid,one),b),a) > 0) {
			    		result = mid;
			    		break;
			    	}else if(compare(product(add(mid,one),b),a) == 0){
			    		result = add(mid,one);
			    		break;
			    	}else{
			    		front = add(mid, one);
			    	}
			    }
			}
		
			if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
				result.mark = 1;
			}
			 
			return result;
			
		}
		
			
//          Num divide(Num a, Num b){
//			
//			Num result = new Num();
//			result.setBase(2);
//			
//			char enda = a.toString().charAt(a.toString().length() - 1);
//			char endb = b.toString().charAt(b.toString().length() - 1);
//			
//			a.setBase(2);
//			b.setBase(2);
//			
//			Num one = new Num(1);
//			one.setBase(2);
//			Num mid = new Num(0);
//			mid.setBase(2);
//			Num front = new Num(0);
//			mid.setBase(2);
//			Num end = new Num(0);
//			mid.setBase(2);
//			front = one;
//			end = a;
//			
//			mid = add(front, end);
//			mid.list.pollFirst();
//			
//			while(compare(mid, end) < 0 && compare(mid, front) >= 0) {
//			   // mid.list.pollFirst();
//			        
//			    if(compare(product(mid,b),a) == 0) {
//			        result = mid;
//			    	break;
//			    }else if(compare(product(mid,b),a) == 1) {
//			    	if(compare(product(subtract(mid,one),b),a) <= 0) {
//			    		result = subtract(mid,one);
//			    		break;
//			    	}else {
//			    		end = mid;
//			    		mid = add(end, front);
//			    		mid.list.pollFirst();
//			    		continue;
//			    	}
//			    }else{
//			    	if(compare(product(add(mid,one),b),a) >= 0) {
//			    		result = mid;
//			    		break;
//			    	}else {
//			    		one = mid;
//			    		mid = add(a, mid);
//			    		mid.list.pollFirst();
//			    		continue;
//			    	}
//			    }
//			}
//		
//			if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
//				result.mark = 1;
//			}
//			 
//			return result;
//			
//		}
			
		
		
		Num mod(Num a, Num b){
			Num result = new Num();
			result.setBase(2);
			
			char enda = a.toString().charAt(a.toString().length() - 1);
			char endb = b.toString().charAt(b.toString().length() - 1);
			
			a.setBase(2);
			b.setBase(2);
			
			result = subtract(a,product(divide(a,b),b));
			
			
			if((enda == '-' || endb == '-') && !(enda == '-' && endb == '-')) {
				result.mark = 1;
			}
			 
			return result;
			
		}
		
		
		Num squareRoot(Num a){
				
			char enda = a.toString().charAt(a.toString().length() - 1);
			
			if(enda == '-' ) {
				return null;
			}
				
			Num result = new Num();	
			result.setBase(2);
				
				a.setBase(2);
				
				Num one = new Num(1);
				one.setBase(2);
				Num mid = new Num(0);
				mid.setBase(2);
				Num front = new Num(0);
				mid.setBase(2);
				Num end = new Num(0);
				mid.setBase(2);
				front = one;
				end = a;
				
				
//				public static boolean iterativeBinarySearch(int[] A, int p, int r, int x) {
//					while(p <= r) {
//						int q = (p+r)/2;
//						if(A[q] < x) {  // A[q] is too small, x is not in left half
//							p = q+1;
//						} else if (A[q] == x) {  // x found
//							return true;
//						} else { // A[q] > x, so x is not in the right half
//							r = q-1;
//						}
//					}
//						// x not found, return false
//						return false;
//					    }
				if(compare(a,b) == -1) {
					Num zero = new Num(0);
					zero.setBase(2);
					result = zero;
					return result;
				}
				
				while(compare(front,end) <= 0) {
					mid = add(front, end);
					mid.list.pollFirst();
					
				    if(compare(product(mid,b),a) == 0) {
				        result = mid;
				    	break;
				    }else if(compare(product(mid,b),a) == 1) { //mid too big, result in left half
				    	if(compare(product(subtract(mid,one),b),a) <= 0) {
				    		result = subtract(mid,one);
				    		break;
				    	}else {
				    		end = subtract(mid,one);
				    	
				    	}
				    }else{ //mid too small, result in right half
				    	if(compare(product(add(mid,one),b),a) > 0) {
				    		result = mid;
				    		break;
				    	}else if(compare(product(add(mid,one),b),a) == 0){
				    		result = add(mid,one);
				    		break;
				    	}else{
				    		front = add(mid, one);
				    	}
				    }
				}
			
				
				 
				return result;
				
			}
	
		}
