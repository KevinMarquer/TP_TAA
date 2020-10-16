package fr.istic.tp3.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.tp3.dao.KanbanDao;
import fr.istic.tp3.test.testjpa.domain.Kanban;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/kanban")
@Produces({"application/json", "application/xml"})
public class KanbanRessource {

	KanbanDao kanbandao = new KanbanDao();
	
	@GET
	  @Path("/{kanbanId}")
	  public Kanban getKanbanById(@PathParam("kanbanId") Long kanbanId)  {
	      // return Kanban
	      return kanbandao.findOne(kanbanId);
	  }

	  @POST
	  @Consumes("application/json")
	  public Response addKanban(
	      @Parameter(description = "Kanban object", required = true) Kanban kanban) {
	    // add Kanban
		  kanbandao.save(kanban);
		  
	    return Response.ok().entity("SUCCESS").build();
	  }
	
}
