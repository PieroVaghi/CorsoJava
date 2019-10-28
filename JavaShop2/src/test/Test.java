package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	private static final int MAX = 90;

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		List<Integer> numeri = new ArrayList<Integer>();
		int n = 0;
		do {
			n = 1 + (int)(Math.random()*MAX);
			if(!numeri.contains(n)) {
				System.out.println(n);
				numeri.add(n);
//				tastiera.nextLine();
			}
		} while(numeri.contains(n) && numeri.size()!=MAX);
		tastiera.close();
	}
}
