package lp1.g18;



public class Test {
	
	public static void main(String[] args) {
		LP1L1 lp1l1 = new LP1L1();
		LP1L2 lp1l2 = new LP1L2(2);
		Num x = new Num("-111");
		Num y = new Num("222");
		
		System.out.println("running");
		
		Num z = lp1l1.add(x, y);
		
		Num x1 = new Num("111");
		Num y1 = new Num("-222");
		Num s = lp1l1.subtract(x1, y1);
		
		Num x2 = new Num("-21010");
		Num y2 = new Num("-50");
		Num p = lp1l1.product(x2, y2);
		
		Num x3 = new Num("-121");
		Num y3 = new Num("-222");
		Num a = lp1l1.power(x3, 8);
		
		Num x4 = new Num("123", 2);
		Num y4 = new Num("56", 2);
		Num d = lp1l2.divide(x4, y4);
		
		System.out.println(z.toString());
		System.out.println(s.toString());
		System.out.println(p.toString());
		System.out.println(a.toString());
		System.out.println(d.toString());
		//a.printList();
		
//		LP1L2 lp1l2 = new LP1L2();
//		Num b = lp1l2.power(x, lp1l2.new Num(8));
//		System.out.println(b.toString());
		
		
	}
	
	
}
