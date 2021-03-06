
package org.jboss.tools.ws.jaxrs.sample.services;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.jboss.tools.ws.jaxrs.sample.domain.Game;

@Consumes({ APPLICATION_XML })
@Produces({ "application/vnd.bytesparadise.game+xml", "application/xml", "application/json" })
public class GameResource {


	@GET
	@Path("/{id}")
	public Game getProduct(@PathParam("id") Integer id) {
		return null;
	}

	@POST
	@Consumes({ "application/vnd.bytesparadise.game+xml", "application/xml", "application/json" })
	public void createProduct(Game game) {
		throw new WebApplicationException(Status.FORBIDDEN);
	}

}
