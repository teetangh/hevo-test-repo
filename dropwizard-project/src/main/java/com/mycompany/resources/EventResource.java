package com.mycompany.resources;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mycompany.api.Event;
import com.mycompany.core.EventRepository;

import io.dropwizard.jersey.params.LongParam;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    private EventRepository repository;

    public EventResource(EventRepository repository) {
        this.repository = repository;
    }

    // @GET
    // public List<Event> allEvents() {
    // Event e = new Event();
    // e.setDate(new Date());
    // e.setName("Birthday");
    // e.setId(1L);
    // e.setDescription("Please be on time!");
    // e.setLocation("221B Baker Street");

    // return Collections.singletonList(e);
    // }

    @PermitAll
    @GET
    public List<Event> allEvents() {
        return repository.findAll();
    }

    @RolesAllowed({ "ADMIN" })
    @GET
    @Path("{id}")
    public Event event(@PathParam("id") LongParam id) {
        return repository.findById(id.get())
                .orElseThrow(() -> new WebApplicationException("Event not found", 404));
    }

    @RolesAllowed({ "ADMIN" })
    @POST
    public Event create(Event event) {
        return repository.save(event);
    }

    @RolesAllowed({ "ADMIN" })
    @PUT
    @Path("{id}")
    public Event update(@PathParam("id") LongParam id, Event event) {
        return repository.update(id.get(), event)
                .orElseThrow(() -> new WebApplicationException("Event not found", 404));
    }

    @RolesAllowed({ "ADMIN" })
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        repository.delete(id.get());
        return Response.ok().build();
    }

}