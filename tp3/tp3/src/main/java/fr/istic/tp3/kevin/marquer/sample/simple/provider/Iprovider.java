package fr.istic.tp3.kevin.marquer.sample.simple.provider;

public interface Iprovider {

	public int getPrice(String id);
	
	public void order(String id,int qte);
}
