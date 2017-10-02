package lp1.g18;



public class Test {
	
	public static void main(String[] args) {
		LP1L1 lp1l1 = new LP1L1();
	//	LP1L2 lp1l2 = new LP1L2(2);
		Num x = new Num("111");
		Num y = new Num("222");
		System.out.println(x.toString());
		System.out.println(y.toString());
		
		Num z = lp1l1.add(x, y);
		System.out.println(z.toString());
		
		Num x1 = new Num("-111");
		Num y1 = new Num("222");
		Num s = lp1l1.subtract(x1, y1);
		System.out.println(s.toString());
//		
		Num x2 = new Num("22");
		Num y2 = new Num("5555");
		Num p = lp1l1.product(x2, y2);
		System.out.println(p.toString());
		
		Num x3 = new Num("8080");
		Num a = lp1l1.power(x3, 0);
		System.out.println(a.toString());
		
		Num x5 = new Num("80");
		Num y5 = new Num("0"); 
		Num b  = lp1l1.power(x5, y5);
		System.out.println(b.toString());
		
		
		Num x4 = new Num("11100");
		Num y4 = new Num("-11");
		Num d = lp1l1.divide(x4, y4);
		System.out.println(d.toString());
		
		Num x6 = new Num("11101");
		Num y6 = new Num("11");
		Num m = lp1l1.mod(x6, y6);
		System.out.println(m.toString());
		
	
		
//		LP1L2 lp1l2 = new LP1L2();
//		Num b = lp1l2.power(x, lp1l2.new Num(8));
//		System.out.println(b.toString());
		
		
	}
	
	
}
