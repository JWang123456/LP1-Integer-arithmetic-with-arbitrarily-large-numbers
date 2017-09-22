package cs6301.g18;

import cs6301.g18.LP1L1.Num;

public class Test {
	
	public static void main(String[] args) {
		LP1L1 lp1l1 = new LP1L1();
		Num y = lp1l1.new Num(999);
		Num x = lp1l1.new Num("8");
		System.out.println("running");
		Num z = lp1l1.add(x, y);
		Num s = lp1l1.subtract(x, y);
		Num p = lp1l1.product(x, y);
		
		System.out.println(z.toString());
		System.out.println(s.toString());
		System.out.println(p.toString());
		Num a = lp1l1.power(x, 8);
		a.printList();
		
//		LP1L2 lp1l2 = new LP1L2();
//		Num b = lp1l2.power(x, lp1l2.new Num(8));
//		System.out.println(b.toString());
		
		
	}
	
	
}
