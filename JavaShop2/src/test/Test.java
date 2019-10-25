package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> numeri = new ArrayList<Integer>();
		int n = 0;
		do {
			n = 1 + (int)(Math.random()*16);
			if(!numeri.contains(n)) {
				System.out.println(n);
				numeri.add(n);
			}
		} while(numeri.contains(n) && numeri.size()!=16);
	}
}
