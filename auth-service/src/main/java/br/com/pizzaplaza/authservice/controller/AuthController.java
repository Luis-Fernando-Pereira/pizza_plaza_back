package br.com.pizzaplaza.authservice.controller;

import br.com.pizzaplaza.authservice.service.AuthService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@ApplicationScoped
public class AuthController {

    @Inject
    AuthService authService;

    @GET
    @Path("/auth")
    @Produces(MediaType.TEXT_PLAIN)
    public Response auth() {
        return Response.ok(authService.generateJwt()).build();
    }
}
