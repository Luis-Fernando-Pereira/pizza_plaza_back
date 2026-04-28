package br.com.pizzaplaza.userservice.controller;

import br.com.pizzaplaza.authservice.service.UserService;
import br.com.pizzaplaza.authservice.strategies.AdminStrategy;
import br.com.pizzaplaza.authservice.strategies.ClientStrategy;
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

import java.net.URI;
import java.util.HashMap;
import java.util.NoSuchElementException;

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
        try {

            userDto = userService.save(userDto, new ClientStrategy());

            return Response.created(new URI(userDto.getLink())).build();

        } catch (Exception e) {

            return Response.ok(e.getMessage()).build();

        }
    }

    @Path("admin")
    @POST
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newAdmin(@Valid UserDto userDto) {
        try {

            userDto = userService.save(userDto, new AdminStrategy());
            return Response.created(new URI(userDto.getLink())).build();

        } catch (NoSuchElementException e) {

            System.out.println("Erro: este endpoint não suporta este tipo de usuário");
            return Response.status(400, e.getMessage()).build();

        } catch (Exception e) {

            System.out.println(e.getCause().getCause().getCause());

            HashMap hashMap = new HashMap();
            hashMap.put("Erro", e.getCause().getCause().getMessage());

            return Response.ok(hashMap).build();

        }
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
