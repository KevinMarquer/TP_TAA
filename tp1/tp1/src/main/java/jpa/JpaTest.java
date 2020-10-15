package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tp1.test.testjpa.domain.Carte;
import fr.istic.tp1.test.testjpa.domain.Fiche;
import fr.istic.tp1.test.testjpa.domain.Kanban;
import fr.istic.tp1.test.testjpa.domain.Section;
import fr.istic.tp1.test.testjpa.domain.User;

public class JpaTest {

	private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

	
    /**
     * @param args
     */
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
    }
    
    private void createSection() {
    	int numOfSection= manager.createQuery("Select a From Section a",Carte.class).getResultList().size();
    	if(numOfSection == 0) {
    		//User user = new User("Dan");
    		Kanban kanban = new Kanban();
    		
    		Section attente = new Section("attente",kanban);
    		Section encours = new Section("encours",kanban);
    		Section fini = new Section("fini",kanban);
    		manager.persist(attente);
    		manager.persist(encours);
    		manager.persist(fini);
    		
    		
    		
    	}
    }
    
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
    
    public void listCarte() {
    	List<Carte> resultList = manager.createQuery("Select a From Carte a",Carte.class).getResultList();
    	System.out.println("num of cartes : "+ resultList.size());
    	for(Carte next : resultList) {
    		System.out.println("next Carte: " + next.getId());
    	}
    }
    

}
