package br.com.pizzaplaza.authservice.controller;

import br.com.pizzaplaza.authservice.service.UserService;
import br.com.pizzaplaza.entity.dto.UserDto;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/user")
public class UserController {

    @Inject
    UserService userService;

    @Path("/client")
    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newClient(@Valid UserDto userDto) {
        userDto = userService.save(userDto);
        return Response.ok(userDto).build();
    }

    @Path("admin")
    @POST
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newAdmin(UserDto userDto) {
        return Response.ok().build();
    }

    @Path("seller")
    @POST
    @RolesAllowed({"admin", "seller"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newSeller(UserDto userDto) {
        return Response.ok().build();
    }
}
