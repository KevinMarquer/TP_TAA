Kévin MARQUER

#TP1

Pour ce TP on se doit de créer des classes:

Dans mon cas il y a :

Kanban qui contient une a plusieure Section :

1. Section qui contient un nom, un unique Kanban et une liste de Cartes

2. Carte qui contient une unique section, un User unique et une tache String

3. User qui contient un nom et une liste de Cartes

(note la classe Fiche est celle qui contient tout ce qui a été spécifier dans la descritption du TP et pessant que Fiche et Carte était deux classes différentes, La fiche ne sera pas utilisée)

Les attributs donné au classes sont au minimum, pour une simplification lors de la création de ces derniers.

Dans le cas de la crétion chaque classes c'est simple:
	Ajout d'attribut sans oublier les getter et setter et ne pas oublier les annotations spécifique (@OneToMany ...)
	
exemple User :
```java
ackage fr.istic.tp1.test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	
	private Long id;
	
	private String firstName;
	
	List<Carte> listCarte;

	
	public User(String first) {
		this.firstName=first;
	}
	
	public User() {}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	public List<Carte> getListCarte() {
		return listCarte;
	}

	public void setListCarte(ArrayList<Carte> listCarte) {
		this.listCarte = listCarte;
	}
	
}
```



Puis dans JpaTest, on va créer une fonction servant à la création et liaison des différentes classes :

```java
private void createCarte() {
    	int numOfCartes = manager.createQuery("Select a From Carte a",Carte.class).getResultList().size();
    	if(numOfCartes == 0) {
    		User user = new User("Dan");
    		manager.persist(user);
    		Kanban kanban = new Kanban();
    		manager.persist(kanban);
    		Section attente = new Section("attente",kanban);
    		Section encours = new Section("encours",kanban);
    		Section fini = new Section("fini",kanban);
    		manager.persist(attente);
    		manager.persist(encours);
    		manager.persist(fini);
    		Carte carte1 = new Carte(attente,user,"Test");
    		manager.persist(carte1);
    		Carte carte2 = new Carte(encours,user,"Correction");
    	    manager.persist(carte1);
    		//manager.persist(new Fiche("test", null, null, 10, null, null, null, carte1));
    		//manager.persist(new Fiche("test2", null, null, 10, null, null, null, carte2));
    		
    		
    	}
    }
```

que l'on place dans le main : 

```java
public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        
        EntityManager manager = factory.createEntityManager();
        
        JpaTest test = new JpaTest(manager);
        
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        try {
           test.createCarte();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        
        test.listCarte();
        
        manager.close();
        factory.close();
```


Lors du test, on lance ./run-hsqldb-server.sh puis on lance JpaTest.java et les Tables sont créer.

On vérifie avec ./show-hsqldb.sh et les Tables sont visible.
On peut lancé une requête pour vérifier se qu'il y a à l'intérieur des Table (Select * from User)
