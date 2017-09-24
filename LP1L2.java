package lp1.g18;

import java.util.LinkedList;

//public class LP1L2 extends LP1L1{
//	Num power(Num x, Num n) {
//		if(n.toString().equals("0")){
//			Num zero = new Num(0);
//			return zero;
//		}
//		if(n.toString().equals("1")){
//			return  x;
//		}
//		else{
//			Num s = power(x, super.divide(n, new Num(2)));
//			if(super.mod(n, new Num(2)).equals(new Num(0))){
//				return super.product(s, s);
//			}
//			else{
//				return product(super.product(s, s), x);
//			}
//		}
//	}
//}

public class LP1L2 extends LP1L1{
	
	public LP1L2() {
		super();
	}
	 
	public LP1L2(int base) {
		super(base);
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
Num one = new Num(1, 2);
Num mid = add(a, one);
mid.list.pollFirst();
 
   while(compare(mid, a) <= 0 && compare(mid, one) >= 0) {
    mid.list.pollFirst();
    mid.printList();
        if(compare(product(mid,b),a) == 0) {
        return mid;
        }
        if(compare(product(mid,b),a) == 1) {
        mid.list.pollFirst();
        mid.printList();
        continue;
        }
        if(compare(product(mid,b),a) == -1) {
        if(compare(product(add(mid,one),b),a) == 1) {
        return mid;
        }else {
        mid = add(a, mid);
        mid.list.pollFirst();
        mid.printList();
        continue;
        }
        }
   }
   return null;
   
}
 
Num mod(Num a, Num b){
return a;
}
 
Num squareRoot(Num a){
return a;
}
 
Num power(Num x, Num n) {
if(n.toString().equals("0")){
Num zero = new Num(0);
return zero;
}
if(n.toString().equals("1")){
return  x;
}
else{
Num s = power(x, divide(n, new Num(2)));
if(mod(n, new Num(2)).equals(new Num(0))){
return super.product(s, s);
}
else{
return product(super.product(s, s), x);
}
}
}
}
