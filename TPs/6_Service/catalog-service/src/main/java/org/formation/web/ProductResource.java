package org.formation.web;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.formation.domain.Product;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> list() {
        return Product.listAll();
    }

    @GET
    @Path("/{refProduct}")
    public Product findById(@RestPath String refProduct) {
        Product product = Product.findById(refProduct);
        if (product == null) {
            throw new NotFoundException("Product " + refProduct + " not found");
        }
        return product;
    }
}
