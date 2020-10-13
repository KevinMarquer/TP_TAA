package fr.istic.tp3.kevin.marquer.sample.simple.store;

public interface ILane {

	public void additemToCart(String id, int qte);
	
	public void pay(String adresse, String compteUser);
	
}
