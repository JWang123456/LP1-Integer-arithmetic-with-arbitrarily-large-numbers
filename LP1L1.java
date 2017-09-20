package cs6301.g18;

import java.util.LinkedList;

public class LP1L1 {
	
	public static void main(String[] args) {
		Num x = new Num(999);
		Num y = new Num("8");
		Num z = Num.add(x, y);
		System.out.println(z);
		Num a = Num.power(x, 8);
		System.out.println(a);
		z.printList();
	    }
	
class Num{
		int Base = 10;
		LinkedList<Integer> list = new LinkedList<Integer>();
	
		Num(String s){
			Integer number = Integer.valueOf(s);
			for(int base=10 ; number/base>1 ; base *= 10){
				list.add(number % base);
				number -= number%base;
			}
		}
		Num(long x){
			for(int base=10 ; x/base>1 ; base *= 10){
				list.add(Integer.valueOf((int)(x % base)));
				x -= x%base;
			}
		}
		public String toString(){
			return "yy";
			
		}
		Num add(Num a, Num b){
			
			Num result = new Num(0);
			return result;
		}
		Num subtract(Num a, Num b){
			Num result = new Num(0);
			return result;
		}
		Num product(Num a, Num b){
			Num result = new Num(0);
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
				result1.list.add(0);
				
			}
			for(int i=0 ; i<k ; i++){
				result2.list.add(0);
				
			}
			result =add( add(result1 , result2) , result3);
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
		void printList(){
			System.out.print(Base + " : " );
			for(int i = 0;i < list.size();i ++){
				System.out.print(list.get(i));
			}
			System.out.print("\n");
		}
		Num power(Num x, Num n){
			
		}
		Num divide(Num a, Num b){
			
		}
		Num mod(Num a, Num b){
			
		}
		Num squareRoot(Num a){
			
		}
	}
}
