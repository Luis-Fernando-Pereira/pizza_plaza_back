package br.com.pizzaplaza.authservice;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@ApplicationScoped
public class AuthController {

    @Inject
    AuthService authService;

    @Path("/auth")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response auth() {
        return Response.ok(authService.generateJwt()).build();
    }
}
