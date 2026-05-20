package org.formation.web;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.formation.domain.Stock;
import org.jboss.resteasy.reactive.RestPath;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class StockResource {

    @GET
    @Path("/{refProduct}")
    public Integer available(@RestPath String refProduct) {
        Stock stock = Stock.findById(refProduct);
        if (stock == null) {
            throw new NotFoundException("No stock entry for product " + refProduct);
        }
        return stock.getQuantity();
    }
}
