Kévin MARQUER

##TAA

#TP2


Dans ce TP nous allons créer un servlet permetant d'afficher dans un tableau Kanban des Carte.
On devra alors donner :
1. La section
2. Un User (dans cette version, si le nom donnée pour l'user ne correspond à aucun dans la liste des User, alors celui-ci est créer)
3. Le motif

On écupère les classes créer du TP1 et on va les associé à des classes Dao.

exemple :
```java
import java.util.Collection;
import java.util.List;

import fr.istic.tp2.dao.generic.AbstractJpaDao;
import fr.istic.tp2.test.testjpa.domain.Carte;
import fr.istic.tp2.test.testjpa.domain.User;

public class UserDao extends AbstractJpaDao<Long, User>{

	public UserDao() {
		super();
		setClazz(User.class);
	}
	
	
	public List<Carte> addCarteToUser(Long userId, Long idCarte){
		CarteDao carteDao = new CarteDao();
		Carte carte = carteDao.findOne(idCarte);
		User user = this.findOne(userId);
		user.getCartes().add(carte);
		carte.setUser(user);
		carteDao.update(carte);
		return user.getCartes();
	}
	
	
	public boolean userExistbyName(String name) {
		boolean recherche = false;
		UserDao userdao = new UserDao();
		for(User user : userdao.findAll()) {
			if(name.equals(user.getFirstName())) {
				recherche = true;
				break;
			}
		}
		return recherche;
	}
	
	public User findUserbyName(String name) {
		UserDao userdao = new UserDao();
		User uresult = new User();
		for(User user : userdao.findAll()) {
			if(name.equals(user.getFirstName())) {
				uresult = user;
				break;
			}
		}
		return uresult;
	}
	
}
```

Pour ce qui est de la Servlet, il est assez simple.

lien url : localhost:8080/tablekanban

Au départ, il y a une initialisation :
Si il n'existe pas de Table (Kanban Section) déjà existante, alors elles sont créer.

L'affichage du tableau kanban se fait simplement:
On créer une fonction permettant l'affichage des donnée de chaque carte dans la bonne section :
(le résultat nous donne des sauts de ligne pour chaque carte)

```java
public String afficheCarte() {
		String res = "";
	
		if(!cartedao.findAll().isEmpty()) {
			
			for(Carte c : cartedao.findAll()) {
				if(c.getSection().getNom().equals("attente")) {
					res += "<tr><th>"+c.afficheCarte()+"</th>"+"<th></th><th></th></tr>"+"\n";
				}
				else if(c.getSection().getNom().equals("encours")) {
					res += "<tr><th></th>"+"<th>"+c.afficheCarte()+"</th>"+"<th></th></tr>"+"\n";
				}
				else if(c.getSection().getNom().equals("fini")) {
					res += "<tr><th></th><th></th>"+"<th>"+c.afficheCarte()+"\n"+"/<tr>";
				}
			}
		}
		
```


On ajoute dans l'affichage, un bouton permettant la création d'une nouvelle Carte.

Lors de la création de la Carte (et de User si créer aussi), on vérifie dans ./show-hsqldb.sh les nouvelles valeurs créer et elles sont dans les Table.

Pour lancé le servlet:
1. ./run-hsqldb-server.sh
2. maven jetty:run
3. localhost:8080/tablekanban




La partie sur JaxRS et OpenAPI n'a pas été réussi.

La création des ClasseRessource n'étant pas trop compliqué à comprendre.
Mais les tests ne marche pas.
