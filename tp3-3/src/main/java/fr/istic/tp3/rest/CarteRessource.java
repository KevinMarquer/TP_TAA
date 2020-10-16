package fr.istic.tp3.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.tp3.dao.CarteDao;
import fr.istic.tp3.test.testjpa.domain.Carte;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/carte")
@Produces({"application/json", "application/xml"})
public class CarteRessource {

}
