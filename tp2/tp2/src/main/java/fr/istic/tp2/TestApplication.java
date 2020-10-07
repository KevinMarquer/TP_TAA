package fr.istic.tp2;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


import fr.istic.tp2.rest.CarteRessource;
import fr.istic.tp2.rest.KanbanRessource;
import fr.istic.tp2.rest.SectionRessource;
import fr.istic.tp2.rest.UserRessource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(KanbanRessource.class);
        clazzes.add(SectionRessource.class);
        clazzes.add(UserRessource.class);
        clazzes.add(CarteRessource.class);
        clazzes.add(OpenApiResource.class);
        

        return clazzes;
    }

}