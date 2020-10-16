package fr.istic.tp3.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.tp3.dao.SectionDao;
import fr.istic.tp3.test.testjpa.domain.Kanban;
import fr.istic.tp3.test.testjpa.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/section")
@Produces({"application/json", "application/xml"})
public class SectionRessource {

	SectionDao sectionDAO = new SectionDao();
	
	@GET
	  @Path("/{sectionId}")
	  public Section getSectionById(@PathParam("sectionId") Long sectionId)  {
	      // return section
	      return sectionDAO.findOne(sectionId);
	  }

	  @POST
	  @Consumes("application/json")
	  public Response addSection(
	      @Parameter(description = "Section object", required = true) Section section) {
	    // add Kanban
		  sectionDAO.save(section);
		  
	    return Response.ok().entity("SUCCESS").build();
	  }
	  
	  

	  
	
}
