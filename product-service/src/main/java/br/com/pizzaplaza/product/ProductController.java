package br.com.pizzaplaza.product;

import br.com.pizzaplaza.entity.dto.ProductDto;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("/product")
public class ProductController {

    List<ProductDto> products = new ArrayList<>();

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(products).build();
    }

    @POST
    @RolesAllowed({"admin", "seller"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(ProductDto productDto) {
        products.add(productDto);

        try {
            return Response.created(new URI("http://localhost:8083/product/")).build();
        } catch (URISyntaxException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("{oid}")
    public Response delete(@PathParam("oid") Long oid) {
        products.stream()
                .filter(productDto -> productDto.id == oid)
                .findFirst()
                .ifPresent(product -> products.remove(product));

        return Response.noContent().build();
    }
}
