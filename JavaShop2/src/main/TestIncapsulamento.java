package main;

import entities.Prodotto;

public class TestIncapsulamento {

	public static void main(String[] args) {
		Prodotto p = new Prodotto(1,"Candy", "LavatriceFantasma",300);
		System.out.println(p.getPrezzobase());
		p.setPrezzo(-1000);
		System.out.println("bnfuilednhuficnlzsehfuevnilaguyerilvnaf: " + p.getPrezzobase());
		p.setPrezzo(100);
		System.out.println("boffonchiare: " + p.getPrezzobase());
	}

}
