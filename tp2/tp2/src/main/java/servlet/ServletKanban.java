package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.tp2.dao.CarteDao;
import fr.istic.tp2.dao.KanbanDao;
import fr.istic.tp2.dao.SectionDao;
import fr.istic.tp2.dao.UserDao;
import fr.istic.tp2.test.testjpa.domain.Carte;
import fr.istic.tp2.test.testjpa.domain.Kanban;
import fr.istic.tp2.test.testjpa.domain.Section;
import fr.istic.tp2.test.testjpa.domain.User;

@WebServlet(name="tablekanban",
urlPatterns={"/tablekanban"})
public class ServletKanban extends HttpServlet{

	KanbanDao kanbandao = new KanbanDao();
	SectionDao sectiondao= new SectionDao();
	UserDao userdao = new UserDao();
	CarteDao cartedao = new CarteDao();
	
	public void init() throws ServletException {
		
		if(sectiondao.isEmpty()) {
			
			Section attente = new Section("attente");
			Section encours = new Section("encours");
			Section fini = new Section("fini");
			sectiondao.save(attente);
			sectiondao.save(encours);
			sectiondao.save(fini);
			List<Section> sections = new ArrayList<Section>();
			sections.add(attente);
			sections.add(encours);
			sections.add(fini);
			Kanban kanban = new Kanban();
			kanban.setSections(sections);
			kanbandao.save(kanban);
			User user = new User("Kevin");
			userdao.save(user);
		}
		
	}
	
	public String afficheCol() {
		String res = "";
		for(Section i : sectiondao.findAll()) {
			res+= "<th>"+i.getNom()+"</th>";
		}
		return res;
	}
	
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
		
		
		return res;
	}
	
	public String afficheUser() {
		String res = "";
		for(User u : userdao.findAll()) {
			res+= u.getFirstName()+"     ";
		}
		
		return res;
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print(
        "<!DOCTYPE html><HTML  lang=\"en\">\n"+
        "<head>\n" + 
		" <meta charset=\"UTF-8\">\n" + 
		" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
		" <title>Kanban</title>\n" + 
		"</head>"+
		"<BODY>"+
		"<h1> Kanban </h1>"+
		"<table><tr>"+afficheCol()+"</tr>"+
		afficheCarte()+
		"</tr><table>"+
		"\n"+
		"<FORM Method=\"POST\" Action=\"/tablekanban\" accept-charset=\"UTF-8\" >\n" + 
		"tache :         <INPUT type=\"text\" size=\"20\" name=\"tache\"><BR>\n" + 
		"User :     <INPUT type=\"text\" size=\"20\" name=\"firstName\"><BR>\n" + 
		
					"<input type=\"radio\"\n" + 
					"  name=\"choix\"\n" + 
					"  value=\"attente\"> Attente\n" + 
					"<input type=\"radio\"\n" + 
					"  name=\"choix\"\n" + 
					"  value=\"encours\"> En_cours"+
					"<input type=\"radio\"\n" + 
					"  name=\"choix\"\n" + 
					"  value=\"fini\"> Fini"+
		"        <INPUT type=submit value=Send>\n"+
					
		/*"Create new user\n"+
		"<FORM Method=\"POST\" Action=\"/tablekanban\" accept-charset=\"UTF-8\" >\n" + 
		"New User : <INPUT type=\"text\" size=\"20\" name=\"firstName\"><BR>\n" + 
		"        <INPUT type=submit value=Send>\n"+*/
		"</BODY></HTML>");
        
        p.flush();
        
    }
	
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");

		
		Section sect = new Section();
		for(Section i : sectiondao.findAll()) {
			if(i.getNom().equals(request.getParameter("choix"))) {
				sect = i;
			}
		}
		
		//User us = new User();
		if(userdao.userExistbyName(request.getParameter("firstName"))) {
			User us  = userdao.findUserbyName(request.getParameter("firstName"));
			Carte carte = new Carte(sect, us, request.getParameter("tache"));
			carte.setUser(us);
			carte.setSection(sect);
			cartedao.save(carte);
		}
		else {	//version : on créer s'il n'existe pas
			User us  = new User(request.getParameter("firstName"));
			userdao.save(us);
			Carte carte = new Carte(sect, us, request.getParameter("tache"));
			carte.setUser(us);
			carte.setSection(sect);
			cartedao.save(carte);
		}
		
		
		
		
	    response.sendRedirect("/tablekanban");
	    
	    	
    }
	
}
