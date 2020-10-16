package fr.istic.tp3.kevin.marquer.sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.tp3.kevin.marquer.sample.simple.store.IFastLane;
import fr.istic.tp3.kevin.marquer.sample.simple.store.IJustHaveALook;
import fr.istic.tp3.kevin.marquer.sample.simple.store.ILane;

@Component
public class Client implements IRun, IClient { 
	
	@Autowired
	IFastLane ifast;
	@Autowired
	ILane ilane;
	@Autowired
	IJustHaveALook ilook;
	
	private String adresse = "6 rue du Bazar";
	private String compteBancaire = "123";
	
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		System.out.println(ilook.getPrice("banane"));
		
	}

}
