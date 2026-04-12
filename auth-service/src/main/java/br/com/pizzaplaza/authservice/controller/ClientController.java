package br.com.pizzaplaza.authservice.controller;

import br.com.pizzaplaza.authservice.repository.ClientRepository;
import br.com.pizzaplaza.entity.dto.UserDto;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/clients")
@ApplicationScoped
public class ClientController {

    @Inject
    ClientRepository clientRepository;

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok(clientRepository.findAll()).build();
    }

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(UserDto dto) {



        return Response.created(URI.create("/client/id")).build();
    }
}
