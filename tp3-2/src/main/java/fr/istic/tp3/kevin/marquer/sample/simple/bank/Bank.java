package fr.istic.tp3.kevin.marquer.sample.simple.bank;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class Bank implements Ibank{

	public HashMap<String, Integer> comptes;
	

	public void transfert(String compte1, String compte2, int money) {
		
		int newvalue1 = comptes.get(compte1)-money;
		int newvalue2 = comptes.get(compte2)+money;
		
		comptes.replace(compte1, newvalue1);
		comptes.replace(compte2, newvalue2);
	}

}
