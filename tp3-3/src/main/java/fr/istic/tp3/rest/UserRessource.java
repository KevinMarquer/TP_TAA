package fr.istic.tp3.rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.tp3.dao.UserDao;
import fr.istic.tp3.test.testjpa.domain.Carte;
import fr.istic.tp3.test.testjpa.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserRessource {

	UserDao userdao = new UserDao();
	
	
	@GET
	  @Path("/{userId}")
	  public User getUserById(@PathParam("petId") Long userId)  {
	      // return pet
	      return new User();
	  }
	
	@POST
	@Consumes("application:json")
	@Path("/delete")
	public String delete(@Parameter(description = "User that need to be deleted", required = true) User user) {
	
	String message = "User delete";
	User userId = userdao.findOne(user.getId());
	userdao.delete(userId);
	
	return message;
	}
	
	@POST
	@Consumes("application:json")
	@Path("/delete/{userId}")
	public String deleteById(@Parameter(description = "User that need to be deleted", required = true)Long userId) {
	
	String message = "User delete by id";
	User  user = userdao.findOne(userId);
	userdao.delete(user);
	
	return message;
	}
	
	@POST
	  @Consumes("application/json")
	  public Response addUser(
	      @Parameter(description = "User object that needs to be added", required = true) User user) {
	    // add user
	    return Response.ok().entity("SUCCESS").build();
	  }
	
	
	@POST
	@Consumes("application/json")
	@Path("/addcarte/userID}/{carteID}")
	public Collection<Carte> addCartetoUser ( @Parameter(description = "User", required = true) Long userId, Long carteId){

		return userdao.addCarteToUser(userId, carteId);
	}
	
	@POST
	@Path("/create/{name}")
	  public String create(@Parameter(description = "User", required = true)String name) {
	    String userId = "";
	    try {
	      User user = new User(name);
	      userdao.save(user);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "Erreur creation d'User : " + ex.toString();
	    }
	    return "User :"+ userId+ " a été créer";
	  }
	
}
