package cs6301.g18;


public class LP1L2 extends LP1L1{
	Num power(Num x, Num n) {
		if(n.toString().equals("0")){
			Num zero = new Num(0);
			return zero;
		}
		if(n.toString().equals("1")){
			return  x;
		}
		else{
			Num s = power(x, super.divide(n, new Num(2)));
			if(super.mod(n, new Num(2)).equals(new Num(0))){
				return super.product(s, s);
			}
			else{
				return product(super.product(s, s), x);
			}
		}
	}
}
