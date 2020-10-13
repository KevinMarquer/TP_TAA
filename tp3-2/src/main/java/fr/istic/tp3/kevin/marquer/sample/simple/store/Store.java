package fr.istic.tp3.kevin.marquer.sample.simple.store;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Component;

import fr.istic.tp3.kevin.marquer.sample.simple.bank.Ibank;
import fr.istic.tp3.kevin.marquer.sample.simple.provider.Iprovider;

@Component
public class Store implements IFastLane, IJustHaveALook, ILane{

	@Autowired
	Ibank ibank;
	@Autowired
	Iprovider iprovider;
	
	//@Value("${name=refmag}")
	public Map<String, Integer> refmag = new HashMap<String, Integer>(); // article -> quantité dispo
	//public TabRef refmag = new TabRef().refmag;
	
	public ArrayList<String> panier = new ArrayList<String>();
	public int prix = 0;
	
	public String compteStore = "456";
	
	public int getPrice(String id) {
		// TODO Auto-generated method stub
		System.out.println("Pas de prix : Construction en cours");
		return 1;
		//return iprovider.getPrice(id);
	}
	
	
	public void additemToCart(String id, int qte) {
		if(isAvailable(id) && refmag.get(id)>=qte) {
		
			panier.add(id);
			prix += getPrice(id)*qte;
			
			refmag.replace(id, refmag.get(id)-qte);
			
			System.out.println("Article ajouté");
		}
		else {
			System.err.println("Qantité trop grande ou plus rien en stock ou article inexistant");
		}
	}
	public void pay(String adresse, String compteUser) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Le panier est valider");
		panier.clear();
		prix = 0;
	}
	public boolean isAvailable(String id) {
		return refmag.get(id) != 0;
	}
	public void oneShotOrder(String id, int qte, String adresse, String compteUser) {
		
		if(refmag.get(id) >= qte && isAvailable(id)) {
			
			ibank.transfert(compteUser, compteStore, qte*iprovider.getPrice(id));
			refmag.replace(id, refmag.get(id)-qte);
			
			System.out.println("La commande a été réalisé :");
			System.out.println("Adresse :"+adresse);
			System.out.println("Commande : "+qte+"  "+id);
			
		}
		else {
			System.err.println("La commande n'est pas réalisé");
		}
		
		
	}
	
}

