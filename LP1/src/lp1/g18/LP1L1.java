package lp1.g18;


import java.util.LinkedList;

public class LP1L1 {
		
		public static void main(String[] args) {
			Num x = new Num(999);
			Num y = new Num("8");
			System.out.println("running");
			Num z = Num.add(x, y);
			System.out.println(z.toString());
			z.printList();
			System.out.println(z.list);
			Num a = LP1L1.Num.power(x, 8);
			System.out.println(a.list);
			
		    }
		
		static class Num{
			int base = 10;
			LinkedList<Integer> list = new LinkedList<Integer>();
		
			Num(String s){
				Integer number = Integer.valueOf(s);
				while(number%base > 0){
					list.add(number % base);
					number = number/base;
				}
			}
			
			Num(long x){
				while(x%base > 0){
					list.add((int)x % base);
					x = x/base;
				}
			}
			
			public String toString(){
				String res = this.list.toString();
				return res;
				
			}
			static Num add(Num a, Num b){

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
			
			static Num product(Num a, Num b){
				
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
			
			static Num power(Num x, long n){
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
			
			void printList(){
				System.out.print(base + " : " );
				for(int i = 0;i < list.size();i ++){
					System.out.print(list.get(i) + " ");
				}
				System.out.print("\n");
			}
			
			static Num subtract(Num a, Num b){
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
							r = (int)l1.get(i) - (int)l.get(j) + carry;
							carry = 0;
						}else {
							r = 10 + (int)l1.get(i) - (int)l.get(j) + carry;
							carry = -1;
						}
						
						res.add(-r);
						i++;
						j++;
					}
					
					
					while(j<l1.size() && i>=l.size()){
						r = l1.get(i) + carry;
						res.add(-r);
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
								
								res.add(-r);
								i++;
								j++;
							}
							
							
							while(j<l1.size() && i>=l.size()){
								r = l1.get(i) + carry;
								res.add(-r);
								carry = 0;
								j++;
							}
						}
					}
				}
				return result;
			}
				
			
			
			/**Num divide(Num a, Num b){
				
			}
			Num mod(Num a, Num b){
				
			}
			Num squareRoot(Num a){
				
			}**/
		}
	

	}


