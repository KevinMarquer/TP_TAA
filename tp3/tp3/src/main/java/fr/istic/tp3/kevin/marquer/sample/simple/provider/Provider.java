package fr.istic.tp3.kevin.marquer.sample.simple.provider;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Provider implements Iprovider{

	//@Value("${name=ref}")
	public Map<String, Integer> ref = new HashMap<String, Integer>(); // article -> prix
	
	//public RefStock ref = new RefStock().refstock;
	
	public void order(String id, int qte) {
		// TODO Auto-generated method stub
		
	}

	public int getPrice(String id) {
		return ref.get(id);
		
	}

}
