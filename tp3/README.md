Kévin MARQUER

#TAA

#TP3
(comprend les trois dossiers tp3 tp3-2, tp3-3)



L'objectif du TP est pour la première partie,
de maitriser l'injection de dépendance.

On a Un application avec 4 acteurs et 2 scénarios
(décris dans le TP)


Cette partie est très simple à réaliser.
Par contre le problème vient des paramètres Map refmag, ref et comptes :

	Je n'arrive pas à mettre des données que se soit directement quand j'initialise le paramètre ou quand je met les donnée dans le fichier .properties

Du coup, on se contentera de message ou on ne pourra pas tester la fonction, mais à priori le code est bon.


Un exemple avec la classe Store :

```java
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

	//!!! du aa un problème avec l'objet Map refmag qui ne veut pas contenir de valeur, 
	//on metta en commentaire dans les fcts les actions fait sur refmag	!!!
	
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
```


La classe Client contient la fonction run() qui sera appelé par SampleSimpleApplication :

```java
package fr.istic.tp3.kevin.marquer.sample.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.istic.tp3.kevin.marquer.sample.simple.client.IRun;

@SpringBootApplication
public class SampleSimpleApplication implements CommandLineRunner{

	@Autowired
	private IRun iRun;
	
	public void run(String... args) throws Exception {
		this.iRun.run();
		
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleSimpleApplication.class, args);
	}
	
}
```

quand je lance SampleSimpleApplication j'obtient le resultat de la fonction run()
(qui affiche le resultat de la fonction getPrice(x)
(par contre vue le problème des Map, on ne trouve qu'un seul résultat 1)




Pour la partie 2 du TP:

dossier tp3-2

J'avoue ne pas très bien comprendre comme ça se passe.

En me basant sur le modèle donné, il faut ajouter la classe
ServiceMonitor.
Et je ne vois pas d'autre différence par rapport au premier modèle, si je lance SampleSimpleApplication, j'obtient le même résultat que pour la première version.
Je pense n'avoir pas saisi ce qui fallait faire.



#Partie 3


Pour cette dernière partie, j'ai récuperer les Classes et leur équivalent Dao et Ressource et en recuperant l'example qui nous est donné (dont l'application.properties).

Je n'arrive pas à le lancé.

